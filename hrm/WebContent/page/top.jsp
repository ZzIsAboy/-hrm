<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统 ——后台登录</title>
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/css/css.css" />
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/timer.js"></script>
<script type="text/javascript">
	/** 文档加载完成后立即执行的方法 */
	// var weeks = new Array();
	$(function() {
		$("#nowTime").runTimer();
		$("#exit").click(function() {
			/** parent从主界面进行退出,避免局部刷新*/
			parent.location = "${pagePath}/logout.do";
		})
	})
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="320" height="80" class="topbg"><img src="${pagePath}/page/static/images/top_logo.gif" width="320" height="80"></td>
			<td class="topbg">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="50" class="toplink" align="right"><img src="${pagePath}/page/static/images/top_home.gif" />&nbsp;<a href="${pagePath}/index.do" target="_parent">网站首页</a>&nbsp;&nbsp;<img src="${pagePath}/page/static/images/top_exit.gif">&nbsp;<a href="${pagePath}/logout.do" id="exit">注销退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td height="30" class="topnavbg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="60"><img src="${pagePath}/page/static/images/StatBarL.gif" width="60" height="30"></td>
									<td class="topnavlh" align="left"><img src="${pagePath}/page/static/images/StatBar_admin.gif">&nbsp;当前用户：【${loguser.username}】</td>
									
									<td width="3%"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>