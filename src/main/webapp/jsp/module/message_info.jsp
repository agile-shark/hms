<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>针对模块信息的处理集中营</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/admin/main.css"/>
	<script type="text/javascript" src="<%=path %>/js/util/tips.js"></script>
	<script type="text/javascript">
		function rootWinClose(){
			var obj = new Object();
			obj.flag = "ok";
			
			window.returnValue = obj;
			window.close();
		}
		
		function goRootHistory(){
			window.history.go(-1);
		}
	</script>
  </head>
  
  <body>
  
  	<div id="content">
  	<h3 class="admin_link_bar">
		<s:property value="message"/>
	</h3>
	<input type="button" value="关闭窗口" onclick="rootWinClose()">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="goRootHistory()">
 	</div>
  </body>
</html>
