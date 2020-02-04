package com.xrea.s8.otokiti.calil.entity.calil;

/**
 * カーリル API 蔵書情報 -> 蔵書 -> 取得結果 -> 図書館キー Response.
 */
public final class Libkey {
	// 図書館キー
	private String name;
	// 貸出状況
	private String value;

	/**
	 * 図書館キーの取得.
	 *
	 * @return 図書館キー
	 */
	public String getName() {
		return name;
	}

	/**
	 * 図書館キーの設定.
	 *
	 * @param name 図書館キー
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * 貸出状況の取得.
	 *
	 * @return 貸出状況
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 貸出状況の設定.
	 *
	 * @param value 貸出状況
	 */
	public void setValue(final String value) {
		this.value = value;
	}
}
