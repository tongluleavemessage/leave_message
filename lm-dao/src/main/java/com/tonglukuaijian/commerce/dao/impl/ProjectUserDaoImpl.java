package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.batch.ProjectUserBatch;
import com.tonglukuaijian.commerce.bean.ProjectUser;
import com.tonglukuaijian.commerce.dao.ProjectUserDao;
import com.tonglukuaijian.commerce.dto.ProjectUserDto;
import com.tonglukuaijian.commerce.mapper.ProjectUserDtoMapper;

@Repository
public class ProjectUserDaoImpl implements ProjectUserDao {

	@Autowired
	private OrmTemplate ormTemplate;

	@Override
	public void save(List<ProjectUser> projectUser) {
		ormTemplate.batchUpdate("insert into T_PROJECT_USER (PROJECT_ID,USER_ID,CREATED_TIME) values(?,?,?)",
				new ProjectUserBatch(projectUser));
	}

	@Override
	public void delete(Long Id) {
		ormTemplate.update("delete from T_PROJECT_USER where ID=?", Id);
	}

	@Override
	public List<ProjectUserDto> findByParams(String projectId, int page, int size) {
		Object[] params = new Object[] { projectId };
		String sql = "select tp.ID,tu.ACCOUNT_NUMBER,tu.`NAME`,tu.PHONE_NUM from T_PROJECT_USER tp "
				+ " LEFT JOIN T_USERS tu on tp.USER_ID=tu.ID where tp.PROJECT_ID=?";
		if (page > 0 && size > 0) {
			sql += " and limit " + (page - 1) * size + "," + size;
		}
		List<ProjectUserDto> list = ormTemplate.query(sql, params, new ProjectUserDtoMapper());
		return list;
	}

}
