package com.tonglukuaijian.commerce.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tonglukuaijian.commerce.OrmTemplate;
import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.dao.LeaveMessageDao;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;
import com.tonglukuaijian.commerce.mapper.LeaveMessageDtoMapper;
import com.tonglukuaijian.commerce.mapper.LeaveMessageMapper;

@Repository
public class LeaveMessageDaoImpl implements LeaveMessageDao {

	@Autowired
	private OrmTemplate ormTemplate;

	@Override
	public void saveLeaveMesage(LeaveMessage leaveMessage) {
		ormTemplate.update(
				"insert into T_LEAVE_MESSAGE(name,project_id,project_name,PHONE_NUM,content,status,CREATED_TIME,BELONGTO_USER_ID) values(?,?,?,?,?,?,?,?)",
				new Object[] { leaveMessage.getName(), leaveMessage.getProjectId(), leaveMessage.getProjectName(),
						leaveMessage.getPhoneNum().getBytes(), leaveMessage.getContent(), leaveMessage.getStatus(),
						leaveMessage.getCreatedTime(), leaveMessage.getBelongToUserId() });
	}

	@Override
	public void updateLeaveMesage(LeaveMessage leaveMessage) {
		ormTemplate.update("update T_LEAVE_MESSAGE set  MODIFY_TIME=?,PRINCIPAL_USER_ID,STATUS=? where ID=?",
				new Object[] { leaveMessage.getModifyTime(), leaveMessage.getPrincipal(), leaveMessage.getStatus(),
						leaveMessage.getId() });
	}

	@Override
	public List<LeaveMessageInfo> findByParams(Long principalUserId, String beLongUserId, String projectId,
			String projectName, String principalName, String principalPhone, String customerName, String status,
			String createdTimeStart, String createdTimeEnd, int page, int size) {
		String sql = "select tm.ID,tm.PRINCIPAL_USER_ID,tm.PROJECT_ID,tm.PROJECT_NAME,PRINCIPALUSER.`NAME` PRINCIPAL,PRINCIPALUSER.PHONE_NUM PRINCIPAL_PHONE,tm.`NAME` CUSTOMER_NAME,tm.PHONE_NUM CUSTOMER_PHONE,tm.CONTENT,tm.STATUS,tm.CREATED_TIME from "
				+ " T_LEAVE_MESSAGE tm LEFT JOIN T_PROJECT tp on tm.PROJECT_ID=tp.PROJECT_ID"
				+ " LEFT JOIN T_USERS PRINCIPALUSER on tp.PRINCIPAL_ID=PRINCIPALUSER.ID where 1=1";
		if (null != projectId) {
			sql += " and tm.PROJECT_ID= '" + projectId + "'";
		}
		if (null != principalUserId) {
			sql += " and tp.PRINCIPAL_ID =" + principalUserId;
		}
		if (null != beLongUserId) {
			sql += " and tm.BELONGTO_USER_ID in(" + beLongUserId + ")";
		}
		if (null != projectName) {
			sql += " and tm.PROJECT_NAME like %" + projectName + "%";
		}
		if (null != principalName) {
			sql += " and PRINCIPALUSER.`NAME` = '" + principalName + "'";
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
			sql += " and tm.CREATED_TIME between '" + createdTimeStart + "' and '" + createdTimeEnd + "'";
		} else {
			if (null != createdTimeStart) {
				sql += " and  tm.CREATED_TIME >= '" + createdTimeStart + "'";
			} else if (null != createdTimeEnd) {
				sql += " and tm.CREATED_TIME <= '" + createdTimeEnd + "'";
			}
		}
		sql += " order by ID desc";
		if (page > 0 && size > 0) {
			sql += " limit " + (page - 1) * size + "," + size;
		}

		List<LeaveMessageInfo> list = ormTemplate.query(sql, new LeaveMessageDtoMapper());
		return list;
	}

	@Override
	public LeaveMessage findById(Long id) {
		Object[] params = new Object[] { id };
		return ormTemplate.queryForObject("select * from T_LEAVE_MESSAGE where ID=?", params, new LeaveMessageMapper());
	}

	@Override
	public List<LeaveMessage> findByStatus(String status) {
		Object[] params = new Object[] { status };
		String sql = "select * from T_LEAVE_MESSAGE where `STATUS` in (?)";
		return ormTemplate.query(sql, params, new LeaveMessageMapper());
	}

}
