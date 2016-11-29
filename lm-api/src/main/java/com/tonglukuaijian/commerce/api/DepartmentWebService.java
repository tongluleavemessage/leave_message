package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.bean.Department;
import com.tonglukuaijian.commerce.service.DepartmentService;
import com.tonglukuaijian.commerce.vo.DepartmentVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/department")
public class DepartmentWebService {

	@Autowired
	private DepartmentService departmentService;

	@Path("/add")
	@POST
	public Map<String, String> add(@Valid DepartmentVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		departmentService.add(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/update")
	@POST
	public Map<String, String> update(@Valid DepartmentVo vo) {
		Map<String, String> map = new HashMap<String, String>();
		departmentService.update(vo);
		map.put("message", "ok");
		return map;
	}

	@Path("/get_all")
	@GET
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Department> list = departmentService.getAll();
		map.put("data", list);
		return map;
	}
}
