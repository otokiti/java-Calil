package com.xrea.s8.otokiti.calil;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.xrea.s8.otokiti.calil.entity.ResultEntity;
import com.xrea.s8.otokiti.calil.entity.calil.CalilLibrary;
import com.xrea.s8.otokiti.calil.entity.geocoding.GeocodingResult;
import com.xrea.s8.otokiti.calil.service.AppService;

/**
 * 蔵書検索タスク.
 */
public final class LibrarySearchTaskWorker extends SwingWorker<String, String> {

	private AppService appService;
	private JButton searchBtn;
	private LibraryTable resultTable;
	private DefaultTableModel resultTableModel;
	private JLabel msg2Lbl;
	private String addr;
	private String isbn;

	/**
	 * コンストラクタ.
	 *
	 * @param appService 汎用サービス
	 * @param searchBtn 検索ボタン
	 * @param resultTable 蔵書一覧
	 * @param resultTableModel 蔵書一覧モデル
	 * @param msg2Lbl メッセージラベル
	 * @param addr 住所
	 * @param isbn ISBN
	 */
	public LibrarySearchTaskWorker(final AppService appService, final JButton searchBtn, final LibraryTable resultTable, final DefaultTableModel resultTableModel, final JLabel msg2Lbl, final String addr, final String isbn) {
		super();
		this.appService = appService;
		this.searchBtn = searchBtn;
		this.resultTable = resultTable;
		this.resultTableModel = resultTableModel;
		this.msg2Lbl = msg2Lbl;
		this.addr = addr;
		this.isbn = isbn;
	}

	@Override
	protected String doInBackground() throws Exception {
		if (StringUtils.isEmpty(addr)) {
			// 未入力の場合、処理中断
			return "住所を入力してください。";
		}
		if (StringUtils.isEmpty(isbn)) {
			// 未入力の場合、処理中断
			return "ISBNを入力してください。";
		}

		// テーブル内容のクリア
		this.resultTableModel.setRowCount(0);
		this.resultTable.autoColumnResize();

		// 位置情報を取得
		GeocodingResult geocodingResult = this.appService.getCoordinateEntity(this.addr);
		if (geocodingResult.getCoordinate() == null) {
			return "住所から座標の特定できません。";
		}

		// 図書館一覧を取得
		List<CalilLibrary> libraries = this.appService.getLibraries(geocodingResult.getCoordinate());
		if (CollectionUtils.isEmpty(libraries)) {
			return "住所から図書館が特定できません。";
		}

		// 蔵書検索結果を取得
		List<ResultEntity> resultEntities = this.appService.getResultEntity(libraries, this.isbn);
		if (CollectionUtils.isEmpty(resultEntities)) {
			return "図書館に蔵書が見つかりませんでした。";
		}

		// テーブルに値を設定
		for (ResultEntity resultEntity : resultEntities) {
			this.resultTableModel.addRow(this.appService.getTableDate(resultEntity));
		}

		// 列幅自動調整
		this.resultTable.autoColumnResize();

		return resultEntities.size() + "件見つかりました。";
	}

	@Override
	protected void done() {
		// ボタンを使用可能に設定
		this.searchBtn.setEnabled(true);

		try {
			this.msg2Lbl.setText(this.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
