package com.tonglukuaijian.commerce.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.GetParams;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.UserService;
import com.tonglukuaijian.commerce.vo.LoginVo;
import com.tonglukuaijian.commerce.vo.UpdateUserVo;
import com.tonglukuaijian.commerce.vo.UserVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserWebService {
	@Autowired
	private UserService userService;

	@Path("/add")
	@POST
	public OutMessage<?> addUser(@Valid UserVo vo) {
		return userService.addUser(vo);
	}

	@Path("/update")
	@POST
	public OutMessage<?> updateUser(@Valid UpdateUserVo vo) {
		return userService.updateUser(vo);
	}

	@Path("/{userId}")
	@DELETE
	public OutMessage<?> updateUser(@PathParam("userId") Long userId, @Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
		}
		return userService.delete(loginUserId, userId);
	}

	@Path("/login")
	@POST
	public OutMessage<?> login(@Valid LoginVo vo, @Context HttpServletRequest request) {
		return userService.login(vo);
	}

	@Path("/get_user")
	@GET
	public OutMessage<?> getUser(@Context HttpServletRequest request) {
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

		return userService.getUserByParams(accountNumber, name, departmentId, roleId, phoneNum, pageMap.get("page"),
				pageMap.get("size"));
	}

	@Path("/info")
	@GET
	public OutMessage<?> getUserInfo(@QueryParam("userId") Long userId) {
		return userService.getUserInfo(userId);

	}

}
