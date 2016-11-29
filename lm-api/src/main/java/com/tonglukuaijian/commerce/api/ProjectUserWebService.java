package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.service.ProjectUserService;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/project_user")
public class ProjectUserWebService {

	@Autowired
	private ProjectUserService projectUserService;

	@POST
	@Path("/add")
	public Map<String, Object> add(ProjectUserVo vo) {
		projectUserService.add(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "ok");
		return map;

	}

	@DELETE
	@Path("/delete")
	public Map<String, Object> delete(@Context HttpServletRequest request) {
		Long id = null;
		if (null != request.getParameter("id")) {
			id = Long.parseLong(request.getParameter("id"));
		}
		projectUserService.remove(id);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "ok");
		return map;
	}

	@GET
	@Path("/get")
	public Map<String, Object> getByProjectId(@Context HttpServletRequest request) {
		String	projectId = request.getParameter("projectId");
		List<ProjectUserDto> list = projectUserService.getUser(projectId);
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		return map;

	}

}
