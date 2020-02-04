package com.xrea.s8.otokiti.calil.service;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xrea.s8.otokiti.calil.App;
import com.xrea.s8.otokiti.calil.entity.BookEntity;
import com.xrea.s8.otokiti.calil.entity.ProxyEntity;
import com.xrea.s8.otokiti.calil.entity.ResultEntity;
import com.xrea.s8.otokiti.calil.entity.calil.Book;
import com.xrea.s8.otokiti.calil.entity.calil.CalilConst;
import com.xrea.s8.otokiti.calil.entity.calil.CalilLibrary;
import com.xrea.s8.otokiti.calil.entity.calil.CalilResult;
import com.xrea.s8.otokiti.calil.entity.calil.Libkey;
import com.xrea.s8.otokiti.calil.entity.calil.Systems;
import com.xrea.s8.otokiti.calil.entity.geocoding.Coordinate;
import com.xrea.s8.otokiti.calil.entity.geocoding.Geocoding;
import com.xrea.s8.otokiti.calil.entity.geocoding.GeocodingResult;
import com.xrea.s8.otokiti.calil.entity.iis.DcndlBibResource;
import com.xrea.s8.otokiti.calil.entity.iis.DctermsIdentifier;
import com.xrea.s8.otokiti.calil.entity.iis.Iis;
import com.xrea.s8.otokiti.calil.entity.iis.Record;
import com.xrea.s8.otokiti.calil.entity.iis.RecordData;

/**
 * 汎用サービス.
 */
public final class AppService {
	// プロキシ情報
	ProxyEntity propertyEntity;
	// 位置情報のキャッシュ
	private Map<String, GeocodingResult> geocodingResultMap;
	// 図書館一覧のキャッシュ
	private Map<Coordinate,List<CalilLibrary>> resultEntityMap;
	// 書籍一覧のキャッシュ
	private Map<String, List<BookEntity>> bookEntityMap;

	/**
	 * コンストラクタ.
	 */
	public AppService() {
		// プロキシ情報の取得
		PropertyIOService propertyIOService = new PropertyIOService();
		this.propertyEntity = propertyIOService.loadConfig(App.PROXY_FILE);
	}

	/**
	 * クライアント設定の取得.
	 *
	 * @return クライアント設定
	 */
	private CloseableHttpClient getHttpClient() {
		if (this.propertyEntity == null) {
			// プロキシ設定なし
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(App.TIMEOUT).setSocketTimeout(App.TIMEOUT).setConnectTimeout(App.TIMEOUT).build();
			return HttpClients.custom().setDefaultRequestConfig(config).build();

		} else {
			// プロキシ設定あり
			HttpHost proxy = new HttpHost(this.propertyEntity.getUrl(), Integer.parseInt(this.propertyEntity.getPort()));
			RequestConfig config = RequestConfig.custom().setProxy(proxy).setSocketTimeout(App.TIMEOUT).setConnectTimeout(App.TIMEOUT).build();

			if (StringUtils.isEmpty(this.propertyEntity.getUser())) {
				// 認証なし
				return HttpClients.custom().setDefaultRequestConfig(config).build();

			} else {
				// 認証あり
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(new AuthScope(proxy), new UsernamePasswordCredentials(this.propertyEntity.getUser(), this.propertyEntity.getPass()));
				return HttpClients.custom().setDefaultCredentialsProvider(credsProvider).setDefaultRequestConfig(config).build();
			}
		}
	}

