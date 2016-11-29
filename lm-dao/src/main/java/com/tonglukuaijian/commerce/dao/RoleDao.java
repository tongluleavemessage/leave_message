package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.Role;
/**
 * 角色
 *
 * @author Lhy
 * 2016年11月22日下午2:17:56
 */
public interface RoleDao {
	/**
	 * 添加角色
	 * 
	 * @param role
	 */
	public void save(Role role);

	/**
	 * 修改
	 * 
	 * @param role
	 */
	public void update(Role role);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Role> findAll();
	
	
}
