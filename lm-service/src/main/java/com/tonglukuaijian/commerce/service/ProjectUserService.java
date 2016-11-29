package com.tonglukuaijian.commerce.service;

import java.util.List;

import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

public interface ProjectUserService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public void add(ProjectUserVo vo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void remove(Long id);

	/**
	 * 根据项目ID查询用户
	 * 
	 * @return
	 */
	public List<ProjectUserDto> getUser(String projectId);
}
