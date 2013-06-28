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
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {
		
		$("#addForm").validate({
			submitHandler:function(form){
				var options = {
					success : showResponse, // 成功提交表单之后显示此页面
					error : showError,
					dataType : "text"
				};
				$(form).ajaxSubmit(options); // 用ajax提交表单
			},
			rules :{
				"account.account":"required",
				"account.user_name":"required",
				"account.password":"required",
				"account.email":"email",
				"account.position":"required",
				"account.createaccount":"required",
				"account.deptDepartment.dept_id":"required",
				"account.telephone" : {
					number:true,
					minlength:11,
					maxlength:11
				}
			},
			messages : {
				"account.account" : "<font color='red'>登录帐号不能为空</font>",
				"account.user_name":"<font color='red'>用户姓名不能为空</font>",
				"account.password":"<font color='red'>用户密码为空</font>",
				"account.email":"<font color='red'>电子邮件格式不正确</font>",
				"account.position":"<font color='red'>职务不能为空</font>",
				"account.createaccount":"<font color='red'>创建人不能为空</font>",
				"account.deptDepartment.dept_id":"<font color='red'>所在部门不能为空</font>",
				"account.telephone" : {
					number: "<font color='red'>联系电话不为数字</font>",
					maxlength:jQuery.format("<font color='red'>联系电话不多于11位</font>"),
					minlength:jQuery.format("<font color='red'>联系电话不少于11位</font>")
				}  
			}
		})
	});

	function showResponse(responseXML, statusText, xhr, form) {
		if(confirm("创建成功！继续创建？")){
			$(form).validate().resetForm();
		}else{
			window.close();
		}
	}

	function showError(responseXML, statusText, xhr, form) {
		alert("error");
	}
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="addForm" action="addAccountAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">添加用户</td></tr></thead>
			<tr>
				<td class="rightTd" width="200px">登录帐号:</td>
				<td class="leftTd"><input type="text" name="account.account"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户姓名:</td>
				<td class="leftTd"><input type="text" name="account.user_name"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户密码:</td>
				<td class="leftTd"><input type="password" name="account.password"/></td>
			</tr>			
			<tr>
				<td class="rightTd" width="200px">性别:</td>
				<td class="leftTd">							
					<input type="radio" id="sex1" name="account.sex" value="0" checked="checked"/>
					<span>男</span>
					<input type="radio" id="sex2" name="account.sex" value="1" />
					<span>女</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">联系电话:</td>
				<td class="leftTd"><input type="text" name="account.telephone"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">电子邮件:</td>
				<td class="leftTd"><input type="text" name="account.email"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">职务:</td>
				<td class="leftTd"><input type="text" name="account.position"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">创建者:</td>
				<td class="leftTd"><input type="text" name="account.createaccount"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">所在部门:</td>
				<td class="leftTd">
					<select name="account.deptDepartment.dept_id">
						<option selected="selected" value="">--请选择部门--</option>
						<s:iterator value="depts">
							<option value='<s:property value="dept_id"/>'>
		 						<s:property value="dept_name" />
		 					</option>
						</s:iterator>			
					</select>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户角色:</td>
				<td class="leftTd">
						<s:iterator value="roles">
							<input type="checkbox" name="ids" value="<s:property value='role_id'/>"/><s:property value="role_name" />
						</s:iterator>			
					</td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="添加用户"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
</div>
</body>
</html>