package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;
import com.tonglukuaijian.commerce.dao.LeaveMessageAssignRecordDao;
import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;
import com.tonglukuaijian.commerce.mapper.LeaveMessageAssignRecordDtoMapper;
import com.tonglukuaijian.commerce.mapper.LeaveMessageAssignRecordMapper;

@Repository
public class LeaveMessageAssignRecordDaoImpl implements LeaveMessageAssignRecordDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(LeaveMessageAssignRecord po) {
		jdbcTemplate.update(
				"insert into T_LEAVE_MESSAGE_ASSIGN_RECORD (OPERATOR_USER_NAME,OPERATOR_ROLE_NAME,LEAVE_MESSAGE_ID,LEAVE_MESSAGE_STATUS,ASSIGN_USER_ACCOUNT_NUMBER,ASSIGN_USER_NAME,ASSIGN_USER_ROLE_NAME,CREATED_TIME) values(?,?,?,?,?,?,?,?)",
				new Object[] { po.getOperatorUserName(), po.getOperatorRoleName(), po.getLeaveMessageId(),
						po.getLeaveMessageStatus(), po.getAssignUserAccountNumber(), po.getAssignUserName(),
						po.getAssignRoleName(), po.getCreatedTime() });
	}

	@Override
	public List<LeaveMessageAssignRecordDto> findByParams(String projectId, String projectName, String projectPrincipal,
			String principalPhone, String customerName, Integer status, String createdTimeStart, String createdTimeEnd,
			int page, int size) {
		String sql = "SELECT TLR.ID, TM.PROJECT_ID, TM.PROJECT_NAME, TM.`NAME` CUSTOMER_NAME, TLR.LEAVE_MESSAGE_STATUS, TM.CREATED_TIME LEAVE_MESSAGE_CREATED_TIME, TU.`NAME` PROJECT_PRINCIPAL_NAME, TU.PHONE_NUM, TLR.OPERATOR_USER_NAME, TLR.OPERATOR_ROLE_NAME, TLR.ASSIGN_USER_NAME, TLR.CREATED_TIME"
				+ "FROM T_LEAVE_MESSAGE_ASSIGN_RECORD TLR"
				+ "LEFT JOIN T_LEAVE_MESSAGE TM ON TLR.LEAVE_MESSAGE_ID = TM.ID"
				+ "LEFT JOIN T_USERS TU ON TM.PRINCIPAL_USER_ID = TU.ID WHERE 1=1";
		if (null != projectId) {
			sql += " and TM.PROJECT_ID=" + projectId;
		}
		if (null != projectName) {
			sql += " and TM.PROJECT_NAME like %" + projectName + "%";
		}
		if (null != projectPrincipal) {
			sql += " and TU.`NAME` like %" + projectPrincipal + "%";
		}
		if (null != principalPhone) {
			sql += " and TU.PHONE_NUM like %" + principalPhone + "%";
		}
		if (null != customerName) {
			sql += " and TM.`NAME` like %" + customerName + "%";
		}
		if (status > 0) {
			sql += " and TLR.LEAVE_MESSAGE_STATUS=" + status;
		}
		if (null != createdTimeStart && null != createdTimeEnd) {
			sql += " and TM.CREATED_TIME between " + createdTimeStart + " and " + createdTimeEnd;
		} else {
			if (null != createdTimeStart) {
				sql += " and TM.CREATED_TIME>=" + createdTimeStart;
			} else if (null != createdTimeEnd) {
				sql += " and TM.CREATED_TIME<=" + createdTimeEnd;
			}
		}
		sql += " order by ID desc";
		if (page > 0 && size > 0) {
			sql += " limit " + (page - 1) + " , " + size;
		}
		List<LeaveMessageAssignRecordDto> list = jdbcTemplate.query(sql, new LeaveMessageAssignRecordDtoMapper());
		return list;
	}

	@Override
	public List<LeaveMessageAssignRecord> findByLeaveMessageId(Long leaveMessageId) {
		List<LeaveMessageAssignRecord> list = jdbcTemplate.query(
				"SELECT * FROM T_LEAVE_MESSAGE_ASSIGN_RECORD WHERE LEAVE_MESSAGE_ID=" + leaveMessageId,
				new LeaveMessageAssignRecordMapper());
		return list;
	}
	
	@Override
	public LeaveMessageAssignRecord findById(Long id) {
		LeaveMessageAssignRecord assignRecord = jdbcTemplate.queryForObject(
				"SELECT * FROM T_LEAVE_MESSAGE_ASSIGN_RECORD WHERE ID=" + id,
				new LeaveMessageAssignRecordMapper());
		return assignRecord;
	}

}
