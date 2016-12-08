package com.tonglukuaijian.commerce.service;

import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.DepartmentVo;
import com.tonglukuaijian.commerce.vo.UpdateDepartmentVo;

public interface DepartmentService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public OutMessage<?> add(DepartmentVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public OutMessage<?> update(UpdateDepartmentVo vo);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public OutMessage<?> getAll(int page, int size);
}
