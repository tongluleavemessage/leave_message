package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.dao.UserDao;
import com.tonglukuaijian.commerce.dto.UserDto;
import com.tonglukuaijian.commerce.enums.CommonStatusEnum;
import com.tonglukuaijian.commerce.enums.RoleEnum;
import com.tonglukuaijian.commerce.enums.UserUsingEnum;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.UserService;
import com.tonglukuaijian.commerce.util.CommonUtils;
import com.tonglukuaijian.commerce.vo.LoginVo;
import com.tonglukuaijian.commerce.vo.UpdateUserVo;
import com.tonglukuaijian.commerce.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public OutMessage<?> addUser(UserVo vo) {

		User user = userDao.findByAccountNumber(vo.getAccountNumber());
		if (user != null) {
			return OutMessage.errorMessage("该账户已存在");
		}
		user = wrapUser(vo);
		userDao.save(user);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> updateUser(UpdateUserVo vo) {
		User user = userDao.findUserById(vo.getUserId());
		if (null == user) {
			return OutMessage.errorMessage("用户不存在");
		}
		if (vo.getDepartmentId() != null) {
			user.setDepartmentId(vo.getDepartmentId());
		}
		if (vo.getPhoneNumber() != null) {
			user.setPhoneNum(vo.getPhoneNumber());
		}
		if (vo.getRoleId() != null) {
			user.setRoleId(vo.getRoleId());
		}
		if (vo.getStatus() != null) {
			user.setStatus(vo.getStatus());
		}
		if (vo.getPassword() != null) {
			user.setPassword(DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
		}
		userDao.update(user);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> delete(Long loginUserId, Long id) {
		User user = userDao.findUserById(loginUserId);
		if (user.getRoleId() != RoleEnum.ADMINISTRATOR.value()) {
			return OutMessage.errorMessage("无此权限");
		}
		userDao.delete(id);
		return OutMessage.successMessage();
	}

	private User wrapUser(UserVo vo) {
		User user = new User();
		user.setName(vo.getName());
		user.setAccountNumber(vo.getAccountNumber());
		user.setDepartmentId(vo.getDepartmentId());
		user.setPassword(DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
		user.setPhoneNum(vo.getPhoneNumber());
		user.setUsing(UserUsingEnum.NONUSE.value());
		user.setRoleId(vo.getRoleId());
		user.setStatus(vo.getStatus());
		user.setCreatedTime(new Date());
		return user;
	}

	@Override
	public OutMessage<User> login(LoginVo vo) {
		User user = userDao.findByAccountNumberAndPassword(vo.getAccountNumber(),
				DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
		if (null == user || user.getStatus() == CommonStatusEnum.CLOSE.value()) {
			return OutMessage.errorMessage("账号密码输入有误或不存在");
		}
		// 修改登录时间
		user.setLoginTime(new Date());
		userDao.update(user);
		return OutMessage.successMessage(user);
	}

	@Override
	public OutMessage<?> getUserInfo(Long userId) {
		UserDto user = userDao.findUserDtoById(userId);
		if (null == user) {
			return OutMessage.errorMessage("用户不存在");
		}
		return OutMessage.successMessage(user);
	}

	@Override
	public OutMessage<?> getUserByParams(String accountNumber, String name, Long departmentId, Long roleId,
			String phoneNum, int page, int size) {
		List<UserDto> lists = userDao.findByParams(accountNumber, name, departmentId, roleId, phoneNum, page, size);
		return OutMessage.successMessage(lists);
	}

}
