package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.Role;
import com.tonglukuaijian.commerce.dao.RoleDao;
import com.tonglukuaijian.commerce.mapper.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Role role) {
		jdbcTemplate.update("insert into T_ROLE (`NAME`,`EXPLAIN`,`STATUS`,CREATED_TIME) values(?,?,?,?)",
				new Object[] { role.getName(), role.getExplain(), role.getStatus(), role.getCreatedTime() });
	}

	@Override
	public void update(Role role) {
		jdbcTemplate.update("update T_ROLE set `NAME`=?,`EXPLAIN`=?,`STATUS`=? where ID=?",
				new Object[] { role.getName(), role.getExplain(), role.getStatus(), role.getId() });
	}

	@Override
	public List<Role> findAll() {
		List<Role> list = jdbcTemplate.query("select * from T_ROLE", new RoleMapper());
		return list;
	}

}
