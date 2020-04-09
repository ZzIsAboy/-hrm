<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="pagePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——员工管理</title>
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
		/** 获取上一次选中的部门数据 */
		var boxs = $("input[type='checkbox'][id^='box_']");
		/** 给全选按钮绑定点击事件  */
		$("#checkAll").click(function() {
			// this是checkAll  this.checked是true
			// 所有数据行的选中状态与全选的状态一致
			boxs.attr("checked", this.checked);
		})
		/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
		$("tr[id^='data_']").hover(function() {
			$(this).css("backgroundColor", "#eeccff");
		}, function() {
			$(this).css("backgroundColor", "#ffffff");
		})
		/** 删除员工绑定点击事件 */
		$("#delete").click(function() {
			/** 获取到用户选中的复选框  */
			var checkedBoxs = boxs.filter(":checked");
			if (checkedBoxs.length < 1) {
				$.ligerDialog.error("请选择一个需要删除的员工！");
			} else {
				/** 得到用户选中的所有的需要删除的ids */
				var ids = checkedBoxs.map(function() {
					return this.value;
				})
				$.ligerDialog.confirm("确认要删除吗?", "删除员工", function(r) {
					if (r) {
						// alert("删除："+ids.get());
						// 发送请求
						window.location = "${pagePath}/employee/delete.do?ids=" + ids.get();
					}
				});
			}
		})
	})
