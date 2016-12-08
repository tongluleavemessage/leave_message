package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.dao.UserDao;
import com.tonglukuaijian.commerce.dto.UserDto;
import com.tonglukuaijian.commerce.mapper.UserDtoMapper;
import com.tonglukuaijian.commerce.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private OrmTemplate ormTemplate;

	@Override
	public void save(User user) {
		ormTemplate.update(
				"insert into T_USERS(ACCOUNT_NUMBER,PASSWORD,NAME,PHONE_NUM,DEPARTMENT_ID,ROLE_ID,STATUS,CREATED_TIME) values(?,?,?,?,?,?,?,?)",
				new Object[] { user.getAccountNumber(), user.getPassword(), user.getName(), user.getPhoneNum(),
						user.getDepartmentId(), user.getRoleId(), user.getStatus(), user.getCreatedTime() });
	}

	@Override
	public void update(User user) {
		ormTemplate.update(
				"update T_USERS set PASSWORD=?,PHONE_NUM=?,DEPARTMENT_ID=?,ROLE_ID=?,STATUS=?,LOGIN_TIME=? WHERE ID=?",
				new Object[] { user.getPassword().getBytes(), user.getPhoneNum(), user.getDepartmentId(),
						user.getRoleId(), user.getStatus(), user.getLoginTime(), user.getId() });
	}

	@Override
	public UserDto findUserDtoById(Long userId) {
		String sql = "select tu.ID,tu.ACCOUNT_NUMBER,tu.`NAME`,tu.PHONE_NUM,tu.DEPARTMENT_ID,td.`NAME` DEPATRMENTNAME,tu.ROLE_ID,tr.`NAME` ROLENAME,tu.`STATUS`,tu.CREATED_TIME,tu.LOGIN_TIME from T_USERS  tu LEFT JOIN T_ROLE tr on tu.ROLE_ID=tr.ID"
				+ " LEFT JOIN T_DEPARTMENT td on tu.DEPARTMENT_ID=td.ID where tu.ID=?";
		Object[] params = new Object[] { userId };
		return ormTemplate.queryForObject(sql, params, new UserDtoMapper());
	}

	@Override
	public User findUserById(Long userId) {
		String sql = "select * from T_USERS where ID=?";
		Object[] params = new Object[] { userId };
		return ormTemplate.queryForObject(sql, params, new UserMapper());

	}

	@Override
	public User findByAccountNumber(String accountNumber) {
		String sql = "select * from T_USERS where ACCOUNT_NUMBER=?";
		Object[] params = new Object[] { accountNumber };
		User user = ormTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	@Override
	public User findByAccountNumberAndPassword(String accountNumber, String password) {
		String sql = "select * from T_USERS where ACCOUNT_NUMBER=? AND PASSWORD=?";
		Object[] params = new Object[] { accountNumber, password };
		User user = ormTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	@Override
	public void delete(Long id) {
		String sql = "delete  from T_USERS where ID=?";
		Object[] params = new Object[] { id };
		ormTemplate.update(sql, params);
	}

	@Override
	public List<UserDto> findByParams(String accountNumber, String name, Long departmentId, Long roleId,
			String phoneNum, int page, int size) {
		String sql = "select tu.ID,tu.ACCOUNT_NUMBER,tu.`NAME`,tu.PHONE_NUM,tu.DEPARTMENT_ID,td.`NAME` DEPATRMENTNAME,tu.ROLE_ID,tr.`NAME` ROLENAME,tu.`STATUS`,tu.CREATED_TIME,tu.LOGIN_TIME from T_USERS  tu LEFT JOIN T_ROLE tr on tu.ROLE_ID=tr.ID"
				+ " LEFT JOIN T_DEPARTMENT td on tu.DEPARTMENT_ID=td.ID where 1=1";
		if (accountNumber != null) {
			sql += " and tu.ACCOUNT_NUMBER = '" + accountNumber + "'";
		}
		if (null != phoneNum) {
			sql += " and tu.PHONE_NUM like %" + phoneNum + "%";
		}
		if (name != null) {
			sql += " and tu.`NAME` like %" + name + "%";
		}
		if (departmentId != null) {
			sql += " and tu.DEPARTMENT_ID =" + departmentId;
		}
		if (roleId != null) {
			sql += " and tu.ROLE_ID =" + roleId;
		}
		sql += " order by tu.ID desc ";
		if (page > 0 && size > 0) {
			sql += " limit " + (page - 1) * size + "," + size;
		}
		return ormTemplate.query(sql, new UserDtoMapper());

	}
}
