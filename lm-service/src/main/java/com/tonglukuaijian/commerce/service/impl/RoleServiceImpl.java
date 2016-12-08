package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.dao.RoleDao;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.RoleService;
import com.tonglukuaijian.commerce.vo.RoleVo;
import com.tonglukuaijian.commerce.vo.UpdateRoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public OutMessage<?> add(RoleVo vo) {
		Role role = wrapRole(vo);
		roleDao.save(role);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> update(UpdateRoleVo vo) {
		Role role = roleDao.findById(vo.getRoleId());
		if (role == null) {
			return OutMessage.errorMessage("角色不存在");
		}
		if (vo.getExplain() != null) {
			role.setExplain(vo.getExplain());
		}
		if (vo.getName() != null) {
			role.setName(vo.getName());
		}
		if (vo.getStatus() != null) {
			role.setStatus(vo.getStatus());
		}
		roleDao.update(role);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> getAll(int page, int size) {
		List<Role> list = roleDao.findAll(page, size);
		return OutMessage.successMessage(list);
	}

	private Role wrapRole(RoleVo vo) {
		Role role = new Role();
		role.setCreatedTime(new Date());
		role.setExplain(vo.getExplain());
		role.setName(vo.getName());
		role.setStatus(vo.getStatus());
		return role;
	}

}
