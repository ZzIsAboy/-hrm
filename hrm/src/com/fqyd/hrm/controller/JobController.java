package com.fqyd.hrm.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.Job;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 职位请求控制器
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "job")
public class JobController extends BaseController {

	/**
	 * 职位列表
	 */
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, String name) {
		ModelAndView view = new ModelAndView();
		PageHelper.startPage(page, 10);
		List<Job> jobs = jobService.getAll(name);
		PageInfo<Job> pageInfo = new PageInfo<Job>(jobs);
		view.addObject("pages", pageInfo);
		view.addObject("name", name);
		view.setViewName("job/job");
		return view;
	}

	/**
	 * 添加职位
	 */
	@RequestMapping(value = "add")
	public ModelAndView add(String flag, String name, String remark) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 设置跳转到添加页面
			view.setViewName("job/job_add");
		} else if (flag.equals("2")) {
			Job job = new Job();
			job.setName(name);
			job.setRemark(remark);
			// 执行添加操作
			jobService.add(job);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 修改职位
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(String flag, Integer id, String name, String remark) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 根据id查询部门
			Job job = jobService.getById(id);
			// 设置Model数据
			view.addObject("job", job);
			// 设置跳转到修改页面
			view.setViewName("job/job_modify");
		} else if (flag.equals("2")) {
			Job job = jobService.getById(id);
			job.setName(name);
			job.setRemark(remark);
			// 执行修改操作
			jobService.update(job);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	* 删除职位
	*/
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除职位
			jobService.delete(Integer.valueOf(id));
		}
		// 设置客户端跳转到查询请求
		view.setViewName("redirect:list.do");
		// 返回ModelAndView
		return view;
	}
}
