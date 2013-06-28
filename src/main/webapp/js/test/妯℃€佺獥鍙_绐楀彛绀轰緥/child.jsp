<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'child.jsp' starting page</title>
    
	<script type="text/javascript"> 
	function commitTransact() {
		if (confirm("请确认您的意见?")) {
			var obj = new Object();
			obj.reInfo = "123";
			obj.reason = "456";
			window.returnValue = obj;
			window.close();
		}
	}
    </script> 
  </head> 
   
  <body> 
   <input type="button" value="关闭窗口" onclick="commitTransact()">
     
  </body> 