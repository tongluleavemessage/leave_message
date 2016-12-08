package com.tonglukuaijian.commerce.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.GetParams;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.ProjectUserService;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/project_user")
public class ProjectUserWebService {

	@Autowired
	private ProjectUserService projectUserService;

	@POST
	@Path("/add")
	public OutMessage<?> add(ProjectUserVo vo) {
		return projectUserService.add(vo);
	}

	@DELETE
	@Path("/{id}")
	public OutMessage<?> delete(@PathParam("id") Long id,  @Context HttpServletRequest request) {
		return projectUserService.remove(id);
	}

	@GET
	@Path("/get")
	public OutMessage<?> getByProjectId(@Context HttpServletRequest request) {
		String projectId = request.getParameter("projectId");
		Map<String, Integer> pageMap = GetParams.getPage(request);
		return projectUserService.getUser(projectId, pageMap.get("page"), pageMap.get("size"));

	}

}
