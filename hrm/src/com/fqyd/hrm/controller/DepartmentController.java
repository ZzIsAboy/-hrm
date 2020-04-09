package com.fqyd.hrm.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.Department;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门控制器
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "department")
public class DepartmentController extends BaseController {

	/**
	 * 部门列表
	 */
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, String name) {
		ModelAndView view = new ModelAndView();
		PageHelper.startPage(page, 10);
		List<Department> departments = departmentService.getAll(name);
		PageInfo<Department> pageInfo = new PageInfo<Department>(departments);
		view.addObject("pages", pageInfo);
		view.addObject("name", name);
		view.setViewName("department/department");
		return view;
	}

	/**
	* 添加部门
	*/
	@RequestMapping(value = "add")
	public ModelAndView add(String flag, String name, String remark) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 设置跳转到添加页面
			view.setViewName("department/department_add");
		} else if (flag.equals("2")) {
			// 执行添加操作
			Department department = new Department();
			department.setName(name);
			department.setRemark(remark);
			departmentService.add(department);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 修改部门
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(String flag, Integer id, String name, String remark) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 根据id查询部门
			Department department = departmentService.getById(id);
			// 设置Model数据
			view.addObject("department", department);
			// 设置跳转到修改页面
			view.setViewName("department/department_modify");
		} else if (flag.equals("2")) {
			Department department = departmentService.getById(id);
			// 执行修改操作
			department.setName(name);
			department.setRemark(remark);
			departmentService.update(department);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 删除部门
	 */
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除部门
			departmentService.delete(Integer.valueOf(id));
		}
		// 设置客户端跳转到查询请求
		view.setViewName("redirect:list.do");
		// 返回ModelAndView
		return view;
	}
}
