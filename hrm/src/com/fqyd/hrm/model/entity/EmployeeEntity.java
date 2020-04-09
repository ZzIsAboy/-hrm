package com.fqyd.hrm.model.entity;

import com.fqyd.hrm.model.Department;
import com.fqyd.hrm.model.Employee;
import com.fqyd.hrm.model.Job;

/**
 * 员工Entity
 */
public class EmployeeEntity {

	/**
	 * 员工
	 */
	private Employee employee;

	/**
	 * 部门
	 */
	private Department department;

	/**
	 * 职位
	 */
	private Job job;

	public static EmployeeEntity newEmployeeEntity(Employee employee, Department department, Job job) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmployee(employee);
		entity.setDepartment(department);
		entity.setJob(job);
		return entity;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
