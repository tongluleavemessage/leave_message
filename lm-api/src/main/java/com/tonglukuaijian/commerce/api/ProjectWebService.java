package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.service.ProjectService;
import com.tonglukuaijian.commerce.vo.ProjectVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/project")
public class ProjectWebService {

	@Autowired
	private ProjectService projectService;

	@Path("/get")
	@GET
	public Map<String, Object> getByParam(@Context HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Long departmentId = null;
		if (null != request.getParameter("departmentId")) {
			departmentId = Long.parseLong(request.getParameter("departmentId"));
		}
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String accountNumber = request.getParameter("accountNumber");
		String name = request.getParameter("name");
		String phoneNum = request.getParameter("phoneNum");
		List<ProjectDto> list = projectService.getByParam(departmentId, projectId, projectName, accountNumber, name,
				phoneNum);
		map.put("data", list);
		return map;
	}

	@POST
	@Path("/add")
	public Map<String, Object> add(ProjectVo vo) {
		Map<String, Object> map = new HashMap<>();
		projectService.add(vo);
		map.put("message", "ok");
		return map;
	}

	@POST
	@Path("/update")
	public Map<String, Object> update(ProjectVo vo) {
		Map<String, Object> map = new HashMap<>();
		projectService.update(vo);
		map.put("message", "ok");
		return map;
	}
}
