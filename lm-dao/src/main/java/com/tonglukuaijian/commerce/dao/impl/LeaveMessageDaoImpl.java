package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Base64Utils;

import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.dao.LeaveMessageDao;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;
import com.tonglukuaijian.commerce.mapper.LeaveMessageDtoMapper;
import com.tonglukuaijian.commerce.mapper.LeaveMessageMapper;

@Repository
public class LeaveMessageDaoImpl implements LeaveMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveLeaveMesage(LeaveMessage leaveMessage) {
		jdbcTemplate.update(
				"insert into T_LEAVE_MESSAGE(name,project_id,project_name,phoneNum,content,status,createdTime,BELONGTO_USER) values(?,?,?,?,?,?,?)",
				new Object[] { leaveMessage.getName(), leaveMessage.getProjectId(), leaveMessage.getProjectName(),
						leaveMessage.getPhoneNum().getBytes(), leaveMessage.getContent(), leaveMessage.getStatus(),
						leaveMessage.getCreatedTime(), leaveMessage.getBelongToUserId() });
	}

	@Override
	public List<LeaveMessageInfo> findByParams(Long principalUserId, String beLongUserId, String projectId,
			String projectName, String principalName, String principalPhone, String customerName, String status,
			String createdTimeStart, String createdTimeEnd, int page, int size) {
		String sql = "select tm.ID,tm.PROJECT_ID,tm.PROJECT_NAME,tu.`NAME` PRINCIPAL,tu.PHONE_NUM PRINCIPAL_PHONE,tm.`NAME` CUSTOMER_NAME,tm.PHONE_NUM CUSTOMER_PHONE,tm.CONTENT,tm.STATUS,tm.CREATED_TIME from "
				+ " T_LEAVE_MESSAGE tm LEFT JOIN T_PROJECT tp on tm.PROJECT_ID=tp.PROJECT_ID"
				+ " LEFT JOIN T_USERS PRINCIPALUSER on tp.PRINCIPAL_ID=PRINCIPALUSER.ID where 1=1";
		if (null != projectId) {
			sql += " and tm.PROJECT_ID=" + projectId;
		}
		if (null != principalUserId) {
			sql += " and tp.PRINCIPAL_ID =" + principalUserId;
		}
		if (null != beLongUserId) {
			sql += " and tp.BELONGTO_USER_ID in(" + beLongUserId + ")";
		}
		if (null != projectName) {
			sql += " and tm.PROJECT_NAME like %" + projectName + "%";
		}
		if (null != principalName) {
			sql += " and PRINCIPALUSER.`NAME` = " + principalName;
		}
		if (null != principalPhone) {
			sql += " and PRINCIPALUSER.PHONE_NUM like %" + principalPhone + "%";
		}
		if (null != customerName) {
			sql += " and tm.`NAME` like %" + customerName + "%";
		}
		if (null != status) {
			sql += " and tm.`STATUS` in (" + status + ")";
		}
		if (null != createdTimeStart && null != createdTimeEnd) {
			sql += " and tm.CREATED_TIME between" + createdTimeStart + " and " + createdTimeEnd;
		} else {
			if (null != createdTimeStart) {
				sql += " and  tm.CREATED_TIME >=" + createdTimeStart;
			} else if (null != createdTimeEnd) {
				sql += " and tm.CREATED_TIME <=" + createdTimeEnd;
			}
		}
		sql += " order by ID desc";
		if (page > 0 && size > 0) {
			sql += " limit " + (page * size) + "," + size;
		}

		List<LeaveMessageInfo> list = jdbcTemplate.query(sql, new LeaveMessageDtoMapper());
		return list;
	}

	@Override
	public void assign(Long id, Long userId) {
		String sql = "UPDATE T_LEAVE_MESSAGE SET BELONGTO_USER_ID=? , MODIFY_TIME=now() WHERE ID=?";
		jdbcTemplate.update(sql, new Object[] { userId, id });
	}

	@Override
	public LeaveMessage findById(Long id) {
		return jdbcTemplate.queryForObject("select * from T_LEAVE_MESSAGE where ID=" + id, new LeaveMessageMapper());
	}

}
