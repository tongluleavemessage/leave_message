package com.tonglukuaijian.commerce.service;

import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.ProjectUserVo;

public interface ProjectUserService {
	/**
	 * 添加
	 * 
	 * @param vo
	 */
	public OutMessage<?> add(ProjectUserVo vo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public OutMessage<?> remove(Long id);

	/**
	 * 根据项目ID查询用户
	 * 
	 * @return
	 */
	public OutMessage<?> getUser(String projectId, int page, int size);
}
