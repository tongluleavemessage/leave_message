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
import com.tonglukuaijian.commerce.service.DepartmentService;
import com.tonglukuaijian.commerce.vo.DepartmentVo;
import com.tonglukuaijian.commerce.vo.UpdateDepartmentVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/department")
public class DepartmentWebService {

	@Autowired
	private DepartmentService departmentService;

	@Path("/add")
	@POST
	public OutMessage<?> add(@Valid DepartmentVo vo) {
		return departmentService.add(vo);
	}

	@Path("/update")
	@POST
	public OutMessage<?> update(@Valid UpdateDepartmentVo vo) {
		return departmentService.update(vo);
	}

	@Path("/get_all")
	@GET
	public OutMessage<?> getAll(@Context HttpServletRequest request) {
		Map<String, Integer> pageMap = GetParams.getPage(request);
		return departmentService.getAll(pageMap.get("page"), pageMap.get("size"));
	}
}
