package com.tonglukuaijian.commerce.assembler;

import org.springframework.util.Base64Utils;

import com.tonglukuaijian.commerce.bean.LeaveMessage;
import com.tonglukuaijian.commerce.bean.User;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;

public class LeaveMessageAssembler {
	public static LeaveMessageInfo wrapLeaveMessageToLeaveMessageDto(LeaveMessage leaveMessage, User projectPrincipalUser,
			Boolean decode) {
		LeaveMessageInfo dto = new LeaveMessageInfo();
		dto.setContent(leaveMessage.getContent());
		dto.setCreatedTime(leaveMessage.getCreatedTime());
		dto.setCustomerName(leaveMessage.getName());
		if (decode) {
			dto.setCustomerPhone(new String(Base64Utils.decodeFromString(leaveMessage.getPhoneNum())));
		} else {
			dto.setCustomerPhone(leaveMessage.getPhoneNum());
		}
		dto.setId(leaveMessage.getId());
		if (projectPrincipalUser != null) {
			dto.setProjectPrincipalUserName(projectPrincipalUser.getName());
			dto.setPrincipalPhoneNum(projectPrincipalUser.getPhoneNum());
		}
		dto.setProjectId(leaveMessage.getProjectId());
		dto.setProjectName(leaveMessage.getProjectName());
		dto.setStatus(leaveMessage.getStatus());
		return dto;
	}

}
