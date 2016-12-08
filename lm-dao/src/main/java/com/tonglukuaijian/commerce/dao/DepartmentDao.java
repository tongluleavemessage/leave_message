package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.Department;

/**
 * 部门
 *
 * @author Lhy 2016年11月22日下午2:17:50
 */
public interface DepartmentDao {
	/**
	 * 新增
	 * 
	 * @param department
	 */
	public void save(Department department);

	/**
	 * 修改
	 * 
	 * @param department
	 */
	public void update(Department department);

	/**
	 * 根据条件查询
	 * 
	 * @return
	 */
	public List<Department> findAll(int page, int size);

	/**
	 * 根据ID查询部门
	 * 
	 * @param departmentId
	 */
	Department findById(Long departmentId);
}
