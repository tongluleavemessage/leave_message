package com.tonglukuaijian.commerce.service;

import java.util.List;

import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.vo.ProjectVo;

/**
 * 项目管理
 *
 * @author Lhy 2016年11月28日下午4:56:32
 */
public interface ProjectService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public void add(ProjectVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public void update(ProjectVo vo);

	/**
	 * 查询
	 * 
	 * @param departmentId
	 * @param projectId
	 * @param projectName
	 * @param accountNumber
	 * @param name
	 * @param phoneNum
	 * @return
	 */
	public List<ProjectDto> getByParam(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size);
}
