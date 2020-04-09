<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——后台管理</title>
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/css/css.css" />
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		/** 给左侧功能菜单绑定点击事件  */
		$("td[id^='navbg']").click(function() {
			/** 获取一级菜单的id */
			var navbgId = this.id;
			/** 获取对应的二级菜单id */
			var submenuId = navbgId.replace('navbg', 'submenu');
			/** 控制二级菜单显示或隐藏  */
			$("#" + submenuId).toggle();
			/** 控制关闭或者开启的图标*/
			$("#" + navbgId).toggleClass("left_nav_expand");
			/** 控制其他的一级菜单的二级菜单隐藏按钮都关闭  */
			$("tr[id^='submenu']").not("#" + submenuId).hide();
			/** 控制其他一级菜单的图片显示关闭  */
			$("td[id^='navbg']").not(this).removeClass().addClass("left_nav_closed");
		})
	})
</script>
</head>
<body>
	<div style="margin: 10px; background-color: #FFFFFF; text-align: left;">
		<table width="200" height="100%" border="0" cellpadding="0" cellspacing="0" class="left_nav_bg">
			<tr>
				<td class="left_nav_top"><div class="font1">用户管理</div></td>
			</tr>
			<tr valign="top">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/user/list.do" target="main">用户查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/user/add.do?flag=1" target="main">添加用户</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg1" class="left_nav_closed"><div class="font1">部门管理</div></td>
			</tr>
			<tr valign="top" id="submenu1" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/department/list.do" target="main">部门查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/department/add.do?flag=1" target="main">添加部门</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg2" class="left_nav_closed"><div class="font1">职位管理</div></td>
			</tr>
			<tr valign="top" id="submenu2" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/job/list.do" target="main">职位查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/job/add.do?flag=1" target="main">添加职位</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg3" class="left_nav_closed"><div class="font1">员工管理</div></td>
			</tr>
			<tr valign="top" id="submenu3" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/employee/list.do" target="main">员工查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/employee/add.do?flag=1" target="main">添加员工</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg4" class="left_nav_closed"><div class="font1">公告管理</div></td>
			</tr>
			<tr valign="top" id="submenu4" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/notice/list.do" target="main">公告查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/notice/add.do?flag=1" target="main">添加公告</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg5" class="left_nav_closed" onClick="showsubmenu(5)"><div class="font1">下载中心</div></td>
			</tr>
			<tr valign="top" id="submenu5" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/document/list.do" target="main">文档查询</a>
					</p>
					<p class="left_nav_link">
						<img src="${pagePath}/page/static/images/left_nav_arrow.gif" />&nbsp;<a href="${pagePath}/document/add.do" target="main">上传文档</a>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr valign="top">
				<td height="100%" align="center">
					<div class="copycct" style="margin-left: 15px;">
					</div>
				</td>
			</tr>
			<tr>
				<td height="10"><img src="${pagePath}/page/static/images/left_nav_bottom.gif" height="10" /></td>
			</tr>
			<tr>
				<td height="10" bgcolor="#e5f0ff">&nbsp;</td>
			</tr>
		</table>
	</div>
</body>
</html>