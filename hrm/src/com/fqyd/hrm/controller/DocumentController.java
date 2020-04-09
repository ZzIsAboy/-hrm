package com.fqyd.hrm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fqyd.hrm.model.Document;
import com.fqyd.hrm.model.User;
import com.fqyd.hrm.model.entity.DocumentEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 文档控制器
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "document")
public class DocumentController extends BaseController {

	/**
	 * 文档列表
	 */
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, String title) {
		ModelAndView view = new ModelAndView();
		PageHelper.startPage(page, 10);
		List<Document> documents = documentService.getAll(title);
		PageInfo<Document> pageInfo = new PageInfo<Document>(documents);
		List<DocumentEntity> list = new ArrayList<>();
		for (Document document : pageInfo.getList()) {
			User user = userService.getById(document.getUserId());
			if (user == null) {
				user = new User();
				user.setUsername(String.valueOf(document.getUserId()));
			}
			list.add(DocumentEntity.newDocumentEntity(document, user));
		}
		view.addObject("pages", pageInfo);
		view.addObject("documents", list);
		view.addObject("title", title);
		view.setViewName("document/document");
		return view;
	}

	/**
	 * 新增
	 */
	@RequestMapping(value = "add")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView();
		view.setViewName("document/document_add");
		// 返回
		return view;
	}

	/**
	 * 新增
	 */
	@RequestMapping(value = "add_save")
	public ModelAndView addSave(HttpServletRequest request, HttpSession session) {
		ModelAndView view = new ModelAndView();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) (request);
		String title = multipartRequest.getParameter("title");
		String remark = multipartRequest.getParameter("remark");
		MultipartFile file = multipartRequest.getFile("file");
		Document document = new Document();
		// 设置关联的User对象
		User user = (User) session.getAttribute("loguser");
		document.setUserId(user.getId());
		document.setTitle(title);
		document.setRemark(remark);
		document.setCreateTime(new Date());
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/") + "page/static/upload";
			// 上传文件名
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			File destFile = new File(path, fileName);
			try {
				// 将上传文件保存到一个目标文件当中
				file.transferTo(destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			document.setFileName(fileName);
			// 插入数据库
			documentService.add(document);
		}
		// 返回
		view.setViewName("redirect:list.do");
		return view;
	}

	/**
	 * 修改文档
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(Integer id) {
		ModelAndView view = new ModelAndView();
		// 根据id查询文档
		Document document = documentService.getById(id);
		// 设置Model数据
		view.addObject("document", document);
		// 设置跳转到修改页面
		view.setViewName("document/document_modify");
		return view;
	}

	/**
	 * 修改文档
	 */
	@RequestMapping(value = "modify_save")
	public ModelAndView modifySave(HttpServletRequest request, HttpSession session) {
		ModelAndView view = new ModelAndView();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) (request);
		String id = multipartRequest.getParameter("id");
		String title = multipartRequest.getParameter("title");
		String remark = multipartRequest.getParameter("remark");
		MultipartFile file = multipartRequest.getFile("file");
		Document document = documentService.getById(Integer.valueOf(id));
		document.setTitle(title);
		document.setRemark(remark);
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/") + "page/static/upload";
			// 上传文件名
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			File destFile = new File(path, fileName);
			try {
				// 将上传文件保存到一个目标文件当中
				file.transferTo(destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			document.setFileName(fileName);
		}
		// 插入数据库
		documentService.update(document);
		// 返回
		view.setViewName("redirect:list.do");
		return view;
	}

	/**
	 * 删除文档
	 */
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids) {
		ModelAndView view = new ModelAndView();
		// 分解id字符串
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除文档
			documentService.delete(Integer.valueOf(id));
		}
		// 设置客户端跳转到查询请求
		view.setViewName("redirect:list.do");
		// 返回ModelAndView
		return view;
	}

	/**
	 * 文档下载
	 */
	@RequestMapping(value = "download")
	public ResponseEntity<byte[]> download(Integer id, HttpSession session) throws Exception {
		// 根据id查询文档
		Document document = documentService.getById(id);
		String fileName = document.getFileName();
		// 上传文件路径
		String path = session.getServletContext().getRealPath("/page/static/upload/");
		// 获得要下载文件的File对象
		File file = new File(path + File.separator + fileName);
		// 创建SpringFramework的HttpHeaders对象
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
