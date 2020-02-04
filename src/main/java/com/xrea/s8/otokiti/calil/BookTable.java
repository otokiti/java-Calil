package com.xrea.s8.otokiti.calil;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * テーブル.
 */
public final class BookTable extends JTable {

	/**
	 * コンストラクタ.
	 *
	 * @param dm テーブルのデータ・モデル
	 */
	public BookTable(final TableModel dm) {
		super(dm);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) this.getColumnModel();
		for (int i = 0 ; i < columnModel.getColumnCount() ; i++) {
			columnModel.getColumn(i).setMinWidth(70);
		}
	}

	/**
	 * rowおよびcolumnに位置するセルが編集可能な場合にtrueを返します.
	 *
	 * @param row 値が照会される行
	 * @param column 値が照会される列
	 * @return セルが編集可能な場合はtrue
	 */
	@Override
	public boolean isCellEditable(final int row, final int column) {
		return false;
	}

	/**
	 * 列幅自動調整.
	 */
	public void autoColumnResize() {
		for (int column = 0; column < this.getColumnCount(); column++) {
			TableColumn tableColumn = this.getColumnModel().getColumn(column);
			TableColumn tableHeadColumn = this.getTableHeader().getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			tableColumn.setPreferredWidth(0);
			for (int row = 0; row < this.getRowCount(); row++) {
				TableCellRenderer cellRenderer = this.getCellRenderer(row, column);
				Component c = this.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + this.getIntercellSpacing().width;
				preferredWidth = Math.max(Math.max(preferredWidth, width), tableHeadColumn.getPreferredWidth());
				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
	}
}
