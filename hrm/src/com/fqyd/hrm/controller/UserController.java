package com.fqyd.hrm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户控制器
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "user")
public class UserController extends BaseController {

	/**
	 * 用户列表
	 */
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(defaultValue = "1") Integer page, String key, Integer status) {
		ModelAndView view = new ModelAndView();
		PageHelper.startPage(page, 10);
		List<User> users = userService.getAll(key, status);
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		view.addObject("pages", pageInfo);
		view.addObject("key", key);
		view.addObject("status", status);
		view.setViewName("user/user");
		return view;
	}

	/**
	 * 添加用户
	 */
	@RequestMapping(value = "add")
	public ModelAndView add(String flag, String username, String password, String realname, Integer status) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 设置跳转到添加页面
			view.setViewName("user/user_add");
		} else if (flag.equals("2")) {
			// 执行添加操作
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRealname(realname);
			user.setStatus(status);
			user.setCreateTime(new Date());
			userService.add(user);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 修改用户
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(String flag, Integer id, String realname, Integer status) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			// 根据id查询用户
			User user = userService.getById(id);
			// 设置Model数据
			view.addObject("user", user);
			// 返回修改员工页面
			view.setViewName("user/user_modify");
		} else if (flag.equals("2")) {
			// 执行修改操作
			User user = userService.getById(id);
			user.setRealname(realname);
			user.setStatus(status);
			userService.update(user);
			// 设置客户端跳转到查询请求
			view.setViewName("redirect:list.do");
		}
		// 返回
		return view;
	}

	/**
	 * 删除用户
	 */
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除员工
			userService.delete(Integer.valueOf(id));
		}
		// 设置客户端跳转到查询请求
		view.setViewName("redirect:list.do");
		// 返回ModelAndView
		return view;
	}
}
