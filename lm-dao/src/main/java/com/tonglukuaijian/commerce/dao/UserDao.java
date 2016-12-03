package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.User;

/**
 * 用户
 *
 * @author Lhy 2016年11月22日下午2:18:03
 */
public interface UserDao {
	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User findById(Long userId);

	/**
	 * 用户名 密码获取用户
	 * 
	 * @param accountNumber
	 * @param password
	 * @return
	 */
	public User findByAccountNumberAndPassword(String accountNumber, String password);

	/**
	 * 根据条件查询用户
	 * 
	 * @param accountNumber
	 * @param name
	 * @param departmentId
	 * @param roleId
	 * @return
	 */
	public List<User> findByParams(String accountNumber, String name, Long departmentId, Long roleId, String phoneNum,int page,
			int size);
}
