package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.dao.RoleDao;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.RoleService;
import com.tonglukuaijian.commerce.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void add(RoleVo vo) {
		Role role = wrapRole(vo);
		roleDao.save(role);
	}

	@Override
	public void update(RoleVo vo) {
		if (null == vo.getId()) {
			throw new ServiceException("未指定角色");
		}
		Role role = wrapRole(vo);
		roleDao.update(role);
	}
	
	@Override
	public List<Role> getAll() {
 		return roleDao.findAll();
	}

	private Role wrapRole(RoleVo vo) {
		Role role = new Role();
		role.setCreatedTime(new Date());
		role.setExplain(vo.getExplain());
		role.setName(vo.getName());
		role.setStatus(vo.getStatus());
		role.setId(vo.getId());
		return role;
	}

	

}
