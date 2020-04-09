package com.fqyd.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.Notice;
import com.fqyd.hrm.model.User;
import com.fqyd.hrm.model.entity.NoticeEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@Scope(value = "prototype")
@RequestMapping(value = "notice")
public class NoticeController extends BaseController {

	
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, String title, String content) {
		ModelAndView view = new ModelAndView();
		PageHelper.startPage(page, 10);
		List<Notice> notices = noticeService.getAll(title, content);
		PageInfo<Notice> pageInfo = new PageInfo<Notice>(notices);
		List<NoticeEntity> list = new ArrayList<>();
		for (Notice notice : pageInfo.getList()) {
			User user = userService.getById(notice.getUserId());
			if (user == null) {
				user = new User();
				user.setUsername(String.valueOf(notice.getUserId()));
			}
			list.add(NoticeEntity.newNoticeEntity(notice, user));
		}
		view.addObject("pages", pageInfo);
		view.addObject("notices", list);
		view.addObject("title", title);
		view.addObject("content", content);
		view.setViewName("notice/notice");
		return view;
	}

	@RequestMapping(value = "preview")
	public ModelAndView preview(Integer id) {
		ModelAndView view = new ModelAndView();
		Notice notice = noticeService.getById(id);
		view.addObject("notice", notice);
		view.setViewName("notice/notice_preview");
		return view;
	}


	@RequestMapping(value = "add")
	public ModelAndView add(String flag, String title, String content, HttpSession session) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			view.setViewName("notice/notice_add");
		} else if (flag.equals("2")) {
			Notice notice = new Notice();
			User user = (User) session.getAttribute("loguser");
			notice.setUserId(user.getId());
			notice.setTitle(title);
			notice.setContent(content);
			notice.setCreateTime(new Date());
			noticeService.add(notice);
			view.setViewName("redirect:list.do");
		}
		
		return view;
	}


	@RequestMapping(value = "modify")
	public ModelAndView modify(String flag, Integer id, String title, String content, HttpSession session) {
		ModelAndView view = new ModelAndView();
		if (flag.equals("1")) {
			Notice target = noticeService.getById(id);
			view.addObject("notice", target);
			view.setViewName("notice/notice_modify");
		} else if (flag.equals("2")) {
			Notice notice = noticeService.getById(id);
			notice.setTitle(title);
			notice.setContent(content);
			noticeService.update(notice);
			view.setViewName("redirect:list.do");
		}
	
		return view;
	}

	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();

		String[] idArray = ids.split(",");
		for (String id : idArray) {
			
			noticeService.delete(Integer.valueOf(id));
		}
	
		view.setViewName("redirect:list.do");
	
		return view;
	}
}
