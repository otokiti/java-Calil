package com.xrea.s8.otokiti.calil.entity.calil;

/**
 * カーリル API 蔵書情報 -> 蔵書 Response.
 */
public final class Book {
	// 個別の本ページへのアドレス
	private String calilurl;
	// ISBN
	private String isbn;
	// 取得結果
	private Systems system;

	/**
	 * 個別の本ページへのアドレスの取得.
	 *
	 * @return 個別の本ページへのアドレス
	 */
	public String getCalilurl() {
		return calilurl;
	}

	/**
	 * 個別の本ページへのアドレスの設定.
	 *
	 * @param calilurl 個別の本ページへのアドレス
	 */
	public void setCalilurl(final String calilurl) {
		this.calilurl = calilurl;
	}

	/**
	 * ISBNの取得.
	 *
	 * @return ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * ISBNの設定.
	 *
	 * @param isbn ISBN
	 */
	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 取得結果の取得.
	 *
	 * @return 取得結果
	 */
	public Systems getSystem() {
		return system;
	}

	/**
	 * 取得結果の設定.
	 *
	 * @param system 取得結果
	 */
	public void setSystem(final Systems system) {
		this.system = system;
	}
}
