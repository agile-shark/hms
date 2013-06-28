<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>角色标识</td>
			<td>角色名称</td>
			<td>角色描述</td>
			<td>角色操作</td>
		</tr>
		</thead>
		<tbody>
			<s:iterator value="pb.list" status="st">
				<tr><%--
					<td><input type="radio" name="account.account_id"
						value="<s:property value="#ac.account_id"/>"
						<s:if test="#st.first">checked="checked"</s:if> />
					</td>
					--%>
					<td><s:property value="role_id" /></td>
					<td><s:property value="role_name" />
					</td>
					<td><s:property value="role_desc" />
					</td>
					<td>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>