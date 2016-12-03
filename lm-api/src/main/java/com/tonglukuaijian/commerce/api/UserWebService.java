package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.GetParams;
import com.tonglukuaijian.commerce.bean.User;
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
	public Map<String, Object> login(@Context HttpServletRequest request, @Context HttpSession session) {

		String accountNumber = request.getParameter("accountNumber");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.login(accountNumber, password);
		session.setAttribute("userId", user.getId());
		map.put("data", user);
		return map;
	}

	@Path("/get_user")
	@GET
	public Map<String, Object> getUser(@Context HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String accountNumber = request.getParameter("accountNumber");
		String name = request.getParameter("name");
		Map<String, Integer> pageMap = GetParams.getPage(request);
		Long departmentId = null;
		String phoneNum = request.getParameter("phoneNum");
		if (null != request.getParameter("departmentId")) {
			departmentId = Long.parseLong(request.getParameter("departmentId"));
		}
		Long roleId = null;
		if (null != request.getParameter("roleId")) {
			roleId = Long.parseLong(request.getParameter("roleId"));
		}

		List<User> list = userService.getUserByParams(accountNumber, name, departmentId, roleId, phoneNum,
				pageMap.get("page"), pageMap.get("size"));
		map.put("data", list);
		return map;
	}

	@Path("/info")
	@GET
	public Map<String, Object> getUserInfo(@QueryParam("userId") Long userId) {
		User user = userService.getUserInfo(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", user);
		return map;
	}

}
