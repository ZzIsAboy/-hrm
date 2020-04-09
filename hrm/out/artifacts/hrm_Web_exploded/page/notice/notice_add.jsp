<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——添加公告</title>
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/css/css.css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/ligerUI/skins/Aqua/css/ligerui-dialog.css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/ligerUI/skins/ligerui-icons.css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/css/pager.css" />
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerDrag.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerDialog.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerResizable.js"></script>
<script type="text/javascript">
	$(function() {
		/** 表单提交的校验 */
		$("#noticeForm").submit(function() {
			var title = $("#title");
			var content = $("#content");
			var msg = "";
			if ($.trim(title.val()) == "") {
				msg = "公告标题不能为空！";
				title.focus();
			} else if ($.trim(title.val()).length <= 2) {
				msg = "请输入两个字符以上的标题！";
				title.focus();
			} else if ($.trim(content.val()) == "") {
				msg = "公告内容不能为空！";
				content.focus();
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return false;
			} else {
				return true;
			}
			$("#noticeForm").submit();
		});
	});
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="${pagePath}/page/static/images/pointer.gif">&nbsp;当前位置：公告管理&nbsp;&gt;&nbsp;添加公告</td>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>
	<!-- 请求异常错误  -->
	<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form id="noticeForm" name="noticeForm" action="${pagePath}/notice/add.do" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2">
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">公告标题：<input type="text" name="title" size="30" id="title" /> <span style="color: #ff0000;"></span>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td class="font3 fftd">公告内容：<br /> <textarea name="content" cols="88" rows="11" id="content"></textarea>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td class="font3 fftd"><input type="submit" value="添加"> <input type="reset" value="重置"></td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
</html>