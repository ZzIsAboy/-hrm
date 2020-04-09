package com.fqyd.hrm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.User;
import com.fqyd.hrm.utils.Tools;

@Controller
@Scope(value = "prototype")
public class LoginController extends BaseController {

	@RequestMapping("login")
	public ModelAndView login( String username,  String password, ModelAndView view, HttpSession session) {
		if (Tools.isEmpty(username)) {
			view.setViewName("login");
			return view;
		}
		User user = userService.login(username, password);
		if (user == null) {
			view.addObject("username", username);
			view.addObject("message", "请输入账户与密码");
			view.setViewName("login");
			return view;
		}
		session.setAttribute("loguser", user);
		view.setViewName("redirect:index.do");
		return view;
	}

	@RequestMapping("logout")
	public ModelAndView logout(ModelAndView view, HttpSession session) {
		session.removeAttribute("loguser");
		view.addObject("message", "请输入账户与密码");
		view.setViewName("login");
		return view;
	}
}
