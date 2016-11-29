package com.tonglukuaijian.commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.dao.UserDao;
import com.tonglukuaijian.commerce.enums.UserUsingEnum;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.UserService;
import com.tonglukuaijian.commerce.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserVo vo) {
		if (null == vo.getAccountNumber()) {
			throw new ServiceException("账号不能为空");
		}
		User user = wrapUser(vo);
		userDao.save(user);

	}

	@Override
	public void updateUser(UserVo vo) {
		if (null == vo.getUserId()) {
			throw new ServiceException("未指定用户");
		}
		User user = wrapUser(vo);
		userDao.update(user);
	}

	private User wrapUser(UserVo vo) {
		User user = new User();
		user.setId(vo.getUserId());
		user.setName(vo.getName());
		user.setAccountNumber(vo.getAccountNumber());
		user.setDepartmentId(vo.getDepartmentId());
		user.setPassword(vo.getPassword());
		user.setPhoneNum(vo.getPhoneNumber());
		user.setUsing(UserUsingEnum.NONUSE.value());
		user.setRoleId(vo.getRoleId());
		user.setStatus(vo.getStatus());
		return user;
	}

	@Override
	public User login(String accountNumber, String password) {
		User user = userDao.findByAccountNumberAndPassword(accountNumber,
				DigestUtils.md5DigestAsHex(password.getBytes()));
		if (null == user) {
			throw new ServiceException("用户不存在");
		}
		return user;
	}

	@Override
	public List<User> getUserByParams(String accountNumber, String name, Long departmentId, Long roleId, int page,
			int size) {
		List<User> lists = userDao.findByParams(accountNumber, name, departmentId, roleId,page,size);
		return lists;
	}

}
