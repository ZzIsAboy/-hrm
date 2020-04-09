<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——添加文档</title>
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/css/css.css" />
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery.form.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/** 表单提交的校验 */
		$("#btn").click(function() {
			var title = $("#title").val();
			var file = $("#file").val();
			if ($.trim(title).length <= 2) {
				alert("请输入两个字符以上的标题");
				return;
			} else if (!file) {
				alert("请上传文档！");
				return;
			}
			$("#documentForm").submit();
		})
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
			<td class="main_locbg font2"><img src="${pagePath}/page/static/images/pointer.gif">&nbsp;当前位置：文档管理&nbsp;&gt;&nbsp;上传文档</td>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" class="main_tabbor">
		<tr valign="top">
			<td>
				<form id="documentForm" name="documentForm" action="${pagePath}/document/add_save.do" enctype="multipart/form-data" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
						<tr>
							<td class="font3 fftd">文档标题：<input type="text" name="title" size="30" id="title" /></td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td class="font3 fftd">文档描述：<br /> <textarea name="remark" cols="88" rows="11" id="content"></textarea>
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td class="font3 fftd">文档：<br /> <input type="file" name="file" id="file" size="30" />
							</td>
						</tr>
						<tr>
							<td class="main_tdbor"></td>
						</tr>
						<tr>
							<td class="font3 fftd"><input type="button" id="btn" value="上传"> <input type="reset" value="重置"></td>
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