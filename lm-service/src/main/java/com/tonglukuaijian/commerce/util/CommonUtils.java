package com.tonglukuaijian.commerce.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	private static SimpleDateFormat SDF_DEFAULT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static String dateFormat(Date date) {
		return SDF_DEFAULT.format(date);
	}
}
