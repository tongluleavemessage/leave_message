package com.tonglukuaijian.commerce.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
import com.tonglukuaijian.commerce.ServiceException;
import com.tonglukuaijian.commerce.bean.LeaveMessageAssignRecord;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollow;
import com.tonglukuaijian.commerce.bean.LeaveMessageFollowRecord;
import com.tonglukuaijian.commerce.dto.LeaveMessageAssignRecordDto;
import com.tonglukuaijian.commerce.dto.LeaveMessageInfo;
import com.tonglukuaijian.commerce.enums.LeaveMessageStatusEnum;
import com.tonglukuaijian.commerce.out.OutMessage;
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
	public OutMessage<?> addLeaveMessage(@Valid LeaveMessageVo vo) {
		return leaveMessageService.addLeaveMessage(vo);
	}

	@Path("/get")
	@GET
	public OutMessage<?> getByParams(@Context HttpServletRequest request) {
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String principalName = request.getParameter("principalName");
		String principalPhone = request.getParameter("principalPhone");
		String customerName = request.getParameter("customerName");
		Integer status = LeaveMessageStatusEnum.ALL.value();
		if (null != request.getParameter("status")) {
			status = Integer.parseInt(request.getParameter("status"));
		}
		String createdTimeStart = request.getParameter("createdTimeStart");
		String cratedTimeEnd = request.getParameter("createdTimeEnd");
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
		}
		Map<String, Integer> paramMap = GetParams.getPage(request);
		return leaveMessageService.getByParams(loginUserId, projectId, projectName, principalName, principalPhone,
				customerName, status, createdTimeStart, cratedTimeEnd, paramMap.get("page"), paramMap.get("size"));
	}

	@GET
	@Path("/info")
	public OutMessage<?> getLeaveMessageInfo(
			@NotNull(message = "未指定留言") @QueryParam("leaveMessageId") Long leaveMessageId,
			@Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("未登录");
		}

		LeaveMessageInfo info = leaveMessageService.getLeaveMessageInfo(loginUserId, leaveMessageId);
		List<LeaveMessageAssignRecord> assignRecordList = leaveMessageService
				.getLeaveMessageAssignRecord(leaveMessageId);
		List<LeaveMessageFollowRecord> followRecordList = leaveMessageService.getFollowRecord(leaveMessageId, null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("assignRecord", assignRecordList);
		map.put("followRecord", followRecordList);
		return OutMessage.successMessage(map);

	}

	@Path("/get_assign")
	@GET
	public OutMessage<?> getLeaveMessageAssignRecord(@Context HttpServletRequest request) {
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
		return OutMessage.successMessage(list);
	}

	@POST
	@Path("/assign")
	public OutMessage<?> leaveMessageAssign(LeaveMessageAssignVo vo, @Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
		}
		return leaveMessageService.assignLeaveMessage(loginUserId, vo);
	}

	@GET
	@Path("/assign_info")
	public OutMessage<?> leaveMessageAssignLogSearch(
			@NotNull(message = "未指定留言") @QueryParam("leaveMessageAssignId") Long leaveMessageAssignId,
			@Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
		}
		LeaveMessageAssignRecord assignRecord = leaveMessageService
				.getLeaveMessageAssignRecordById(leaveMessageAssignId);

		LeaveMessageInfo info = leaveMessageService.getLeaveMessageInfo(loginUserId, assignRecord.getLeaveMessageId());
		List<LeaveMessageFollowRecord> followRecordList = leaveMessageService.getFollowRecord(
				assignRecord.getLeaveMessageId(), CommonUtils.dateFormat(assignRecord.getCreatedTime()));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", info);
		map.put("followRecord", followRecordList);
		return OutMessage.successMessage(map);
	}

	@POST
	@Path("/follow")
	public OutMessage<?> leaveMessageFollow(@Valid LeaveMessageFollowVo vo, @Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
		}
		return leaveMessageService.followLeaveMessage(loginUserId, vo);
	}

	@Path("/get_follow")
	@GET
	public OutMessage<?> leaveMessageFollowSearch(
			@NotNull(message = "未指定留言") @QueryParam("leaveMessageId") Long leaveMessageId,
			@Context HttpServletRequest request) {
		Long loginUserId = GetParams.getLoginUserId(request);
		if (loginUserId == null) {
			return OutMessage.errorMessage("用户未登录");
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
		return OutMessage.successMessage(map);
	}

	@Path("/test")
	@GET
	public void testConnect() {
		logger.info("链接成功");
		logger.error("测试链接");
	}

}
