package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.Project;
import com.tonglukuaijian.commerce.dto.ProjectDto;

public interface ProjectDao {
	/**
	 * 新增
	 * 
	 * @param project
	 */
	public void save(Project project);

	/**
	 * 修改
	 * 
	 * @param project
	 */
	public void update(Project project);

	/**
	 * 根据条件查询
	 * 
	 * @param departmentId
	 * @param projectId
	 * @param projectName
	 * @param accountNumber
	 * @param name
	 * @param phoneNum
	 * @return
	 */
	public List<ProjectDto> findByParams(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum);
}
