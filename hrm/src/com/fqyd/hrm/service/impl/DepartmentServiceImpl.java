package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.DepartmentMapper;
import com.fqyd.hrm.model.Department;
import com.fqyd.hrm.model.DepartmentExample;
import com.fqyd.hrm.service.DepartmentService;
import com.fqyd.hrm.utils.Tools;

/**
 * 部门接口实现
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentMapper mapper;

	@Override
	public List<Department> getAll() {
		return mapper.selectByExample(new DepartmentExample());
	}

	@Override
	public void add(Department department) {
		mapper.insert(department);
	}

	@Override
	public void update(Department department) {
		mapper.updateByPrimaryKey(department);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Department getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> getAll(String name) {
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		if (Tools.isNotEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		return mapper.selectByExample(example);
	}
}
