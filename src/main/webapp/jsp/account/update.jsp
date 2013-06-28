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
		
		var dept = $("#dept").val();
		$("select option").each(function(){
			if($(this).val() == dept){
				$(this).attr("selected", "selected");
			}
		});
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
					maxlength:15
				}
			},
			messages : {
				"account.account" : "登录帐号不能为空",
				"account.user_name":"用户姓名不能为空",
				"account.password":"用户密码为空",
				"account.email":"电子邮件格式不正确",
				"account.position":"职务不能为空",
				"account.createaccount":"创建人不能为空",
				"account.deptDepartment.dept_id":"所在部门不能为空",
				"account.telephone" : {
					number: "联系电话不为数字",
					maxlength:jQuery.format("联系电话不多于15位"),
					minlength:jQuery.format("联系电话不少于11位")
				}  
			}
		})
	});

	function showResponse(responseXML, statusText, xhr, form) {

		alert("修改成功！");
		window.close();
	}

	function showError(responseXML, statusText, xhr, form) {
		alert("修改成功！");
		window.close();
	}
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="updateForm" action="updateAccountAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">添加用户</td></tr></thead>
			<input type="hidden" value='<s:property value="account.account_id"/>' name="account.account_id"/>
			<tr>
				<td class="rightTd" width="200px">登录帐号:</td>
				<td class="leftTd"><input type="text" name="account.account" value='<s:property value="account.account"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户姓名:</td>
				<td class="leftTd"><input type="text" name="account.user_name" value='<s:property value="account.user_name"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">用户密码:</td>
				<td class="leftTd"><input type="password" name="account.password" value='<s:property value="account.password"/>'/></td>
			</tr>			
			<tr>
				<td class="rightTd" width="200px">联系电话:</td>
				<td class="leftTd"><input type="text" name="account.telephone" value='<s:property value="account.telephone"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">电子邮件:</td>
				<td class="leftTd"><input type="text" name="account.email" value='<s:property value="account.email"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">职务:</td>
				<td class="leftTd"><input type="text" name="account.position" value='<s:property value="account.position"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">所在部门:</td>
				<td class="leftTd">
					<input type="hidden" id="dept" value="<s:property value='account.deptDepartment.dept_id'/>">
					<select name="account.deptDepartment.dept_id">
						<option value="">--请选择部门--</option>
						<s:iterator value="depts">
							<option value='<s:property value="dept_id"/>'>
		 						<s:property value="dept_name" />
		 					</option>
						</s:iterator>			
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="确认修改"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
</div>
</body>
</html>