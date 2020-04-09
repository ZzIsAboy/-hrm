<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>没有权限</title>
</head>
<body>
	<div align="center">
		<h1>403</h1>
		<h2>服务器拒绝您的请求</h2>
		<h3>您没有权限访问的该页面</h3>
		<div>
			<a href="javascript:;" onclick="javascript: history.go(-1);" style="text-decoration: none; cursor: pointer; color: purple; color: red;">返回上一页</a> <a href="javascript:;" onclick="javascript:alert('请联系管理员');" style="text-decoration: none; cursor: pointer; color: purple; color: red;"> 联系管理员</a>
		</div>
	</div>
</body>
</html>
