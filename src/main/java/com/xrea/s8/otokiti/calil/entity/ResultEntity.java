package com.xrea.s8.otokiti.calil.entity;

import com.xrea.s8.otokiti.calil.entity.calil.CalilLibrary;
import com.xrea.s8.otokiti.calil.entity.calil.Systems;

/**
 * 蔵書検索結果.
 */
public final class ResultEntity {
	// 図書館
	private CalilLibrary library;
	// 取得結果
	private Systems system;

	/**
	 * 図書館の取得.
	 *
	 * @return 図書館
	 */
	public CalilLibrary getLibrary() {
		return library;
	}

	/**
	 * 図書館の設定.
	 *
	 * @param library 図書館
	 */
	public void setLibrary(final CalilLibrary library) {
		this.library = library;
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
