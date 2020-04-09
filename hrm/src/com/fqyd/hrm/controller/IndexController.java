package com.fqyd.hrm.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面控制
 */
@Controller
@Scope(value = "prototype")
public class IndexController extends BaseController {

	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("main");
		return view;
	}

	@RequestMapping(value = "/top")
	public ModelAndView top(ModelAndView view) {
		view.setViewName("top");
		return view;
	}

	@RequestMapping(value = "/left")
	public ModelAndView left(ModelAndView view) {
		view.setViewName("left");
		return view;
	}

	@RequestMapping(value = "/right")
	public ModelAndView right(ModelAndView view) {
		view.setViewName("right");
		return view;
	}
//
//	@RequestMapping(value = "/{viewName}")
//	public ModelAndView view(@PathVariable String viewName, ModelAndView view) {
//		// 动态跳转页面
//		view.setViewName(viewName);
//		return view;
//	}
}
