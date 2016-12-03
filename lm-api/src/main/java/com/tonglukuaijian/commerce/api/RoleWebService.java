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

import com.tonglukuaijian.commerce.GetParams;
import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.service.RoleService;
import com.tonglukuaijian.commerce.vo.RoleVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/role")
public class RoleWebService {

	@Autowired
	private RoleService roleService;

	@Path("/add")
	@POST
	public Map<String, String> add(@Valid RoleVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		roleService.add(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/update")
	@POST
	public Map<String, String> update(@Valid RoleVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		roleService.update(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/get_all")
	@GET
	public Map<String, Object> getAll(@Context HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Integer> pageMap = GetParams.getPage(request);
		List<Role> list = roleService.getAll(pageMap.get("page"), pageMap.get("size"));
		map.put("data", list);
		return map;
	}
}
