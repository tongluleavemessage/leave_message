package com.tonglukuaijian.commerce;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class GetParams {
	public static Map<String, Integer> getPage(HttpServletRequest request) {
		Map<String, Integer> map = new HashMap<>();
		int page = 0;
		int size = 0;
		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (null != request.getParameter("size")) {
			size = Integer.parseInt(request.getParameter("size"));
		}
		map.put("page", page);
		map.put("size", size);
		return map;
	}

	public static Long getLoginUserId(HttpServletRequest request) {
		if (request.getHeader("userid") == null) {
			return null;
		}
		return Long.parseLong(request.getHeader("userid"));
	}
}
