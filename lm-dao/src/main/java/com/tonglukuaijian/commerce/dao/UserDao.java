package com.tonglukuaijian.commerce.dao;

import java.util.List;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.dto.UserDto;

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
	public List<UserDto> findByParams(String accountNumber, String name, Long departmentId, Long roleId, String phoneNum,
			int page, int size);

	/**
	 * 通过账号查询用户
	 * 
	 * @param accountNumber
	 * @return
	 */
	User findByAccountNumber(String accountNumber);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 根据ID查询userdto
	 * @param userId
	 * @return
	 */
	UserDto findUserDtoById(Long userId);

	/**
	 * 根据id 查询user
	 * @param userId
	 * @return
	 */
	User findUserById(Long userId);
}
