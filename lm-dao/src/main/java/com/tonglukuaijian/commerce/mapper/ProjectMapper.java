package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.Project;

public class ProjectMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int arg1) throws SQLException {
		Project project=new Project();
		project.setCreatedTime(rs.getDate("CREATED_TIME"));
		project.setDepartmentId(rs.getLong("DEPARTMENT_ID"));
		project.setGroupUserId(rs.getLong("GROUP_USER_ID"));
		project.setId(rs.getLong("ID"));
		project.setMinisterUserId(rs.getLong("MINISTER_USER_ID"));
		project.setPrincipalId(rs.getLong("PRINCIPAL_ID"));
		project.setProjectId(rs.getString("PROJECT_ID"));
		project.setProjectName(rs.getString("PROJECT_NAME"));
		return project;
	} 

}
