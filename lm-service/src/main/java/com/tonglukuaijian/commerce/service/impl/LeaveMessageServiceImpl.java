package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.dao.LeaveMessageDao;
import com.tonglukuaijian.commerce.enums.LeaveMessageStatusEnum;
import com.tonglukuaijian.commerce.service.LeaveMessageService;
import com.tonglukuaijian.commerce.vo.LeaveMessageVo;

@Service(value = "leaveMessageService")
public class LeaveMessageServiceImpl implements LeaveMessageService {
	Logger logger = LoggerFactory.getLogger(LeaveMessageServiceImpl.class);
	@Autowired
	private LeaveMessageDao leaveMessageDao;

	@Override
	public void addLeaveMessage(LeaveMessageVo vo) {
		LeaveMessage leaveMessage = new LeaveMessage();
		leaveMessage.setStatus(LeaveMessageStatusEnum.NORMAL.value());
		leaveMessage.setProjectId(vo.getProjectId());
		leaveMessage.setProjectName(vo.getProjectName());
		leaveMessage.setName(vo.getName());
		leaveMessage.setContent(vo.getContent());
		leaveMessage.setPhoneNum(vo.getPhoneNum());
		leaveMessage.setCreatedTime(new Date());
		leaveMessageDao.saveLeaveMesage(leaveMessage);
	}

}
