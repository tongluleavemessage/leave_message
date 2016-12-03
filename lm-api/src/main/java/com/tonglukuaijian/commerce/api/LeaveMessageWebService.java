package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tonglukuaijian.commerce.GetParams;
import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;
import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;
import com.tonglukuaijian.commerce.enums.LeaveMessageStatusEnum;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.LeaveMessageService;
import com.tonglukuaijian.commerce.util.CommonUtils;
import com.tonglukuaijian.commerce.vo.LeaveMessageAssignVo;
import com.tonglukuaijian.commerce.vo.LeaveMessageFollowVo;
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

	@Path("/get")
	@GET
	public Map<String, Object> getByParams(@Context HttpServletRequest request) {
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String principalName = request.getParameter("principalName");
		String principalPhone = request.getParameter("principalPhone");
		String customerName = request.getParameter("customerName");
		Integer status = Integer.parseInt(request.getParameter("status"));
		String createdTimeStart = request.getParameter("createdTimeStart");
		String cratedTimeEnd = request.getParameter("createdTimeEnd");
		Long loginUserId = null;
		if (null != request.getAttribute("userId")) {
			loginUserId = (Long) request.getAttribute("userId");
		}
		Map<String, Integer> paramMap = GetParams.getPage(request);
		List<LeaveMessageInfo> list = leaveMessageService.getByParams(loginUserId, projectId, projectName,
				principalName, principalPhone, customerName, status, createdTimeStart, cratedTimeEnd,
				paramMap.get("page"), paramMap.get("size"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return map;
	}

	@GET
	@Path("/info")
	public Map<String, Object> getLeaveMessageInfo(@QueryParam("leaveMesageId") Long leaveMessageId,
			@Context HttpSession session) {
		if (leaveMessageId == null) {
			throw new ServiceException("未指定留言");
		}
		if (null == session.getAttribute("userId")) {
			throw new ServiceException("未登录");
		}
		Long loginUserId = (Long) session.getAttribute("userId");
		LeaveMessageInfo info = leaveMessageService.getLeaveMessageInfo(loginUserId, leaveMessageId);
		List<LeaveMessageAssignRecord> assignRecordList = leaveMessageService
				.getLeaveMessageAssignRecord(leaveMessageId);
		List<LeaveMessageFollowRecord> followRecordList = leaveMessageService.getFollowRecord(leaveMessageId, null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("assignRecord", assignRecordList);
		map.put("followRecord", followRecordList);
		return map;

	}

	@Path("/get_assign")
	@GET
	public Map<String, Object> getLeaveMessageAssignRecord(@Context HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String projectPrincipal = request.getParameter("projectPrincipal");
		String principalPhone = request.getParameter("principalPhone");
		String customerName = request.getParameter("customerName");
		Integer status = LeaveMessageStatusEnum.ALL.value();
		if (null != request.getParameter("status")) {
			status = Integer.parseInt(request.getParameter("status"));
		}
		String createdTimeStart = request.getParameter("createdTimeStart");
		String createdTimeEnd = request.getParameter("createdTimeEnd");
		Map<String, Integer> pageMap = GetParams.getPage(request);
		List<LeaveMessageAssignRecordDto> list = leaveMessageService.getLeaveMessageAssignRecordByParams(projectId,
				projectName, projectPrincipal, principalPhone, customerName, status, createdTimeStart, createdTimeEnd,
				pageMap.get("page"), pageMap.get("size"));
		map.put("data", list);
		return map;
	}

	@POST
	@Path("/assign")
	public Map<String, Object> leaveMessageAssign(LeaveMessageAssignVo vo, @Context HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (null == session.getAttribute("userId")) {
			throw new ServiceException("未登录");
		}
		Long loginUserId = (Long) session.getAttribute("userId");
		leaveMessageService.assignLeaveMessage(loginUserId, vo);
		map.put("message", "ok");
		return map;
	}

	@GET
	@Path("/assign_info")
	public Map<String, Object> leaveMessageAssignLogSearch(
			@QueryParam("leaveMessageAssignId") Long leaveMessageAssignId, @Context HttpSession session) {
		if (leaveMessageAssignId == null) {
			throw new ServiceException("未指定留言");
		}
		if (null == session.getAttribute("userId")) {
			throw new ServiceException("未登录");
		}
		Long loginUserId = (Long) session.getAttribute("userId");
		LeaveMessageAssignRecord assignRecord = leaveMessageService
				.getLeaveMessageAssignRecordById(leaveMessageAssignId);

		LeaveMessageInfo info = leaveMessageService.getLeaveMessageInfo(loginUserId, assignRecord.getLeaveMessageId());
		List<LeaveMessageFollowRecord> followRecordList = leaveMessageService.getFollowRecord(
				assignRecord.getLeaveMessageId(), CommonUtils.dateFormat(assignRecord.getCreatedTime()));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("followRecord", followRecordList);
		return map;
	}

	@POST
	@Path("/follow")
	public Map<String, Object> leaveMessageFollow(LeaveMessageFollowVo vo) {
		leaveMessageService.followLeaveMessage(vo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "ok");
		return map;
	}

	@Path("/get_follow")
	@GET
	public Map<String, Object> leaveMessageFollowSearch(@QueryParam("leaveMessageId") Long leaveMessageId,
			@Context HttpSession session) {
		if (session.getAttribute("userId") == null) {
			throw new ServiceException("未登录");
		}
		Long loginUserId = (Long) session.getAttribute("userId");
		if (leaveMessageId == null) {
			throw new ServiceException("未指定留言");
		}

		LeaveMessageInfo info = leaveMessageService.getLeaveMessageInfo(loginUserId, leaveMessageId);
		List<LeaveMessageAssignRecord> assignRecordList = leaveMessageService
				.getLeaveMessageAssignRecord(leaveMessageId);
		LeaveMessageFollow follow = leaveMessageService.getLeaveMessageFollowByLeaveMessageId(loginUserId,
				leaveMessageId);
		List<LeaveMessageFollowRecord> followRecordList = leaveMessageService.getFollowRecord(leaveMessageId, null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("assignRecord", assignRecordList);
		map.put("follow", follow);
		map.put("followRecord", followRecordList);
		return map;
	}

	@Path("/test")
	@GET
	public void testConnect() {
		logger.info("链接成功");
		logger.error("测试链接");
	}

}
