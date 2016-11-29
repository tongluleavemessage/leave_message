package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.ProjectUserService;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public void add(ProjectUserVo vo) {
		ProjectUser po = wrapProjectUser(vo);
		projectUserDao.save(po);
	}

	@Override
	public void remove(Long id) {
		if (null == id) {
			throw new ServiceException("未指定项目成员");
		}
		projectUserDao.delete(id);
	}
	
	@Override
	public List<ProjectUserDto> getUser(String projectId) {
		return projectUserDao.findByParams(projectId);
	}


	private ProjectUser wrapProjectUser(ProjectUserVo vo) {
		ProjectUser po = new ProjectUser();
		po.setCreatedTime(new Date());
		po.setProjectId(vo.getProjectId());
		po.setId(vo.getId());
		po.setUserId(vo.getUserId());
		return po;
	}

	
}
