<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base target="_self"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>
<body>
<div id="content">
	<form method="post" id="updateRootForm" action="updateRootModuleAction.action">
	<s:hidden name="module.module_id"></s:hidden>
	<table width="300" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">更新Root节点功能</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">Root节点名称</td>
			<td class="leftTd"><s:textfield name="module.name" id="module_name" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">类型排序:</td>
			<td class="leftTd"><s:textfield name="module.sortno" id="sortno" size="30"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="更新"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="重置1"/></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>