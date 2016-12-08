package com.tonglukuaijian.commerce.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
import com.tonglukuaijian.commerce.service.ProjectService;
import com.tonglukuaijian.commerce.vo.ProjectVo;
import com.tonglukuaijian.commerce.vo.UpdateProjectVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/project")
public class ProjectWebService {

	@Autowired
	private ProjectService projectService;

	@Path("/get")
	@GET
	public OutMessage<?> getByParam(@Context HttpServletRequest request) {
		Long departmentId = null;
		Map<String, Integer> pageMap = GetParams.getPage(request);
		if (null != request.getParameter("departmentId")) {
			departmentId = Long.parseLong(request.getParameter("departmentId"));
		}
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String accountNumber = request.getParameter("accountNumber");
		String name = request.getParameter("name");
		String phoneNum = request.getParameter("phoneNum");
		return projectService.getByParam(departmentId, projectId, projectName, accountNumber, name, phoneNum,
				pageMap.get("page"), pageMap.get("size"));
	}
	
	@Path("/{id}")
	public OutMessage<?> getInfo(@PathParam("id") Long id){
		return projectService.getProjectManageInfo(id);
	}

	@POST
	@Path("/add")
	public OutMessage<?> add(@Valid ProjectVo vo) {
		return projectService.add(vo);
	}

	@POST
	@Path("/update")
	public OutMessage<?> update(UpdateProjectVo vo) {
		return projectService.update(vo);
	}
}
