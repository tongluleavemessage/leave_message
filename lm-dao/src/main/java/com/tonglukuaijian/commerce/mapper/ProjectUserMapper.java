package com.tonglukuaijian.commerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tonglukuaijian.commerce.bean.ProjectUser;

public class ProjectUserMapper implements RowMapper<ProjectUser> {

	@Override
	public ProjectUser mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectUser po=new ProjectUser();
		po.setCreatedTime(rs.getDate("CREATED_TIME"));
		po.setId(rs.getLong("ID"));
		po.setProjectId(rs.getString("PROJECT_ID"));
		po.setUserId(rs.getLong("USER_ID"));
		return null;
		
	}
	
}
