package com.tonglukuaijian.commerce.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Project;
import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectDao;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.ProjectService;
import com.tonglukuaijian.commerce.vo.ProjectVo;
import com.tonglukuaijian.commerce.vo.UpdateProjectVo;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public OutMessage<?> add(ProjectVo vo) {
		if (null == vo.getProjectId()) {
			throw new ServiceException("未指定项目");
		}
		Project project = wrapProject(vo);
		projectDao.save(project);
		List<ProjectUser> list = new ArrayList<>();
		// 添加项目用户
		ProjectUser projectUser = new ProjectUser();
		projectUser.setCreatedTime(new Date());
		projectUser.setProjectId(vo.getProjectId());
		projectUser.setUserId(vo.getPrincipalId());
		list.add(projectUser);
		projectUserDao.save(list);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> update(UpdateProjectVo vo) {
		Project project = projectDao.findById(vo.getId());
		if (project == null) {
			return OutMessage.errorMessage("该项目不存在");
		}
		if (vo.getDepartmentId() != null) {
			project.setDepartmentId(vo.getDepartmentId());
		}
		if (vo.getGroupUserId() != null) {
			project.setGroupUserId(vo.getGroupUserId());
		}
		if (vo.getMinisterUserId() != null) {
			project.setMinisterUserId(vo.getMinisterUserId());
		}
		if (vo.getPrincipalId() != null) {
			project.setPrincipalId(vo.getPrincipalId());
		}
		if (vo.getProjectId() != null) {
			project.setProjectId(vo.getProjectId());
		}
		if (vo.getProjectName() != null) {
			project.setProjectName(vo.getProjectName());
		}
		projectDao.update(project);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> getByParam(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size) {
		List<ProjectDto> list = projectDao.findByParams(departmentId, projectId, projectName, accountNumber, name,
				phoneNum, page, size);
		return OutMessage.successMessage(list);
	}

	@Override
	public OutMessage<?> getProjectManageInfo(Long id) {
		ProjectDto dto = projectDao.findProjectDtoById(id);
		return OutMessage.successMessage(dto);
	}

	private Project wrapProject(ProjectVo vo) {
		Project project = new Project();
		project.setDepartmentId(vo.getDepartmentId());
		project.setGroupUserId(vo.getGroupUserId());
		project.setMinisterUserId(vo.getMinisterUserId());
		project.setPrincipalId(vo.getPrincipalId());
		project.setProjectId(vo.getProjectId());
		project.setProjectName(vo.getProjectName());
		project.setCreatedTime(new Date());
		return project;
	}

}
