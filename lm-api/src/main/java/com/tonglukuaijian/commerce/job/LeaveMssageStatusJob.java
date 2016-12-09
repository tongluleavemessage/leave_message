package com.tonglukuaijian.commerce.job;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.service.LeaveMessageService;

public class LeaveMssageStatusJob {
	Logger logger = LoggerFactory.getLogger("LeaveMssageStatusJob	");

	@Autowired
	private LeaveMessageService leaveMessageService;

	public void execute() {
		logger.info("-----------开始执行 留言状态修改------------");
		leaveMessageService.leaveMessageJob(new Date());
		logger.info("-----------留言状态 执行完毕------------");
	}
}
