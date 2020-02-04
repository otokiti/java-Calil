package com.xrea.s8.otokiti.calil;

import java.awt.Component;
import java.net.URL;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * テーブル.
 */
public final class LibraryTable extends JTable {

	/**
	 * コンストラクタ.
	 *
	 * @param dm テーブルのデータ・モデル
	 */
	public LibraryTable(final TableModel dm) {
		super(dm);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setRowSelectionAllowed(true);
		this.setAlignment(SwingConstants.RIGHT, 3);
		this.setAlignment(SwingConstants.CENTER, 4);

		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) this.getColumnModel();
		for (int i = 0 ; i < columnModel.getColumnCount() ; i++) {
			columnModel.getColumn(i).setMinWidth(70);
		}

		URLRenderer renderer = new URLRenderer();
		this.setDefaultRenderer(URL.class, renderer);
		this.addMouseListener(renderer);
		this.addMouseMotionListener(renderer);
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
	 * テーブル列のアライメントを行う.
	 *
	 * @param alignment SwingConstantsで定義されている定数
	 * @param column 寄せ対象カラム
	 */
	private void setAlignment(final int alignment, final int column) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(alignment);
		this.getColumnModel().
		getColumn(column).setCellRenderer(r);
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
