package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;

public interface ProjectUserDao {
	/**
	 * 添加
	 */
	public void save(List<ProjectUser> projectUser);

	/**
	 * 删除
	 */
	public void delete(Long id);

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<ProjectUserDto> findByParams(String projectId, int page, int size);

}
