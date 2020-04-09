<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统</title>
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/plugins/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/css/style-metro.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/metronic/css/pages/lock.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${pagePath}/page/static/js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/core/base.js" type="text/javascript"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script type="text/javascript" src="${pagePath}/page/static/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		/** 按了回车键 */
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				$("#login-submit-btn").trigger("click");
			}
		})
		/** 给登录按钮绑定点击事件  */
		$("#login-submit-btn").on("click", function() {
			/** 校验登录参数 ctrl+K */
			var loginname = $("#loginname").val();
			var password = $("#password").val();
			var msg = "";
			if (!/^\w{4,20}$/.test(loginname)) {
				msg = "登录名长度必须是6~20之间";
			} else if (!/^\w{4,20}$/.test(password)) {
				msg = "密码长度必须是6~20之间";
			}
			if (msg != "") {
				$.ligerDialog.error(msg);
				return;
			}
			/** 提交表单 */
			$("#loginForm").submit();
		})
	})
</script>
</head>
<body style="font-family: 微软雅黑">
	<div class="page-lock">
		<div class="page-logo" style="margin-bottom: 2px">
			<a class="brand" href="login.html" style="font-size: 22px; color: #FFF;"> 人事管理<font color="#FFCC00">HRM</font><span style="font-size: 13px;">1.1.0</span> 系统
			</a>
		</div>
		<form action="${pagePath}/login.do" method="post" id="loginForm">
			<div class="page-body">
				<img class="page-lock-img" src="${pagePath}/page/static/js/metronic/img/profile/logo2.jpg" alt="">
				<div class="page-lock-info">
					<span>&nbsp;</span>
					<c:choose>
						<c:when test="${requestScope.message == null }">
							<span style="padding-top: 5px">允许以中文名称登录</span>
						</c:when>
						<c:otherwise>
							<span style="padding-top: 5px"><font color="red">${requestScope.message}</font></span>
						</c:otherwise>
					</c:choose>
					<div class="control-group">
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-user"></i> <input class="m-wrap placeholder-no-fix" type="text" placeholder="帐号" id="username" name="username">
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" id="password" name="password">
							</div>
						</div>
					</div>
				</div>
				<div class="relogin">
					<button type="button" id="login-submit-btn" class="btn green" style="margin-left: 20px">
						登录 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
			</div>
			<div class="page-footer" style="color: #fff">
				@ 枫清叶淡&nbsp;&nbsp;&nbsp;<a href="http://www.fengqingyedan.com" target="_blank" style="text-decoration: none; cursor: pointer; color: white;">http://www.fengqingyedan.com</a>
			</div>
		</form>
	</div>
	<script src="${pagePath}/page/static/js/metronic/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="${pagePath}/page/static/js/metronic/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pagePath}/page/static/js/metronic/plugins/breakpoints/breakpoints.js" type="text/javascript"></script>
	<script src="${pagePath}/page/static/js/metronic/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="${pagePath}/page/static/js/metronic/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
	<script src="${pagePath}/page/static/js/metronic/scripts/app.js"></script>
	<script src="${pagePath}/page/static/js/metronic/scripts/lock.js"></script>
	<script>
		$(function() {
			App.init();
			Lock.init();
		});
	</script>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>