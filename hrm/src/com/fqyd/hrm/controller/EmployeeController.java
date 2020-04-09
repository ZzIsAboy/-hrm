package com.fqyd.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.Department;
import com.fqyd.hrm.model.Employee;
import com.fqyd.hrm.model.Job;
import com.fqyd.hrm.model.entity.EmployeeEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 员工控制器
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "employee")
public class EmployeeController extends BaseController {

	/**
	 * 员工列表
	 */
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, Integer job_id, String name, String cardId, Integer sex, String mobile, Integer department_id) {
		ModelAndView view = new ModelAndView();
		// 查询职位信息，用于模糊查询
		List<Job> jobs = jobService.getAll();
		// 查询部门信息 ，用于模糊查询
		List<Department> departments = departmentService.getAll();
		// 查询员工信息
		PageHelper.startPage(page, 10);
		List<Employee> employees = employeeService.getAll(job_id, name, cardId, sex, mobile, department_id);
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);
		List<EmployeeEntity> list = new ArrayList<>();
		for (Employee employee : pageInfo.getList()) {
			Department department = departmentService.getById(employee.getDepartmentId());
			if (department == null) {
				department = new Department();
				department.setName(String.valueOf(employee.getDepartmentId()));
			}
			Job job = jobService.getById(employee.getJobId());
			if (job == null) {
				job = new Job();
				job.setName(String.valueOf(employee.getJobId()));
			}
			list.add(EmployeeEntity.newEmployeeEntity(employee, department, job));
		}
		// 设置Model数据
		view.addObject("jobs", jobs);
		view.addObject("departments", departments);
		view.addObject("pages", pageInfo);
		view.addObject("employees", list);
		view.addObject("job_id", job_id);
		view.addObject("name", name);
		view.addObject("cardId", cardId);
		view.addObject("sex", sex);
		view.addObject("mobile", mobile);
		view.addObject("department_id", department_id);
		view.setViewName("employee/employee");
		// 返回员工页面
		return view;
	}

	/**
	 * 添加员工
	 */
	@RequestMapping(value = "add")
	public ModelAndView addEmployee(String flag, Integer department_id, Integer job_id, String name, String cardId, String address, String postCode, String telephone, String mobile, String qq, String email, Integer sex, String party, String birthday, String race, String education, String speciality,
			String hobby, String remark) throws ParseException {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 查询职位信息，用于模糊查询
			List<Job> jobs = jobService.getAll();
			// 查询部门信息 ，用于模糊查询
			List<Department> departments = departmentService.getAll();
			// 设置Model数据
			view.addObject("jobs", jobs);
			view.addObject("departments", departments);
			// 返回添加员工页面
			view.setViewName("employee/employee_add");
		} else if (flag.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 判断是否有关联对象传递，如果有，创建关联对象
			Employee employee = new Employee();
			employee.setDepartmentId(department_id);
			employee.setJobId(job_id);
			employee.setName(name);
			employee.setCardId(cardId);
			employee.setAddress(address);
			employee.setPostCode(postCode);
			employee.setTelephone(telephone);
			employee.setMobile(mobile);
			employee.setQq(qq);
			employee.setEmail(email);
			employee.setSex(sex);
			employee.setParty(party);
			employee.setBirthday(sdf.parse(birthday));
			employee.setRace(race);
			employee.setEducation(education);
			employee.setSpeciality(speciality);
			employee.setHobby(hobby);
			employee.setRemark(remark);
			employee.setCreateTime(new Date());
			// 添加操作
			employeeService.add(employee);

			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 修改员工
	 */
	@RequestMapping(value = "modify")
	public ModelAndView updateEmployee(String flag, Integer id, Integer department_id, Integer job_id, String name, String cardId, String address, String postCode, String telephone, String mobile, String qq, String email, Integer sex, String party, String birthday, String race, String education,
			String speciality, String hobby, String remark) throws ParseException {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 根据id查询员工
			Employee employee = employeeService.getById(id);
			// 查询职位信息，用于模糊查询
			List<Job> jobs = jobService.getAll();
			// 查询部门信息 ，用于模糊查询
			List<Department> departments = departmentService.getAll();
			// 设置Model数据
			view.addObject("jobs", jobs);
			view.addObject("departments", departments);
			view.addObject("employee", employee);
			// 返回修改员工页面
			view.setViewName("employee/employee_modify");
		} else if (flag.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 创建并封装关联对象
			Employee employee = employeeService.getById(id);
			employee.setDepartmentId(department_id);
			employee.setJobId(job_id);
			employee.setName(name);
			employee.setCardId(cardId);
			employee.setAddress(address);
			employee.setPostCode(postCode);
			employee.setTelephone(telephone);
			employee.setMobile(mobile);
			employee.setQq(qq);
			employee.setEmail(email);
			employee.setSex(sex);
			employee.setParty(party);
			employee.setBirthday(sdf.parse(birthday));
			employee.setRace(race);
			employee.setEducation(education);
			employee.setSpeciality(speciality);
			employee.setHobby(hobby);
			employee.setRemark(remark);
			// 执行修改操作
			employeeService.update(employee);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 删除员工
	 */
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除员工
			employeeService.delete(Integer.valueOf(id));
		}
		// 设置客户端跳转到查询请求
		view.setViewName("redirect:list.do");
		// 返回ModelAndView
		return view;
	}
}
