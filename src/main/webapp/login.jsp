<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/login.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<title>后台管理登录</title>
<style type="text/css">
	.message{
		color: red;
		
	}
</style>

<script type="text/javascript">
	function reCheckcode(o){
		o.src= "RandCheckCode?nocache="+new Date().getTime();
	}
	function subLogin(){
		
		var account = $.trim($("#account").val());
		var password = $.trim($("#password").val());
		if(account.length==0||password.length==0){
			alert("请输入帐号或者密码");
			return false;
		}
		
		var validateCode = $.trim($("#validateCode").val())
		if(validateCode.length==0){
			alert("请输入验证码");
			return false;
		}
		return true;
		
		
	}
</script>
</head>
<body>
	<div id="container">
		<div id="top">
		
		</div>
		<div id="loginBar">
			<span id="showDate">欢迎您使用如家后台管理，请登录</span>
		</div>
		<div id="content">
			<div id="loginForm">
				<form action="loginAccountAction.action" method="post" name="loginForm" onsubmit="return subLogin();">
					<table cellpadding="0" cellspacing="0" width="380px" id="loginTable">
						<tr>
							<td align="right" width="90">登录用户:</td>
							<td align="left"><input name="account.account" id="account" size="25"/> </td>
						</tr>
						<tr>
							<td align="right">登录密码:</td>
							<td align="left"><input type="password" name="account.password" id="password"  size="25"/></td>
						</tr>
						<tr>
							<td align="right">验证码:</td>
							<td align="left">
							<input type="text" name="validateCode" id="validateCode" size="15"/>
							<s:property value="message" escape="false"/>
							
							</td>
						</tr>
						<tr>
							<td align="left" colspan="2">
							<span style="margin-left:94px;cursor:pointer">
							<img src="RandCheckCode" onclick="reCheckcode(this)"/></span>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>	
</body>
</html>