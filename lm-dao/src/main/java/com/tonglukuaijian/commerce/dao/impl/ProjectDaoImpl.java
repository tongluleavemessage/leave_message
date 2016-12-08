package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.bean.Project;
import com.tonglukuaijian.commerce.dao.ProjectDao;
import com.tonglukuaijian.commerce.dto.ProjectDto;
import com.tonglukuaijian.commerce.mapper.ProjectDtoMapper;
import com.tonglukuaijian.commerce.mapper.ProjectMapper;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	OrmTemplate ormTemplate;

	@Override
	public void save(Project project) {
		ormTemplate.update(
				"insert into T_PROJECT (DEPARTMENT_ID,MINISTER_USER_ID,GROUP_USER_ID,PROJECT_ID,PROJECT_NAME,PRINCIPAL_ID,CREATED_TIME) values(?,?,?,?,?,?,?)",
				new Object[] { project.getDepartmentId(), project.getMinisterUserId(), project.getGroupUserId(),
						project.getProjectId(), project.getProjectName(), project.getPrincipalId(),
						project.getCreatedTime() });
	}

	@Override
	public void update(Project project) {
		ormTemplate.update(
				"update T_PROJECT set DEPARTMENT_ID=?,MINISTER_USER_ID=?,GROUP_USER_ID=?,PRINCIPAL_ID=? where ID=?",
				new Object[] { project.getDepartmentId(), project.getMinisterUserId(), project.getGroupUserId(),
						project.getPrincipalId(), project.getId() });
	}

	@Override
	public Project findById(Long id) {
		Object[] params = new Object[] { id };
		return ormTemplate.queryForObject(" select * from T_PROJECT where ID= ?", params, new ProjectMapper());
	}

	@Override
	public List<ProjectDto> findByParams(Long departmentId, String projectId, String projectName, String accountNumber,
			String name, String phoneNum, int page, int size) {
		String sql = " SELECT tp.ID,td.`NAME` DEPARTMENT_NAME, tp.PROJECT_ID, tp.PROJECT_NAME PROJECT_NAME, 	gu.ACCOUNT_NUMBER GROUP_NUMBER, "
				+ " gu.`NAME` GROUP_NAME, mu.ACCOUNT_NUMBER MINISTER_NUMBER, mu.`NAME` MINISTER_NAME, tr.`NAME` ROLE_NAME,"
				+ " tu.ACCOUNT_NUMBER,tu.`NAME` USER_NAME,tu.PHONE_NUM,tp.CREATED_TIME FROM"
				+ " T_PROJECT tp LEFT JOIN T_DEPARTMENT td ON tp.DEPARTMENT_ID = td.ID "
				+ " LEFT JOIN T_USERS tu ON tp.principal_id = tu.ID "
				+ " LEFT JOIN T_USERS gu ON tp.GROUP_USER_ID = gu.ID "
				+ " LEFT JOIN T_USERS mu ON tp.MINISTER_USER_ID = mu.ID "
				+ " LEFT JOIN T_ROLE tr ON tu.role_id = tr.id where 1=1 ";
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
			sql += " and tu.ACCOUNT_NUMBER = '" + accountNumber + "'";
		}
		if (null != name) {
			sql += " and tu.NAME like % " + name + "%";
		}
		if (null != phoneNum) {
			sql += " and tu.PHONE_NUM like %" + phoneNum + "%";
		}
		sql += " order by tp.ID desc ";
		if (page > 0 && size > 0) {
			sql += "limit " + (page - 1)*size + "," + size;
		}
		List<ProjectDto> list = ormTemplate.query(sql, new ProjectDtoMapper());
		return list;
	}

	@Override
	public ProjectDto findProjectDtoById(Long id) {
		String sql = " SELECT tp.ID,td.`NAME` DEPARTMENT_NAME, tp.PROJECT_ID, tp.PROJECT_NAME PROJECT_NAME, 	gu.ACCOUNT_NUMBER GROUP_NUMBER, "
				+ " gu.`NAME` GROUP_NAME, mu.ACCOUNT_NUMBER MINISTER_NUMBER, mu.`NAME` MINISTER_NAME, tr.`NAME` ROLE_NAME,"
				+ " tu.ACCOUNT_NUMBER,tu.`NAME` USER_NAME,tu.PHONE_NUM,tp.CREATED_TIME FROM"
				+ " T_PROJECT tp LEFT JOIN T_DEPARTMENT td ON tp.DEPARTMENT_ID = td.ID "
				+ " LEFT JOIN T_USERS tu ON tp.principal_id = tu.ID "
				+ " LEFT JOIN T_USERS gu ON tp.GROUP_USER_ID = gu.ID "
				+ " LEFT JOIN T_USERS mu ON tp.MINISTER_USER_ID = mu.ID "
				+ " LEFT JOIN T_ROLE tr ON tu.role_id = tr.id where tp.ID=? ";
		Object[] params = new Object[] { id };
		ProjectDto dto = ormTemplate.queryForObject(sql, params, new ProjectDtoMapper());
		return dto;
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
			sql += " limit " + (page - 1) * size + "," + size;
		}
		List<Project> list = ormTemplate.query(sql, new ProjectMapper());
		return list;
	}

	@Override
	public Project findProjectPrincipals(String projectId) {
		Object[] params = new Object[] { projectId };
		Project project = ormTemplate.queryForObject("SELECT * FROM T_PROJECT WHERE PROJECT_ID=?", params,
				new ProjectMapper());
		return project;
	}

}
