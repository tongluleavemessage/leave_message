package com.tonglukuaijian.commerce.service;

import java.util.List;

import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.vo.RoleVo;

public interface RoleService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public void add(RoleVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public void update(RoleVo vo);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Role> getAll(int page, int size);
}
