<%@page import="cn.com.shxt.sys_urp.domain.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		if($("#sex").html() == 1){
			$("#sex").html("男");
		}else{
			$("#sex").html("女");
		}
	});
	</script>
</head>
<body>
<div id="content">
		<h3 class="admin_link_bar"></h3>
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">用户信息</td></tr></thead>
			<tr>
				<td class="rightTd" width="200px">登录帐号:</td>
				<td class="leftTd"><s:property value="account.account"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户姓名:</td>
				<td class="leftTd"><s:property value="account.user_name"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户密码:</td>
				<td class="leftTd"><s:property value="account.password"/></td>
			</tr>			
			<tr>
				<td class="rightTd" width="200px">性别:</td>
				<td class="leftTd">							
					<span id="sex"><s:property value="account.sex"/></span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">联系电话:</td>
				<td class="leftTd"><s:property value="account.telephone"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">电子邮件:</td>
				<td class="leftTd"><s:property value="account.email"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">职务:</td>
				<td class="leftTd"><s:property value="account.position"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">创建者:</td>
				<td class="leftTd"><s:property value="account.createaccount"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">所在部门:</td>
				<td class="leftTd">
					<s:property value="account.deptDepartment.dept_name"/>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户角色:</td>
				<td class="leftTd">
						<s:iterator value="account.roleSet">
							<s:property value='role_name'/>
						</s:iterator>			
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd">
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
</div>
</body>
</html>