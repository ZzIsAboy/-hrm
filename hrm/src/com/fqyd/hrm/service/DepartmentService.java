package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.Department;

/**
 * 部门接口
 */
public interface DepartmentService extends BaseService<Department> {

	List<Department> getAll(String name);

}
