package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.bean.Department;
import com.tonglukuaijian.commerce.dao.DepartmentDao;
import com.tonglukuaijian.commerce.mapper.DepartmentMapper;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private OrmTemplate ormTemplate;

	@Override
	public void save(Department department) {
		ormTemplate.update("insert into T_DEPARTMENT (`NAME`,`STATUS`,CREATED_TIME) values(?,?,?)",
				new Object[] { department.getName(), department.getStatus(), department.getCreatedTime() });
	}

	@Override
	public void update(Department department) {
		ormTemplate.update("update T_DEPARTMENT SET `NAME`=?,`STATUS`=? where ID=?",
				new Object[] { department.getName(), department.getStatus(), department.getId() });
	}

	@Override
	public Department findById(Long departmentId) {
		String sql = "select * from T_DEPARTMENT where ID=?";
		Object[] params = new Object[] { departmentId };
		return ormTemplate.queryForObject(sql, params, new DepartmentMapper());
	}

	@Override
	public List<Department> findAll(int page, int size) {
		String sql = "select * from T_DEPARTMENT order by ID desc";
		if (page > 0 && size > 0) {
			sql += " limit " + (page - 1) * size + " , " + size;
		}
		List<Department> list = ormTemplate.query(sql, new DepartmentMapper());
		return list;
	}

}
