package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.EmployeeMapper;
import com.fqyd.hrm.model.Employee;
import com.fqyd.hrm.model.EmployeeExample;
import com.fqyd.hrm.service.EmployeeService;
import com.fqyd.hrm.utils.Tools;

/**
 * 员工接口实现
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeMapper mapper;

	@Override
	public List<Employee> getAll() {
		return mapper.selectByExample(new EmployeeExample());
	}

	@Override
	public void add(Employee employee) {
		mapper.insert(employee);
	}

	@Override
	public void update(Employee employee) {
		mapper.updateByPrimaryKey(employee);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Employee getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> getAll(Integer jobId, String name, String cardId, Integer sex, String mobile, Integer departmentId) {
		EmployeeExample example = new EmployeeExample();
		EmployeeExample.Criteria criteria = example.createCriteria();
		if (jobId != null) {
			criteria.andJobIdEqualTo(jobId);
		}
		if (Tools.isNotEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (Tools.isNotEmpty(cardId)) {
			criteria.andCardIdLike("%" + cardId + "%");
		}
		if (sex != null) {
			criteria.andSexEqualTo(sex);
		}
		if (Tools.isNotEmpty(mobile)) {
			criteria.andMobileLike("%" + mobile + "%");
		}
		if (departmentId != null) {
			criteria.andDepartmentIdEqualTo(departmentId);
		}
		return mapper.selectByExample(example);
	}
}