	/**
	 * 位置情報の取得.
	 *
	 * @param addrStr 住所
	 * @return 位置情報
	 */
	public GeocodingResult getCoordinateEntity(final String addrStr) {
		if (this.geocodingResultMap == null) {
			this.geocodingResultMap = new HashMap<>();
		} else if (this.geocodingResultMap.containsKey(addrStr)) {
			return this.geocodingResultMap.get(addrStr);
		}
		Geocoding entity = new Geocoding();
		HttpGet httpGet = new HttpGet(App.GEOCODING_API_URL + addrStr);
		try (CloseableHttpClient httpClient = this.getHttpClient();
				CloseableHttpResponse response = httpClient.execute(httpGet)){
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
				ObjectMapper mapper = new ObjectMapper();
				entity = mapper.readValue(XML.toJSONObject(new StringReader(result)).toString(), Geocoding.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.geocodingResultMap.put(addrStr, entity.getResult());
		return entity.getResult();
	}

	/**
	 * 図書館一覧の取得.
	 *
	 * @param coordinate 位置情報
	 * @return 図書館情報
	 */
	public List<CalilLibrary> getLibraries(final Coordinate coordinate) {
		if (this.resultEntityMap == null) {
			this.resultEntityMap = new HashMap<>();
		} else if (this.resultEntityMap.containsKey(coordinate)) {
			return this.resultEntityMap.get(coordinate);
		}
		List<CalilLibrary> entities = new ArrayList<>();
		HttpGet httpGet = new HttpGet(App.CALIL_API_LIB_URL + coordinate.getLng() + "," + coordinate.getLat());
		try (CloseableHttpClient httpClient = this.getHttpClient();
				CloseableHttpResponse response = httpClient.execute(httpGet)){
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

				JSONArray array = new JSONArray(result);
				ObjectMapper mapper = new ObjectMapper();
				for (Object obj : array) {
					entities.add(mapper.readValue(new StringReader(obj.toString()), CalilLibrary.class));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.resultEntityMap.put(coordinate, entities);
		return entities;
	}

	/**
	 * 書籍一覧を取得.
	 *
	 * @param title タイトル
	 * @return 書籍一覧
	 * @throws SocketTimeoutException
	 */
	public List<BookEntity> getBookEntity(final String titleStr) throws SocketTimeoutException {
		List<BookEntity> entities = new ArrayList<>();
		URLCodec codec = new URLCodec();

		ObjectMapper mapper = new ObjectMapper();
		// 空のJSON配列値(つまり、[])をNULLとしてPOJOにバインドできるように有効にできる機能。
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		// JSONの空の文字列値("")をnullとしてPOJOにバインドできるように有効にできる機能。
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		// Javaコレクション(配列、java.util.Collection)タイプで動作するために非配列(JSONで)値を強制することが許容されるかどうかを決定する機能。
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		for (String param : App.IIS_API_URL3) {
			for (String param2 : App.IIS_API_URL2) {
				try {
					String url = App.IIS_API_URL1 + param2 + codec.encode(param + "\"" + titleStr + "\"", "UTF8").replace("+", "%20").replace("%2F", "/");
					HttpPost httpPost = new HttpPost(url);
					if (this.bookEntityMap == null) {
						this.bookEntityMap = new HashMap<>();
					} else if (this.bookEntityMap.containsKey(url)) {
						entities.addAll(this.bookEntityMap.get(url));
						continue;
					}

					List<BookEntity> entities2 = new ArrayList<>();
					try (CloseableHttpClient httpClient = this.getHttpClient();
							CloseableHttpResponse response = httpClient.execute(httpPost)){
						if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
							String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

							Iis iis = mapper.readValue(XML.toJSONObject(new StringReader(result)).toString(), Iis.class);

							if (iis.getSearchRetrieveResponse().getRecords() == null || iis.getSearchRetrieveResponse().getNextRecordPosition() == 0) {
								break;
							}
							for (Record record : iis.getSearchRetrieveResponse().getRecords().getRecord()) {
//System.out.println(XML.toJSONObject(record.getRecordData()).toString());
								RecordData recordData = mapper.readValue(XML.toJSONObject(new StringReader(record.getRecordData())).toString(), RecordData.class);
								DcndlBibResource dcndlBibResource = recordData.getRdfRDF().getDcndlBibResource();
								BookEntity bookEntity = this.getBookEntity(dcndlBibResource);
								if (bookEntity != null) {
									if (!entities.contains(bookEntity)) {
										entities2.add(bookEntity);
									}
								}
							}
						}
						this.bookEntityMap.put(url, entities2);
						entities.addAll(entities2);
					} catch (SocketTimeoutException e) {
						throw e;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return entities;
	}

	/**
	 * BookEntityを取得する.
	 *
	 * @param dcndlBibResource DcndlBibResource
	 * @return BookEntity
	 */
	private BookEntity getBookEntity(DcndlBibResource dcndlBibResource) {
		String isbn = this.getIsbn(dcndlBibResource);
		if (StringUtils.isEmpty(isbn)) {
			return null;
		}
		BookEntity bookEntity = new BookEntity();
		bookEntity.setPublisher(this.getPublisher(dcndlBibResource));
		bookEntity.setTitle(this.getTitle(dcndlBibResource));
		bookEntity.setPublicationDate(this.getPublicationDate(dcndlBibResource));
		bookEntity.setIsbn(isbn);
		return bookEntity;
	}

	/**
	 * 蔵書情報から書名を取得する.
	 *
	 * @param resource 蔵書情報
	 * @return 書名
	 */
	private String getTitle(final DcndlBibResource resource) {
		return StringUtils.defaultString(resource.getDctermsTitle());
	}

	/**
	 * 蔵書情報から出版社を取得する.
	 *
	 * @param resource 蔵書情報
	 * @return 出版社
	 */
	private String getPublisher(final DcndlBibResource resource) {
		if (resource.getDctermsPublisher() != null && resource.getDctermsPublisher().get(0).getFoafAgent() != null && resource.getDctermsPublisher().get(0).getFoafAgent().getFoafName() != null) {
			return resource.getDctermsPublisher().get(0).getFoafAgent().getFoafName();
		} else {
			return "";
		}
	}

	/**
	 * 蔵書情報からISBNを取得する.
	 *
	 * @param resource 蔵書情報
	 * @return ISBN
	 */
	private String getIsbn(final DcndlBibResource resource) {
		if (resource.getDctermsIdentifier() != null) {
			for (DctermsIdentifier identifier : resource.getDctermsIdentifier()) {
				if (StringUtils.equals(App.IIS_ISBN_DATA_TYPE, identifier.getRdfDatatype())) {
					return identifier.getContent().replaceAll("-", "");
				}
			}
		}
		return "";
	}

	/**
	 * 蔵書検索結果の取得.
	 *
	 * @param libraries 図書館一覧
	 * @param isbn ISBN
	 * @return 蔵書検索結果
	 */
	public List<ResultEntity> getResultEntity(final List<CalilLibrary> libraries, final String isbn) {
		List<ResultEntity> result = new ArrayList<>();
		int resultCnt = 0;
		for (CalilLibrary library : libraries) {
			if (resultCnt <= (App.SHOW_DISP_POINT * 3)) {
				Systems system = this.getSystem(library.getSystemid(), isbn);
				if (system == null) {
					continue;
				}
				if (!(StringUtils.equals("OK", system.getStatus()) || StringUtils.equals("Cache", system.getStatus()))) {
					// ステータスが「OK」「Cache」以外は除外
					continue;
				}
				// 不要な図書館キーの削除
				system.getLibkey().removeIf(libkey -> !StringUtils.equals(library.getLibkey(), libkey.getName()));
				// 取得内容を元にポイント付け
				for (Libkey libkey : system.getLibkey()) {
					if (StringUtils.equals(library.getLibkey(), libkey.getName())) {
						resultCnt += this.getLoanStatusPoint(libkey.getValue());

						ResultEntity entity = new ResultEntity();
						entity.setLibrary(library);
						entity.setSystem(system);
						result.add(entity);
					}
				}
			}
		}
		return result;
	};

	/**
	 * 蔵書情報から出版年月日を取得する.
	 * @param resource 蔵書情報
	 * @return ISBN
	 */
	private String getPublicationDate(final DcndlBibResource resource) {
		if (resource.getDctermsIdentifier() != null) {
			if (resource.getDctermsIssued() != null && resource.getDctermsIssued().get(0).getContent() !=null) {
				return resource.getDctermsIssued().get(0).getContent();
			}
		}
		return "";
	}

	/**
	 * 取得結果の取得.
	 *
	 * @param systemid システムID
	 * @param isbn ISBN
	 * @return 取得結果
	 */
	private Systems getSystem(final String systemid, final String isbn) {
		HttpGet httpGet = new HttpGet(App.CALIL_API_BOOK_URL1 + systemid + App.CALIL_API_BOOK_URL2 + isbn);
		try (CloseableHttpClient httpClient = this.getHttpClient();
				CloseableHttpResponse response = httpClient.execute(httpGet)){
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
				CalilResult entity = this.convertCalilResult(result);
				if (StringUtils.equals(CalilConst.CONTINUE_TYPE_TRUE, entity.getContinueType())) {
					return this.getSystem(entity.getSession());
				}
				return entity.getBook().get(0).getSystem();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取得結果の取得.
	 *
	 * @param session セッション
	 * @return 取得結果
	 */
	private Systems getSystem(final String session) {
		try {
			Thread.sleep(App.RETRY);
		} catch (InterruptedException e) {
		}

		HttpGet httpGet = new HttpGet(App.CALIL_API_BOOK_URL3 + session);
		try (CloseableHttpClient httpClient = this.getHttpClient();
				CloseableHttpResponse response = httpClient.execute(httpGet)){
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
				CalilResult entity = this.convertCalilResult(result);
				if (StringUtils.equals(CalilConst.CONTINUE_TYPE_TRUE, entity.getContinueType())) {
					return this.getSystem(session);
				}
				return entity.getBook().get(0).getSystem();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * XML文書から取得結果を取得する.
	 *
	 * @param xmlstr XML文書
	 * @return 取得結果
	 */
	private CalilResult convertCalilResult(final String xmlstr) {
		try {
			Document document= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlstr)));
			Element root = document.getDocumentElement();
			return this.getCalilResult(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CalilResult();
	}

	/**
	 * CalilResultの取得.
	 *
	 * @param element Element
	 * @return CalilResult
	 */
	private CalilResult getCalilResult(final Element element) {
		CalilResult result = new CalilResult();
		for (Element childElement : this.getChildElementList(element)) {
			if (childElement.getNodeName().equals("session")) {
				result.setSession(childElement.getTextContent());
			} else if (childElement.getNodeName().equals("continue")) {
				result.setContinueType(childElement.getTextContent());
			} else if (childElement.getNodeName().equals("books")) {
				result.setBook(this.getBooks(childElement));
			}
		}
		return result;
	}

	/**
	 * Booksの取得.
	 *
	 * @param element Element
	 * @return Books
	 */
	private List<Book> getBooks(final Element element) {
		List<Book> bookList = new ArrayList<>();
		for (Element childElement : this.getChildElementList(element)) {
			if (childElement.getNodeName().equals("book")) {
				bookList.add(this.getBook(childElement));
			}
		}
		return bookList;
	}

	/**
	 * Bookの取得.
	 *
	 * @param element Element
	 * @return Book
	 */
	private Book getBook(final Element element) {
		Book book = new Book();
		book.setIsbn(element.getAttribute("isbn"));
		book.setCalilurl(element.getAttribute("calilurl"));
		for (Element childElement : this.getChildElementList(element)) {
			book.setSystem(this.getSystems(childElement));
		}
		return book;
	}

	/**
	 * Systemsの取得.
	 *
	 * @param element Element
	 * @return Systems
	 */
	private Systems getSystems(final Element element) {
		Systems system = new Systems();
		system.setSystemid(element.getAttribute("systemid"));
		for (Element childElement : this.getChildElementList(element)) {
			if (childElement.getNodeName().equals("status")) {
				system.setStatus(childElement.getTextContent());
			} else if (childElement.getNodeName().equals("reserveurl")) {
				system.setReserveurl(childElement.getTextContent());
			} else if (childElement.getNodeName().equals("libkeys")) {
				system.setLibkey(this.getLibkeys(childElement));
			}
		}
		return system;
	}

	/**
	 * Libkeysの取得.
	 *
	 * @param element Element
	 * @return Libkeys
	 */
	private List<Libkey> getLibkeys(final Element element) {
		List<Libkey> libkeyList = new ArrayList<>();
		for (Element childElement : this.getChildElementList(element)) {
			if (childElement.getNodeName().equals("libkey")) {
				libkeyList.add(this.getLibkey(childElement));
			}
		}
		return libkeyList;
	}

	/**
	 * Libkeyの取得.
	 *
	 * @param element Element
	 * @return Libkey
	 */
	private Libkey getLibkey(final Element element) {
		Libkey libkey = new Libkey();
		libkey.setName(element.getAttribute("name"));
		libkey.setValue(element.getTextContent());
		return libkey;
	}

	/**
	 * 子階層のElementを取得する.
	 *
	 * @param element Element
	 * @return 子階層のElement
	 */
	private List<Element> getChildElementList(final Element element) {
		List<Element> list = new ArrayList<>();
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				list.add((Element) node);
			}
		}
		return list;
	}

	/**
	 * 貸出状況ポイント取得.
	 *
	 * @param loanStatus 貸出状況
	 * @return 貸出状況ポイント
	 */
	private int getLoanStatusPoint(final String loanStatus) {
		if (StringUtils.isEmpty(loanStatus)) {
			return 0;
		} else if (StringUtils.equals("貸出可", loanStatus)) {
			return 3;
		} else if (StringUtils.equals("蔵書あり", loanStatus)) {
			return 2;
		} else if (StringUtils.equals("館内のみ", loanStatus)) {
			return 2;
		} else if (StringUtils.equals("貸出中", loanStatus)) {
			return 1;
		} else if (StringUtils.equals("予約中", loanStatus)) {
			return 1;
		} else if (StringUtils.equals("準備中", loanStatus)) {
			return 0;
		} else if (StringUtils.equals("休館中", loanStatus)) {
			return 0;
		} else if (StringUtils.equals("蔵書なし", loanStatus)) {
			return 0;
		} else {
			return 0;
		}
	}

	/**
	 * 蔵書検索結果からテーブル表示用にデータを成形する.
	 *
	 * @param resultEntity 蔵書検索結果
	 * @return テーブル表示用データ
	 */
	public Object[] getTableDate(final ResultEntity resultEntity) {
		CalilLibrary library = resultEntity.getLibrary();
		Systems system = resultEntity.getSystem();

		URL url = null;
		if (!StringUtils.isEmpty(system.getReserveurl())) {
			try {
				url = new URL(system.getReserveurl());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new Object[] {
			CalilConst.Category.get(library.getCategory()),
			library.getPost() + " " + library.getAddress(),
			library.getFormal(),
			MessageFormat.format("{0,number,0.00}", Double.parseDouble(library.getDistance())) + " km",
			system.getLibkey().get(0).getValue(),
			url
		};
	}

	/**
	 * 蔵書検索結果からテーブル表示用にデータを成形する.
	 *
	 * @param bookEntity 蔵書検索結果
	 * @return テーブル表示用データ
	 */
	public Object[] getTableDate(final BookEntity bookEntity) {
		return new Object[] {
			bookEntity.getPublisher(),
			bookEntity.getTitle(),
			bookEntity.getPublicationDate(),
			bookEntity.getIsbn()
		};
	}
}
