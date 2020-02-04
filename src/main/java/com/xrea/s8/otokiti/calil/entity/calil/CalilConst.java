package com.xrea.s8.otokiti.calil.entity.calil;

import java.util.HashMap;
import java.util.Map;

/**
 * カーリル 定数.
 */
public final class CalilConst {
	//-- 取得結果 --//
	// 処理継続(真)
	public final static String CONTINUE_TYPE_TRUE = "1";
	// 処理継続(偽)
	public final static String CONTINUE_TYPE_FALSE = "0";

	/**
	 * カテゴリー.
	 */
	public static final Map<String, String> Category = new HashMap<>() {
		{
			put("SMALL", "図書室・公民館");
			put("MEDIUM", "図書館(地域)");
			put("LARGE", "図書館(広域)");
			put("UNIV", "大学");
			put("SPECIAL", "専門");
			put("BM", "移動・BM");
		}
	};
}
