package com.fqyd.hrm.utils;

/**
 * 工具类
 */
public class Tools {

	/**
	 * 判断字符串为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}
		if (s.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串不为空
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		if (s == null) {
			return false;
		}
		if (s.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 生成ID
	 * @return
	 */
	public static String createID() {
		return String.valueOf(System.currentTimeMillis());
	}
}
