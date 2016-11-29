package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.dto.ProjectDto;

public class ProjectDtoMapper implements RowMapper<ProjectDto> {

	@Override
	public ProjectDto mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectDto project=new ProjectDto();
		project.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
		project.setRoleName(rs.getString("ROLE_NAME"));
		project.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		project.setUserName(rs.getString("USER_NAME"));
		project.setPhoneNum(rs.getString("PHONE_NUM"));
		project.setCreatedTime(rs.getDate("CREATED_TIME"));
		project.setId(rs.getLong("ID"));
		project.setProjectId(rs.getString("PROJECT_ID"));
		project.setProjectName(rs.getString("PROJECT_NAME"));
		return project;
	}

}
