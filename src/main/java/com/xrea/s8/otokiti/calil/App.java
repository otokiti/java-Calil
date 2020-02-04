package com.xrea.s8.otokiti.calil;

import java.awt.EventQueue;

/**
 * 図書検索.
 */
public final class App {
	/** タイトル */
	public static final String TITLE = "図書検索";
	/** タイムアウト(秒) */
	public static final int TIMEOUT = 30 * 1000;
	/** 検索リトライ間隔(秒) */
	public static final int RETRY = 3 * 1000;
	/** プロキシ設定ファイル名 */
	public static final String PROXY_FILE = "proxy.txt";
	/** 「カーリル」アプリケーションキー */
	public static final String CALIL_APP_KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXXX";
	/** 「Geocoding API」検索アドレス */
	public static final String GEOCODING_API_URL = "https://www.geocoding.jp/api/?q=";
	/** 「カーリル」図書館検索アドレス  */
	public static final String CALIL_API_LIB_URL = "http://api.calil.jp/library?appkey=" + CALIL_APP_KEY + "&limit=20&format=json&callback=&geocode=";
	/** 「カーリル」蔵書検索アドレス１ */
	public static final String CALIL_API_BOOK_URL1 = "http://api.calil.jp/check?appkey=" + CALIL_APP_KEY + "&format=xml&systemid=";
	/** 「カーリル」蔵書検索アドレス２ */
	public static final String CALIL_API_BOOK_URL2 = "&isbn=";
	/** 「カーリル」蔵書検索アドレス３ */
	public static final String CALIL_API_BOOK_URL3 = "http://api.calil.jp/check?appkey=" + CALIL_APP_KEY + "&format=xml&session=";
	/** 「国立国会図書館サーチ」検索アドレス１ */
	public static final String IIS_API_URL1 = "https://iss.ndl.go.jp/api/sru?operation=searchRetrieve&version=1.2&recordSchema=dcndl&onlyBib=true&recordPacking=string&maximumRecords=10";
	/** 「国立国会図書館サーチ」検索アドレス２ */
	public static final String[] IIS_API_URL2 = {
			"&startRecord=1&query=",
			"&startRecord=11&query=",
	};
	/** 「国立国会図書館サーチ」検索アドレス３ */
	public static final String[] IIS_API_URL3 = {
			// 資料種別:本
			"dpid=iss-ndl-opac and mediatype=1 and title=",
			// 資料種別:児童書
			"dpid=iss-ndl-opac and mediatype=4 and title=",
			// 資料種別:障害者向け資料(障害者向け資料検索対象資料)
			"dpid=iss-ndl-opac and mediatype=8 and title=",
	};
	/** 「国立国会図書館サーチ」ISBN取得データタイプ */
	public static final String IIS_ISBN_DATA_TYPE = "http://ndl.go.jp/dcndl/terms/ISBN";
	/** 検索結果表示件数 */
	public static final int SHOW_DISP_POINT = 10;

	/**
	 * メインメソッド.
	 *
	 * @param args 起動パラメータ
	 */
	public static void main(final String... args) {
		EventQueue.invokeLater(new AppFrame()::display);
	}
}