</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="${pagePath}/page/static/images/pointer.gif">&nbsp;当前位置：员工管理&nbsp;&gt;&nbsp;员工查询</td>
			<td width="15" height="32"><img src="${pagePath}/page/static/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<!-- 查询区  -->
		<tr valign="top">
			<td height="30">
				<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
					<tr>
						<td class="fftd">
							<form name="empform" method="post" id="empform" action="${pagePath}/employee/list.do">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="font3">职位： <select name="job_id" style="width: 143px;">
												<option value="">--请选择职位--</option>
												<c:forEach items="${jobs}" var="job">
													<c:choose>
														<c:when test="${job_id == job.id}">
															<option value="${job.id}" selected="selected">${job.name}</option>
														</c:when>
														<c:otherwise>
															<option value="${job.id}">${job.name}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
										</select> 姓名：<input type="text" name="name" value="${name}"> 身份证号码：<input type="text" name="cardId" value="${cardId}" maxlength="18">
										</td>
									</tr>
									<tr>
										<td class="font3">性别： <select name="sex" style="width: 143px;">
												<c:if test="${empty sex}">
													<option value="" selected="selected">--请选择性别--</option>
													<option value="1">男</option>
													<option value="0">女</option>
												</c:if>
												<c:if test="${sex == 1}">
													<option value="">--请选择性别--</option>
													<option value="1" selected="selected">男</option>
													<option value="0">女</option>
												</c:if>
												<c:if test="${sex == 0}">
													<option value="">--请选择性别--</option>
													<option value="1">男</option>
													<option value="0" selected="selected">女</option>
												</c:if>
										</select> 手机：<input type="text" name="mobile" value="${mobile}"> &nbsp;所属部门：<select name="department_id" style="width: 100px;">
												<option value="">--部门选择--</option>
												<c:forEach items="${departments}" var="department">
													<c:choose>
														<c:when test="${department_id == department.id}">
															<option value="${department.id}" selected="selected">${department.name}</option>
														</c:when>
														<c:otherwise>
															<option value="${department.id}">${department.name}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
										</select>&nbsp; <input type="submit" value="搜索" /> <input type="button" onclick="location.href='${pagePath}/employee/list.do'" value="清空" /> <input id="delete" type="button" value="删除" />
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr class="main_trbg_tit" align="center">
						<td></td>
						<td>姓名</td>
						<td>性别</td>
						<td>手机号码</td>
						<td>邮箱</td>
						<td>职位</td>
						<td>学历</td>
						<td>身份证号码</td>
						<td>部门</td>
						<td>联系地址</td>
						<td>建档日期</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${employees}" var="entity" varStatus="x">
						<tr id="data_${x.index}" class="main_trbg" align="center">
							<td><input type="checkbox" id="box_${x.index}" value="${entity.employee.id}"></td>
							<td>${entity.employee.name}</td>
							<td><c:if test="${entity.employee.sex == 0}">女</c:if> <c:if test="${entity.employee.sex == 1}">男</c:if></td>
							<td>${entity.employee.mobile}</td>
							<td>${entity.employee.email}</td>
							<td>${entity.job.name}</td>
							<td>${entity.employee.education}</td>
							<td>${entity.employee.cardId}</td>
							<td>${entity.department.name}</td>
							<td>${entity.employee.address}</td>
							<td><fmt:formatDate value="${entity.employee.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td align="center" width="40px;"><a href="${pagePath}/employee/modify.do?flag=1&id=${entity.employee.id}"> <img title="修改" src="${pagePath}/page/static/images/update.gif" /></a></td>
						</tr>
					</c:forEach>
					<c:if test="${empty employees}">
						<tr>
							<td align="center" colspan="12">没有数据！</td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top">
			<td align="center" class="font3"><c:if test="${!empty pages.list}">
					<table width="100%" align="center" style="font-size: 13px;" class="sabrosus">
						<tr>
							<td style="color: #0061de; margin-right: 3px; padding-top: 2px; text-decoration: none"><c:if test="${pages.hasPreviousPage}">
									<a href="${pagePath}/employee/list.do?page=${pages.pageNum - 1}&key=${key}&status=${status}"> 上一页</a>
								</c:if> <c:if test="${!pages.hasPreviousPage}">
									<a href="javascript:void(0);"> 上一页</a>
								</c:if> <c:forEach items="${pages.navigatepageNums}" var="pageNum">
									<c:if test="${pageNum == pages.pageNum}">
										<span class="current">${pageNum}</span>
									</c:if>
									<c:if test="${pageNum != pages.pageNum}">
										<a href="${pagePath}/employee/list.do?page=${pageNum}&key=${key}&status=${status}">${pageNum}</a>
									</c:if>
								</c:forEach> <c:if test="${pages.hasNextPage}">
									<a href="${pagePath}/employee/list.do?page=${pages.pageNum + 1}&key=${key}&status=${status}"> 下一页</a>
								</c:if> <c:if test="${!pages.hasNextPage}">
									<a href="javascript:void(0);"> 下一页</a>
								</c:if>&nbsp;跳转到&nbsp;<input style="text-align: center; border-right: #aaaadd 1px solid; padding-right: 5px; border-top: #aaaadd 1px solid; padding-left: 5px; padding-bottom: 2px; margin: 2px; border-left: #aaaadd 1px solid; color: #000099; padding-top: 2px; border-bottom: #aaaadd 1px solid; text-decoration: none" type="text" size="2"
								id="pager_jump_page_size" />&nbsp;<input type="button"
								style="text-align: center; border-right: #dedfde 1px solid; padding-right: 6px; background-position: 50% bottom; border-top: #dedfde 1px solid; padding-left: 6px; padding-bottom: 2px; border-left: #dedfde 1px solid; color: #0061de; margin-right: 3px; padding-top: 2px; border-bottom: #dedfde 1px solid; text-decoration: none" value="确定"
								id="pager_jump_btn" /></td>
						</tr>
						<tr align="center" style="font-size: 13px;">
							<td style="color: #0061de; margin-right: 3px; padding-top: 2px; text-decoration: none">总共<font color="red">${pages.total}</font>条记录，当前第 ${pages.pageNum} 页。
							</td>
						</tr>
					</table>
				</c:if></td>
		</tr>
	</table>
	<div style="height: 10px;"></div>
	<script type="text/javascript">
		document.getElementById("pager_jump_btn").onclick = function(){
			var page_size = document.getElementById("pager_jump_page_size").value;
			if (!/^[1-9]\d*$/.test(page_size)||page_size<1||page_size>${pages.pages}){
				alert("请输入[ 1 - ${pages.pages} ]之间的页码！");
			}else{
				var submit_url = "${pagePath}/employee/list.do?page=" + page_size + "&key=${key}&status=${status}";
				window.location = submit_url;
			}
		}
	</script>
</body>
</html>