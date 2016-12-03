package com.tonglukuaijian.commerce.service;

import java.util.List;

import com.tonglukuaijian.commerce.bean.Department;
import com.tonglukuaijian.commerce.vo.DepartmentVo;

public interface DepartmentService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public void add(DepartmentVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public void update(DepartmentVo vo);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Department> getAll(int page, int size);
}
