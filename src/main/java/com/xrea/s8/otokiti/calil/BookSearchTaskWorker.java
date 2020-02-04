package com.xrea.s8.otokiti.calil;

import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.xrea.s8.otokiti.calil.entity.BookEntity;
import com.xrea.s8.otokiti.calil.service.AppService;

/**
 * 書籍検索タスク.
 */
public final class BookSearchTaskWorker extends SwingWorker<String, String> {

	private AppService appService;
	private JButton searchBtn;
	private BookTable bookTable;
	private DefaultTableModel bookTableModel;
	private JLabel msg1Lbl;
	private String title;
	private Comparator<BookEntity> bookComparator;

	/**
	 * コンストラクタ.
	 *
	 * @param appService 汎用サービス
	 * @param searchBtn 検索ボタン
	 * @param bookTable 書籍一覧
	 * @param bookTableModel  書籍一覧モデル
	 * @param msgLbl メッセージラベル
	 * @param title 書名
	 */
	public BookSearchTaskWorker(final AppService appService, final JButton searchBtn, final BookTable bookTable, final DefaultTableModel bookTableModel, final JLabel msg1Lbl, final String title) {
		super();
		this.appService = appService;
		this.searchBtn = searchBtn;
		this.bookTable = bookTable;
		this.bookTableModel = bookTableModel;
		this.msg1Lbl = msg1Lbl;
		this.title = title;
		this.bookComparator = Comparator.comparing(BookEntity::getPublisher).thenComparing(Comparator.comparing(BookEntity::getTitle)).thenComparing(Comparator.comparing(BookEntity::getPublicationDate));
	}

	@Override
	protected String doInBackground() throws Exception {
		if (StringUtils.isEmpty(title)) {
			// 未入力の場合、処理中断
			return "書名を入力してください。";
		}

		// テーブル内容のクリア
		this.bookTableModel.setRowCount(0);
		this.bookTable.autoColumnResize();

		// 書籍一覧を検索
		try {
			// 書籍一覧検索
			List<BookEntity> bookEnties = this.appService.getBookEntity(this.title);

			if (CollectionUtils.isEmpty(bookEnties)) {
				return "書籍が見つかりませんでした。";
			}

			List<BookEntity> sortedBookEnties = bookEnties.stream().sorted(this.bookComparator).collect(Collectors.toList());

			// テーブルに値を設定
			for (BookEntity bookEntity : sortedBookEnties) {
				this.bookTableModel.addRow(this.appService.getTableDate(bookEntity));
			}

			// 列幅自動調整
			this.bookTable.autoColumnResize();

			return bookEnties.size() + "件見つかりました。";
		} catch (SocketTimeoutException ex) {
			return "検索でタイムアウトが発生しました。\n時間を置いて再度やり直してください。";
		}
	}

	@Override
	protected void done() {
		// ボタンを使用可能に設定
		this.searchBtn.setEnabled(true);

		try {
			this.msg1Lbl.setText(this.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
