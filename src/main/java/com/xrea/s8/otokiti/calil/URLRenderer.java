package com.xrea.s8.otokiti.calil;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * URLリンク用レンダラー.
 */
public final class URLRenderer extends DefaultTableCellRenderer implements MouseListener, MouseMotionListener {

	// 行
	private int row = -1;
	// 列
	private int col = -1;

	/**
	 * デフォルトのテーブル・セル・レンダラを返します.
	 * 印刷操作中は、印刷結果に選択範囲やフォーカスが表示されるのを防ぐため、isSelectedおよびhasFocusの値をfalseにしてこのメソッドを呼び出します。
	 * テーブルを印刷するかどうかに基づいてその他のカスタマイズを行うには、JComponent.isPaintingForPrint()の戻り値を確認します。
	 *
	 * @param table JTable
	 * @param value [row, column]のセルに割り当てる値
	 * @param isSelected セルが選択されている場合はtrue
	 * @param hasFocus フォーカスがある場合はtrue
	 * @param row レンダリングされるセルの行
	 * @param column レンダリングされるセルの列
	 * @return デフォルトのテーブル・セル・レンダラ
	 */
	@Override
	public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
		super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
		if (value == null) {
			setText("");
		} else 	if (!table.isEditing() && this.row == row && this.col == column) {
			setText("<html><u><font color='blue'>" + value.toString());
		} else if (hasFocus) {
			setText("<html><font color='blue'>" + value.toString());
		} else {
			setText(value.toString());
		}
		return this;
	}

	/**
	 * コンポーネント上でマウスボタンをクリック (押してから離す) したときに呼び出されます.
	 */
	@Override
	public void mouseClicked(final MouseEvent e) {
		JTable table = (JTable) e.getSource();
		Point pt = e.getPoint();
		int crow = table.rowAtPoint(pt);
		int ccol = table.columnAtPoint(pt);
		if (table.getColumnClass(ccol).equals(URL.class)) {
			URL url = (URL) table.getValueAt(crow, ccol);
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (Exception ex) {
				ex.printStackTrace();
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
		JTable table = (JTable) e.getSource();
		row = -1;
		col = -1;
		table.repaint();
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
		JTable table = (JTable) e.getSource();
		Point pt = e.getPoint();
		row = table.rowAtPoint(pt);
		col = table.columnAtPoint(pt);
		if (row < 0 || col < 0) {
			row = -1;
			col = -1;
		}
		table.repaint();
	}
}
