package com.xrea.s8.otokiti.calil.entity.calil;

import java.util.List;

/**
 * カーリル API 蔵書情報 -> 蔵書 -> 取得結果 Response.
 */
public final class Systems {
	// システムID
	private String systemid;
	// 検索状態
	private String status;
	// 予約ページへのアドレス
	private String reserveurl;
	// 図書館キー
	private List<Libkey> libkey;

	/**
	 * システムIDの取得.
	 *
	 * @return システムID
	 */
	public String getSystemid() {
		return systemid;
	}

	/**
	 * システムIDの設定.
	 *
	 * @param systemid システムID
	 */
	public void setSystemid(final String systemid) {
		this.systemid = systemid;
	}

	/**
	 * 検索状態の取得.
	 *
	 * @return 検索状態
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 検索状態の設定.
	 *
	 * @param status 検索状態
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * 予約ページへのアドレスの取得.
	 *
	 * @return 予約ページへのアドレス
	 */
	public String getReserveurl() {
		return reserveurl;
	}

	/**
	 * 予約ページへのアドレスの設定.
	 *
	 * @param reserveurl 予約ページへのアドレス
	 */
	public void setReserveurl(final String reserveurl) {
		this.reserveurl = reserveurl;
	}

	/**
	 * 図書館キーの取得.
	 *
	 * @return 図書館キー
	 */
	public List<Libkey> getLibkey() {
		return libkey;
	}

	/**
	 * 図書館キーの設定.
	 *
	 * @param libkey 図書館キー
	 */
	public void setLibkey(final List<Libkey> libkey) {
		this.libkey = libkey;
	}
}
