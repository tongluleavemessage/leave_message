package com.tonglukuaijian.commerce.service;

import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.RoleVo;
import com.tonglukuaijian.commerce.vo.UpdateRoleVo;

public interface RoleService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public OutMessage<?> add(RoleVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public OutMessage<?> update(UpdateRoleVo vo);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public OutMessage<?> getAll(int page, int size);
}
