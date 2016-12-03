package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.Project;
import com.tonglukuaijian.commerce.dao.ProjectDao;
import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.mapper.ProjectDtoMapper;
import com.tonglukuaijian.commerce.mapper.ProjectMapper;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Project project) {
		jdbcTemplate.update(
				"insert into T_PROJECT (DEPARTMENT_ID,MINISTER_USER_ID,GROUP_USER_ID,PROJECT_ID,PROJECT_NAME,PRINCIPAL_ID,CREATED_TIME) values(?,?,?,?,?,?,?)",
				new Object[] { project.getDepartmentId(), project.getMinisterUserId(), project.getGroupUserId(),
						project.getProjectId(), project.getProjectName(), project.getPrincipalId(),
						project.getCreatedTime() });
	}

	@Override
	public void update(Project project) {
		jdbcTemplate.update(
				"update T_PROJECT set DEPARTMENT_ID=?,MINISTER_USER_ID=?,GROUP_USER_ID=?,PRINCIPAL_ID=? where ID=?",
				new Object[] { project.getDepartmentId(), project.getMinisterUserId(), project.getGroupUserId(),
						project.getPrincipalId(), project.getId() });
	}

	@Override
	public List<ProjectDto> findByParams(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size) {
		String sql = " SELECT tp.ID,td.`NAME` DEPARTMENT_NAME, tp.PROJECT_ID, tp.PROJECT_NAME PROJECT_NAME, tr.`NAME` ROLE_NAME,tu.ACCOUNT_NUMBER,tu.`NAME` USER_NAME,tu.PHONE_NUM,tp.CREATED_TIME FROM"
				+ " T_PROJECT tp LEFT JOIN T_DEPARTMENT td ON tp.DEPARTMENT_ID = td.ID "
				+ " LEFT JOIN T_USERS tu ON tp.principal_id = tu.id "
				+ " LEFT JOIN T_ROLE tr ON tu.role_id = tr.id WHERE 1 = 1";
		if (null != departmentId) {
			sql += " and tp.DEPARTMENT_ID=" + departmentId;
		}
		if (null != projectId) {
			sql += " and tp.PROJECT_ID like %" + projectId + "%";
		}
		if (null != projectName) {
			sql += " and tp.PROJECT_NAME like %" + projectName + "%";
		}
		if (null != accountNumber) {
			sql += " and tu.ACCOUNT_NUMBER =" + accountNumber;
		}
		if (null != name) {
			sql += " and tu.NAME like % " + name + "%";
		}
		if (null != phoneNum) {
			sql += " and tu.PHONE_NUM like %" + phoneNum + "%";
		}
		sql += " order by tp.ID desc ";
		if (page > 0 && size > 0) {
			sql += "limit " + (page - 1) + "," + size;
		}
		List<ProjectDto> list = jdbcTemplate.query(sql, new ProjectDtoMapper());
		return list;
	}

	@Override
	public List<Project> findProjectByUserRelation(Long departmentId, Long ministerId, Long groupId, Long principalId,
			int page, int size) {
		String sql = "select * from T_PROJECT where 1=1 ";
		if (null != departmentId) {
			sql += " and DEPARTMENT_ID=" + departmentId;
		}
		if (null != ministerId) {
			sql += " and MINISTER_USER_ID=" + ministerId;
		}
		if (null != groupId) {
			sql += " and GROUP_USER_ID=" + groupId;
		}
		if (null != principalId) {
			sql += " and PRINCIPAL_ID=" + principalId;
		}
		sql += " order by ID desc";
		if (page > 0 && size > 0) {
			sql += " limit " + (page - 1) + "," + size;
		}
		List<Project> list = jdbcTemplate.query(sql, new ProjectMapper());
		return list;
	}

	@Override
	public Project findProjectPrincipals(String projectId) {
		Project project = jdbcTemplate.queryForObject("SELECT * FROM T_PROJECT WHERE PROJECT_ID=" + projectId,
				new ProjectMapper());
		return project;
	}

}
