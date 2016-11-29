package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setName(rs.getString("NAME"));
		user.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		user.setDepartmentId(rs.getLong("DEPARTMENT_ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setPhoneNum(rs.getString("PHONE_NUM"));
		user.setRoleId(rs.getLong("ROLE_ID"));
		user.setStatus(rs.getInt("STATUS"));
		return user;
	}

}
