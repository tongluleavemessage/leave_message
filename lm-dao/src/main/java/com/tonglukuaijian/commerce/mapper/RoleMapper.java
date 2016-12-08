package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.Role;

public class RoleMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int arg1) throws SQLException {
		Role role = new Role();
		role.setId(rs.getLong("ID"));
		role.setName(rs.getString("NAME"));
		role.setExplain(rs.getString("EXPLAIN"));
		role.setStatus(rs.getInt("STATUS"));
		role.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		return role;
	}

}
