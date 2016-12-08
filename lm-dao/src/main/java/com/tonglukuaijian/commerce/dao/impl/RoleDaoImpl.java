package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.dao.RoleDao;
import com.tonglukuaijian.commerce.mapper.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private OrmTemplate ormTemplate;

	@Override
	public void save(Role role) {
		ormTemplate.update("insert into T_ROLE (`NAME`,`EXPLAIN`,`STATUS`,CREATED_TIME) values(?,?,?,?)",
				new Object[] { role.getName(), role.getExplain(), role.getStatus(), role.getCreatedTime() });
	}

	@Override
	public void update(Role role) {
		ormTemplate.update("update T_ROLE set `NAME`=?,`EXPLAIN`=?,`STATUS`=? where ID=?",
				new Object[] { role.getName(), role.getExplain(), role.getStatus(), role.getId() });
	}

	@Override
	public List<Role> findAll(int page, int size) {
		String sql = "select * from T_ROLE order by ID desc";
		if (page > 0 && size > 0) {
			sql += "limit " + (page - 1 * size) + " , " + size;
		}
		List<Role> list = ormTemplate.query(sql, new RoleMapper());
		return list;
	}

	@Override
	public Role findById(Long id) {
		Object[] params = new Object[] { id };
		return ormTemplate.queryForObject("select * from T_ROLE where ID=?", params, new RoleMapper());
	}

}
