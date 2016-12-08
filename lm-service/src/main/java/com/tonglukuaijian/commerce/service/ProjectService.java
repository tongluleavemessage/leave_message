package com.tonglukuaijian.commerce.service;

import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.ProjectVo;
import com.tonglukuaijian.commerce.vo.UpdateProjectVo;

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
	public OutMessage<?> add(ProjectVo vo);

	/**
	 * 修改
	 * 
	 * @param vo
	 */
	public OutMessage<?> update(UpdateProjectVo vo);

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
	public OutMessage<?> getByParam(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size);

	/**
	 * 获取项目详情
	 * 
	 * @param id
	 * @return
	 */
	OutMessage<?> getProjectManageInfo(Long id);
}
