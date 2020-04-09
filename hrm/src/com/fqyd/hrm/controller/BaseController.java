package com.fqyd.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fqyd.hrm.service.DepartmentService;
import com.fqyd.hrm.service.DocumentService;
import com.fqyd.hrm.service.EmployeeService;
import com.fqyd.hrm.service.JobService;
import com.fqyd.hrm.service.NoticeService;
import com.fqyd.hrm.service.UserService;

/**
 * 公用控制器
 */
@Controller
@Scope(value = "prototype")
public class BaseController {

	@Autowired
	protected DepartmentService departmentService;
	@Autowired
	protected DocumentService documentService;
	@Autowired
	protected EmployeeService employeeService;
	@Autowired
	protected JobService jobService;
	@Autowired
	protected NoticeService noticeService;
	@Autowired
	protected UserService userService;

}
