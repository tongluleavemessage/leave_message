package com.tonglukuaijian.commerce.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.dao.LeaveMessageDao;

@Repository
public class LeaveMessageDaoImpl implements LeaveMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveLeaveMesage(LeaveMessage leaveMessage) {
		jdbcTemplate.update(
				"insert into T_LEAVE_MESSAGE(name,project_id,project_name,phoneNum,content,status,createdTime) values(?,?,?,?,?,?)",
				new Object[] { leaveMessage.getName(), leaveMessage.getProjectId(), leaveMessage.getProjectName(),
						leaveMessage.getPhoneNum(), leaveMessage.getContent(), leaveMessage.getStatus(),
						leaveMessage.getCreatedTime() });
	}

}
