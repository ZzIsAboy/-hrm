package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.Employee;

/**
 * 员工接口
 */
public interface EmployeeService extends BaseService<Employee> {

	List<Employee> getAll(Integer jobId, String name, String cardId, Integer sex, String mobile, Integer departmentId);

}
