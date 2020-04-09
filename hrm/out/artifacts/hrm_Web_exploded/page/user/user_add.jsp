<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——添加用户</title>
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
		/** 员工表单提交 */
		$("#userForm").submit(function() {
			var username = $("#username");
			var password = $("#password");
			var realname = $("#realname");
			var status = $("#status");
			var msg = "";
			if ($.trim(username.val()) == "") {
				msg = "用户名不能为空！";
				username.focus();
			} else if ($.trim(password.val()) == "") {
				msg = "密码不能为空！";
				password.focus();
			} else if ($.trim(realname.val()) == "") {
				msg = "姓名不能为空！";
				realname.focus();
			} else if ($.trim(status.val()) == "") {
				msg = "请选择状态！";
				status.focus();
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return false;
			} else {
				return true;
			}
			$("#userForm").submit();
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
			<td class="main_locbg font2"><img src="${pagePath}/page/static/images/pointer.gif">&nbsp;当前位置：用户管理&nbsp;&gt;&nbsp;添加用户</td>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form action="${pagePath}/user/add.do" id="userForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2">
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">
								<table>
									<tr>
										<td class="font3 fftd">用户名：<input name="username" id="username" value="${user.username}" size="20" /></td>
									</tr>
									<tr>
										<td class="font3 fftd">密&nbsp;码：<input name="password" id="password" value="${user.password}" size="20" /></td>
									</tr>
									<tr>
										<td class="font3 fftd">姓&nbsp;名：<input type="text" name="realname" id="realname" value="${user.realname}" size="20" /></td>
									</tr>
									<tr>
										<td class="font3 fftd">状&nbsp;态：<select id="status" name="status" style="width: 173px;">
												<option value="">--请选择--</option>
												<option value="1">已审核</option>
												<option value="2">未审核</option>
										</select></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td align="left" class="fftd"><input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
</body>
</html>