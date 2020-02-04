package com.xrea.s8.otokiti.calil.entity;

/**
 * プロキシ設定.
 */
public final class ProxyEntity {
	// URL
	private String url;
	// ポート
	private String port;
	// ユーザー
	private String user;
	// パスワード
	private String pass;

	/**
	 * URLの取得.
	 *
	 * @return URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * URLの設定.
	 *
	 * @param url URL
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * ポートの取得.
	 *
	 * @return ポート
	 */
	public String getPort() {
		return port;
	}

	/**
	 * ポートの設定.
	 *
	 * @param port ポート
	 */
	public void setPort(final String port) {
		this.port = port;
	}

	/**
	 * ユーザーの取得.
	 *
	 * @return ユーザー
	 */
	public String getUser() {
		return user;
	}

	/**
	 * ユーザーの設定.
	 *
	 * @param user ユーザー
	 */
	public void setUser(final String user) {
		this.user = user;
	}

	/**
	 * パスワードの取得.
	 *
	 * @return パスワード
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * パスワードの設定.
	 *
	 * @param pass パスワード
	 */
	public void setPass(final String pass) {
		this.pass = pass;
	}
}
