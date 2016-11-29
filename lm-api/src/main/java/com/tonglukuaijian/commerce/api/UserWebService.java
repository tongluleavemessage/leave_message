package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.enums.UserUsingEnum;
import com.tonglukuaijian.commerce.service.UserService;
import com.tonglukuaijian.commerce.vo.UserVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserWebService {
	@Autowired
	private UserService userService;

	@Path("/add")
	@POST
	public Map<String, String> addUser(@Valid UserVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		userService.addUser(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/update")
	@POST
	public Map<String, String> updateUser(@Valid UserVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		userService.updateUser(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/login")
	@POST
	public Map<String, Object> login(@Context HttpServletRequest request) {
		String accountNumber = request.getParameter("accountNumber");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.login(accountNumber, password);
		map.put("data", user);
		return map;
	}

	@Path("/get_user")
	@GET
	public Map<String, Object> getUser(@Context HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String accountNumber = request.getParameter("accountNumber");
		String name = request.getParameter("name");
		int page = 1;
		int size = 10;
		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (null != request.getParameter("size")) {
			size = Integer.parseInt(request.getParameter("size"));
		}
		Long departmentId = null;
		if (null != request.getParameter("departmentId")) {
			departmentId = Long.parseLong(request.getParameter("departmentId"));
		}
		Long roleId = null;
		if (null != request.getParameter("roleId")) {
			roleId = Long.parseLong(request.getParameter("roleId"));
		}

		List<User> list = userService.getUserByParams(accountNumber, name, departmentId, roleId, page, size);
		map.put("data", list);
		return map;
	}
}
