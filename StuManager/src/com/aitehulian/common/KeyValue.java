package com.aitehulian.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description: 获取配置文件中的键对应的值
 * @author 作者：沈传新
 * @version 创建时间：2016-8-10 下午06:25:29
 */
public class KeyValue {

	public static String getValue(String key) {

		Properties ppt = new Properties();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream("db.properties");
			ppt.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String value = ppt.getProperty(key);

		return value;
	}
}
