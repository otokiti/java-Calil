package com.xrea.s8.otokiti.calil.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.xrea.s8.otokiti.calil.entity.ProxyEntity;

/**
 * プロパティファイル入出力サービス.
 */
public final class PropertyIOService {

	/**
	 * 設定ファイルの取得.
	 * 取得できない場合はNULL
	 *
	 * @param filename ファイル名
	 * @return 設定ファイル
	 */
	public ProxyEntity loadConfig(final String filename) {
		File file = new File(System.getProperty("user.dir"), filename);
		Properties prop = new Properties();

		try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
			prop.load(in);

			// プロキシサーバー
			ProxyEntity proxy = new ProxyEntity();
			// PROXY_URL
			if (prop.containsKey("PROXY_URL")) {
				proxy.setUrl(prop.getProperty("PROXY_URL"));
			}
			// PROXY_PORT
			if (prop.containsKey("PROXY_PORT")) {
				proxy.setPort(prop.getProperty("PROXY_PORT"));
			}
			// PROXY_USER
			if (prop.containsKey("PROXY_USER")) {
				proxy.setUser(prop.getProperty("PROXY_USER"));
			}
			// PROXY_PASS
			if (prop.containsKey("PROXY_PASS")) {
				proxy.setPass(prop.getProperty("PROXY_PASS"));
			}

			if (StringUtils.isEmpty(proxy.getUrl()) || StringUtils.isEmpty(proxy.getPort())) {
				return null;
			}
			return proxy;

		} catch (Exception e) {
			return null;
		}
	}
}
