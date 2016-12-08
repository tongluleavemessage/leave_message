package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.Department;

public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int arg1) throws SQLException {
		Department department=new Department();
		department.setCreatedTime(rs.getTimestamp("CREATED_TIME"));
		department.setId(rs.getLong("ID"));
		department.setStatus(rs.getInt("STATUS"));
		department.setName(rs.getString("NAME"));
		return department;
	}

}
