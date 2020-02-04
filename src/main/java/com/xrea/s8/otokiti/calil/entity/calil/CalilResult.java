package com.xrea.s8.otokiti.calil.entity.calil;

import java.util.List;

/**
 * カーリル API 蔵書情報 Response.
 */
public final class CalilResult {
	// セッション
	private String session;
	// 取得情報(0:偽、1:真)
	private String continueType;
	// 蔵書
	private List<Book> book;

	/**
	 * セッションの取得.
	 *
	 * @return セッション
	 */
	public String getSession() {
		return session;
	}

	/**
	 * セッションの設定.
	 *
	 * @param session セッション
	 */
	public void setSession(final String session) {
		this.session = session;
	}

	/**
	 * 取得情報の取得.
	 * (0:偽、1:真)
	 *
	 * @return 取得情報
	 */
	public String getContinueType() {
		return continueType;
	}

	/**
	 * 取得情報の設定.
	 * (0:偽、1:真)
	 *
	 * @param continueType 取得情報
	 */
	public void setContinueType(final String continueType) {
		this.continueType = continueType;
	}

	/**
	 * 蔵書の取得.
	 *
	 * @return 蔵書
	 */
	public List<Book> getBook() {
		return book;
	}

	/**
	 * 蔵書の設定.
	 *
	 * @param book 蔵書
	 */
	public void setBook(final List<Book> book) {
		this.book = book;
	}
}
