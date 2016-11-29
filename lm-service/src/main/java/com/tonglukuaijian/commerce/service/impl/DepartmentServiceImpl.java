package com.tonglukuaijian.commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonglukuaijian.commerce.bean.Department;
import com.tonglukuaijian.commerce.dao.DepartmentDao;
import com.tonglukuaijian.commerce.exception.ServiceException;
import com.tonglukuaijian.commerce.service.DepartmentService;
import com.tonglukuaijian.commerce.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public void add(DepartmentVo vo) {
		if (null == vo.getName()) {
			throw new ServiceException("参数有误");
		}
		Department department = wrapDepartment(vo);
		departmentDao.save(department);
	}

	@Override
	public void update(DepartmentVo vo) {
		if (null == vo.getId()) {
			throw new ServiceException("未指定部门");
		}
		Department department = wrapDepartment(vo);
		departmentDao.update(department);
	}

	private Department wrapDepartment(DepartmentVo vo) {
		Department department = new Department();
		department.setCreatedTime(new Date());
		department.setId(vo.getId());
		department.setStatus(vo.getStatus());
		department.setName(vo.getName());
		return department;
	}

	@Override
	public List<Department> getAll() {
		return departmentDao.findAll();
	}

}
