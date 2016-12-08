package com.tonglukuaijian.commerce.api;

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
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.RoleService;
import com.tonglukuaijian.commerce.vo.RoleVo;
import com.tonglukuaijian.commerce.vo.UpdateRoleVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/role")
public class RoleWebService {

	@Autowired
	private RoleService roleService;

	@Path("/add")
	@POST
	public OutMessage<?> add(@Valid RoleVo vo) {
		return roleService.add(vo);
	}

	@Path("/update")
	@POST
	public OutMessage<?> update(@Valid UpdateRoleVo vo) {
		return roleService.update(vo);
	}

	@Path("/get_all")
	@GET
	public OutMessage<?> getAll(@Context HttpServletRequest request) {
		Map<String, Integer> pageMap = GetParams.getPage(request);
		return roleService.getAll(pageMap.get("page"), pageMap.get("size"));
	}
}
