package com.tonglukuaijian.commerce.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.ProjectUserService;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public OutMessage<?> add(ProjectUserVo vo) {
		List<ProjectUser> list=new ArrayList<>();
		ProjectUser po = new ProjectUser();
		po.setCreatedTime(new Date());
		po.setProjectId(vo.getProjectId());
		po.setId(vo.getId());
		for (Long userId : vo.getUserId()) {
			po.setUserId(userId);
			list.add(po);
		}
		projectUserDao.save(list);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> remove(Long id) {
		projectUserDao.delete(id);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> getUser(String projectId, int page, int size) {
		List<ProjectUserDto> list = projectUserDao.findByParams(projectId, page, size);
		return OutMessage.successMessage(list);
	}

}
