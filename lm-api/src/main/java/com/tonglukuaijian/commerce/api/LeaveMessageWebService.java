package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.service.LeaveMessageService;
import com.tonglukuaijian.commerce.vo.LeaveMessageVo;

@Produces(MediaType.APPLICATION_JSON)
@Path("/leave_message")
public class LeaveMessageWebService {
	Logger logger = LoggerFactory.getLogger(LeaveMessageWebService.class);

	@Autowired
	private LeaveMessageService leaveMessageService;

	@Path("/add")
	@POST
	public Map<String, Object> addLeaveMessage(@Valid LeaveMessageVo vo) {
		leaveMessageService.addLeaveMessage(vo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "ok");
		return map;
	}

	@Path("/test")
	@GET
	public void testConnect() {
		logger.info("链接成功");
		logger.error("测试链接");
	}

}
