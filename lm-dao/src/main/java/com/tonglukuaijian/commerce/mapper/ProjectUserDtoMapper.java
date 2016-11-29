package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.dto.ProjectUserDto;

public class ProjectUserDtoMapper implements RowMapper<ProjectUserDto> {

	@Override
	public ProjectUserDto mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectUserDto po=new ProjectUserDto();
		po.setId(rs.getLong("ID"));
		po.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		po.setName(rs.getString("NAME"));
		po.setPhoneNum(rs.getString("PHONE_NUM"));
		return po;
	}
	
}
