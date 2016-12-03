package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Project;
import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectDao;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.ProjectService;
import com.tonglukuaijian.commerce.vo.ProjectVo;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public void add(ProjectVo vo) {
		if (null == vo.getProjectId()) {
			throw new ServiceException("未指定项目");
		}
		Project project = wrapProject(vo);
		projectDao.save(project);
		
		// 添加项目用户
		ProjectUser projectUser = new ProjectUser();
		projectUser.setCreatedTime(new Date());
		projectUser.setProjectId(vo.getProjectId());
		projectUser.setUserId(vo.getPrincipalId());
		projectUserDao.save(projectUser);
	}

	@Override
	public void update(ProjectVo vo) {
		if (null == vo.getId()) {
			throw new ServiceException("未指定项目");
		}
		Project project = wrapProject(vo);
		projectDao.update(project);
	}

	@Override
	public List<ProjectDto> getByParam(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size) {
		List<ProjectDto> list = projectDao.findByParams(departmentId, projectId, projectName, accountNumber, name,
				phoneNum, page, size);
		return list;
	}

	private Project wrapProject(ProjectVo vo) {
		Project project = new Project();
		project.setId(vo.getId());
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
