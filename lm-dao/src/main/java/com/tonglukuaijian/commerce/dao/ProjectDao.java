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
	 * @param departmentId 部门ID
	 * @param projectId 项目ID
	 * @param projectName 项目名称 
	 * @param accountNumber 账号
	 * @param name 
	 * @param phoneNum
	 * @return
	 */
	public List<ProjectDto> findByParams(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size);

	/**
	 * 获取项目负责人
	 * 
	 * @return
	 */
	public Project findProjectPrincipals(String projectId);

	/**
	 * 通过用户查询项目
	 * 
	 * @param departmentId
	 *            部门ID
	 * @param ministerId
	 *            部长ID
	 * @param groupId
	 *            群总ID
	 * @param principalId
	 *            负责人ID
	 * @param page
	 * @param size
	 * @return
	 */
	List<Project> findProjectByUserRelation(Long departmentId, Long ministerId, Long groupId, Long principalId,
			int page, int size);
}
