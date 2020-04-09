<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面不存在</title>
</head>
<body>
	<div align="center">
		<h1>404</h1>
		<h2>服务器找不到您要的请求</h2>
		<h3>您访问的页面不存在</h3>
		<div>
			<a href="javascript:;" onclick="javascript: history.go(-1);" style="text-decoration: none; cursor: pointer; color: purple; color: red;">返回上一页</a> <a href="javascript:;" onclick="javascript:alert('请联系管理员');" style="text-decoration: none; cursor: pointer; color: purple; color: red;"> 联系管理员</a>
		</div>
	</div>
</body>
</html>
