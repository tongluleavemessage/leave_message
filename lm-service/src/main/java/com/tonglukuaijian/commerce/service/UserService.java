package com.tonglukuaijian.commerce.service;

import java.util.List;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.vo.UserVo;

public interface UserService {
	/**
	 * 添加用户
	 * 
	 * @param vo
	 */
	public void addUser(UserVo vo);

	/**
	 * 修改用户
	 * 
	 * @param vo
	 */
	public void updateUser(UserVo vo);

	/**
	 * 登录
	 * 
	 * @param accountNumber
	 * @param password
	 */
	public User login(String accountNumber, String password);

	/**
	 * 根据条件获取用户列表
	 * 
	 * @param accountNumber
	 * @param name
	 * @param departmentId
	 * @param roleId
	 * @return
	 */
	public List<User> getUserByParams(String accountNumber, String name, Long departmentId, Long roleId,
			String phoneNum, int page, int size);

	/**
	 * 通过ID 获取用户详情
	 * 
	 * @param userId
	 * @return
	 */
	User getUserInfo(Long userId);
}
