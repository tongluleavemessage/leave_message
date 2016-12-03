package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.mapper.ProjectUserDtoMapper;

@Repository
public class ProjectUserDaoImpl implements ProjectUserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(ProjectUser projectUser) {
		jdbcTemplate.update("insert into T_PROJECT_USER (PROJECT_ID,USER_ID,CREATED_TIME) values(?,?,?)",
				new Object[] { projectUser.getProjectId(), projectUser.getUserId(), projectUser.getCreatedTime() });
	}

	@Override
	public void delete(Long Id) {
		jdbcTemplate.update("delete from T_PROJECT_USER where ID=?", Id);
	}

	@Override
	public List<ProjectUserDto> findByParams(String projectId, int page, int size) {
		List<ProjectUserDto> list = jdbcTemplate
				.query("select tp.ID,tu.ACCOUNT_NUMBER,tu.`NAME`,tu.PHONE_NUM from T_PROJECT_USER tp "
						+ " LEFT JOIN T_USERS tu on tp.USER_ID=tu.ID where tp.PROJECT_ID=" + projectId + " limit "
						+ (page - 1) + " ," + size, new ProjectUserDtoMapper());
		return list;
	}

}
