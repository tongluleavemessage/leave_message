package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Department;
import com.tonglukuaijian.commerce.dao.DepartmentDao;
import com.tonglukuaijian.commerce.out.OutMessage;
import com.tonglukuaijian.commerce.service.DepartmentService;
import com.tonglukuaijian.commerce.vo.DepartmentVo;
import com.tonglukuaijian.commerce.vo.UpdateDepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public OutMessage<?> add(DepartmentVo vo) {
		Department department = wrapDepartment(vo);
		departmentDao.save(department);
		return OutMessage.successMessage();
	}

	@Override
	public OutMessage<?> update(UpdateDepartmentVo vo) {
		Department department = departmentDao.findById(vo.getDepartmentId());
		if (department == null) {
			return OutMessage.errorMessage("该部门不存在");
		}
		if (vo.getName() != null) {
			department.setName(vo.getName());
		}
		if (vo.getStatus() != null) {
			department.setStatus(vo.getStatus());
		}
		departmentDao.update(department);
		return OutMessage.successMessage();
	}

	private Department wrapDepartment(DepartmentVo vo) {
		Department department = new Department();
		department.setCreatedTime(new Date());
		department.setStatus(vo.getStatus());
		department.setName(vo.getName());
		return department;
	}

	@Override
	public OutMessage<?> getAll(int page, int size) {
		List<Department> list= departmentDao.findAll(page, size);
		return OutMessage.successMessage(list);
	}

}
