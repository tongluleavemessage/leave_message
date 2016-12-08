package com.tonglukuaijian.commerce.service;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.vo.LoginVo;
import com.tonglukuaijian.commerce.vo.UpdateUserVo;
import com.tonglukuaijian.commerce.vo.UserVo;

public interface UserService {
	/**
	 * 添加用户
	 * 
	 * @param vo
	 */
	public OutMessage<?> addUser(UserVo vo);

	/**
	 * 修改用户
	 * 
	 * @param vo
	 */
	public OutMessage<?> updateUser(UpdateUserVo vo);

	/**
	 * 登录
	 * 
	 * @param accountNumber
	 * @param password
	 */
	public OutMessage<User> login(LoginVo vo);

	/**
	 * 根据条件获取用户列表
	 * 
	 * @param accountNumber
	 * @param name
	 * @param departmentId
	 * @param roleId
	 * @return
	 */
	public OutMessage<?> getUserByParams(String accountNumber, String name, Long departmentId, Long roleId,
			String phoneNum, int page, int size);

	/**
	 * 通过ID 获取用户详情
	 * 
	 * @param userId
	 * @return
	 */
	OutMessage<?> getUserInfo(Long userId);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	OutMessage<?> delete(Long loginUserId, Long id);
}
