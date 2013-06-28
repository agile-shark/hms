<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>退出系统</title>
    <%
    session.removeAttribute("user_session");
    session.invalidate();//session失效
    
    %>
	<script type="text/javascript">
	alert("您已经退出该系统");
	window.top.location.href="index.jsp";
	
	</script>

  </head>
  
  <body>
   
  </body>
</html>
