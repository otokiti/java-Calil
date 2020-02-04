package com.xrea.s8.otokiti.calil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

import com.xrea.s8.otokiti.calil.service.AppService;

/**
 * 図書検索 画面
 */
public final class AppFrame extends JFrame implements ActionListener, MouseInputListener {

	// サービス
	private AppService appService;
	// テーブルモデル
	private DefaultTableModel bookTableModel;
	private DefaultTableModel resultTableModel;
	// ラベル
	private JLabel addrLbl;
	private JLabel isbnLbl;
	private JLabel titleLbl;
	private JLabel noteLbl;
	private JLabel msg1Lbl;
	private JLabel msg2Lbl;
	// テキストボックス
	private JTextField addrText;
	private JTextField isbnText;
	private JTextField titleText;
	// ボタン
	private JButton searchBtn;
	// テーブル
	private BookTable bookTable;
	private LibraryTable resultTable;

	/**
	 * コンストラクタ.
	 */
	public AppFrame() {
		super(App.TITLE);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 住所
		this.addrLbl = new JLabel("住所");
		this.addrLbl.setPreferredSize(new Dimension(30, 20));
		this.addrText = new JTextField(20);

		// ISBN
		this.isbnLbl = new JLabel("ISBN");
		this.isbnLbl.setPreferredSize(new Dimension(30, 20));
		this.isbnText = new JTextField(10);

		// タイトル
		this.titleLbl = new JLabel("書名");
		this.titleLbl.setPreferredSize(new Dimension(30, 20));
		this.titleText = new JTextField(10);

		// 検索
		this.searchBtn = new JButton("検索");
		this.searchBtn.addActionListener(this);

		// テーブルモデル
		this.bookTableModel = new DefaultTableModel(new String[] {"出版社", "書名", "出版年月日", "ISBN"}, 0);
		this.resultTableModel = new DefaultTableModel(new String[] {"カテゴリー", "住所", "名称", "距離(km)", "貸出状況", "予約ページ"}, 0) {
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0: return String.class;
				case 1: return String.class;
				case 2: return String.class;
				case 3: return String.class;
				case 4: return String.class;
				case 5: return URL.class;
				default: return super.getColumnClass(column);
				}
			}
		};

		// テーブル
		this.bookTable = new BookTable(this.bookTableModel);
		this.bookTable.setAutoCreateColumnsFromModel(false);
		this.bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.bookTable.addMouseListener(this);

		this.resultTable = new LibraryTable(this.resultTableModel);
		this.resultTable.setAutoCreateColumnsFromModel(false);
		this.resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 注意
		this.noteLbl = new JLabel("※書名検索には取得件数制限をかけています。");
		this.msg1Lbl = new JLabel("");
		this.msg2Lbl = new JLabel("");

		JPanel addrPnl = new JPanel();
		addrPnl.setLayout(new BoxLayout(addrPnl, BoxLayout.X_AXIS));
		addrPnl.add(this.addrLbl);
		addrPnl.add(this.addrText);

		JPanel isbnPnl = new JPanel();
		isbnPnl.setLayout(new BoxLayout(isbnPnl, BoxLayout.X_AXIS));
		isbnPnl.add(this.isbnLbl);
		isbnPnl.add(this.isbnText);

		JPanel titlePnl = new JPanel();
		titlePnl.setLayout(new BoxLayout(titlePnl, BoxLayout.X_AXIS));
		titlePnl.add(this.titleLbl);
		titlePnl.add(this.titleText);

		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		pnl1.add(isbnPnl);
		pnl1.add(titlePnl);

		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.Y_AXIS));
		pnl2.add(addrPnl);
		pnl2.add(pnl1);

		JPanel searchPnl = new JPanel();
		searchPnl.setLayout(new BorderLayout());
		searchPnl.add(pnl2, BorderLayout.CENTER);
		searchPnl.add(this.searchBtn, BorderLayout.EAST);

		JScrollPane bookScrollPnl = new JScrollPane(this.bookTable);
		bookScrollPnl.setPreferredSize(new Dimension(500, 200));
		JScrollPane resultScrollPnl = new JScrollPane(this.resultTable);

		JPanel mainPnl = new JPanel();
		mainPnl.setLayout(new BorderLayout());
		mainPnl.add(searchPnl, BorderLayout.NORTH);
		mainPnl.add(bookScrollPnl, BorderLayout.CENTER);
		mainPnl.add(this.msg1Lbl, BorderLayout.SOUTH);

		JPanel msgPnl = new JPanel();
		msgPnl.setLayout(new BoxLayout(msgPnl, BoxLayout.Y_AXIS));
		msgPnl.add(this.msg2Lbl);
		msgPnl.add(this.noteLbl);

		JPanel main2Pnl = new JPanel();
		main2Pnl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		main2Pnl.setLayout(new BorderLayout());
		main2Pnl.add(mainPnl, BorderLayout.NORTH);
		main2Pnl.add(resultScrollPnl, BorderLayout.CENTER);
		main2Pnl.add(msgPnl, BorderLayout.SOUTH);

		super.getContentPane().add(main2Pnl, BorderLayout.CENTER);

		// 初期処理
		this.initialize();
	}

	/**
	 * 初期処理.
	 */
	private void initialize() {
		// サービスの初期化
		this.appService = new AppService();
	}

	/**
	 * 表示処理.
	 */
	public void display() {
		super.pack();
		super.setSize(new Dimension(700, 500));
		super.setLocationRelativeTo(this);
		super.setVisible(true);
	}

	/**
	 * アクションイベント.
	 *
	 * @param e イベント
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource().equals(this.searchBtn)) {
			if (!StringUtils.isEmpty(this.isbnText.getText())) {
				// ISBNから蔵書検索結果検索
				this.searchResult(this.isbnText.getText());
			} else if (!StringUtils.isEmpty(this.titleText.getText())) {
				// 書名から書籍検索
				this.searchBooks();
			}
		}
	}

	/**
	 * コンポーネント上でマウスボタンをクリック (押してから離す) したときに呼び出されます.
	 */
	@Override
	public void mouseClicked(final MouseEvent e) {
		if (e.getSource().equals(this.bookTable) && e.getClickCount() == 2) {
			if (this.bookTableModel.getValueAt(this.bookTable.getSelectedRow(), 3) != null) {
				String isbn = this.bookTableModel.getValueAt(this.bookTable.getSelectedRow(), 3).toString();
				// ISBNから蔵書検索結果検索
				this.searchResult(isbn);
			}
		}
	}

	/**
	 * コンポーネント上でマウスボタンが押されると呼び出されます.
	 */
	@Override
	public void mousePressed(final MouseEvent e) {
	}

	/**
	 * コンポーネント上でマウスボタンが離されると呼び出されます.
	 */
	@Override
	public void mouseReleased(final MouseEvent e) {
	}

	/**
	 * コンポーネントにマウスが入ると呼び出されます.
	 */
	@Override
	public void mouseEntered(final MouseEvent e) {
	}

	/**
	 * コンポーネントからマウスが出ると呼び出されます.
	 */
	@Override
	public void mouseExited(final MouseEvent e) {
	}

	/**
	 * コンポーネント上でマウス・ボタンを押してドラッグすると呼び出されます.
	 */
	@Override
	public void mouseDragged(final MouseEvent e) {
	}

	/**
	 * ボタンを押さずにマウス・カーソルをコンポーネント上に移動すると呼び出されます.
	 */
	@Override
	public void mouseMoved(final MouseEvent e) {
	}

	/**
	 * 書名から書籍検索.
	 */
	private void searchBooks() {
		if (this.searchBtn.isEnabled()) {
			// メッセージを設定
			this.msg1Lbl.setText("処理中...");
			// ボタンを使用不可に設定
			this.searchBtn.setEnabled(false);

			// SwingWorker を生成し，実行する
			BookSearchTaskWorker worker = new BookSearchTaskWorker(this.appService, this.searchBtn, this.bookTable, this.bookTableModel, this.msg1Lbl, this.titleText.getText());
			worker.execute();
		}
	}

	/**
	 * ISBNから蔵書検索結果検索.
	 *
	 * @param isbn 書名
	 */
	private void searchResult(final String isbn) {
		if (this.searchBtn.isEnabled()) {
			// メッセージを設定
			this.msg2Lbl.setText("処理中...");
			// ボタンを使用不可に設定
			this.searchBtn.setEnabled(false);

			// SwingWorker を生成し，実行する
			LibrarySearchTaskWorker worker = new LibrarySearchTaskWorker(this.appService, this.searchBtn, this.resultTable, this.resultTableModel, this.msg2Lbl, this.addrText.getText(), isbn);
			worker.execute();
		}
	}
}
