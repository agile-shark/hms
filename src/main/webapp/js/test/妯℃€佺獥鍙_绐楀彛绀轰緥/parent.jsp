<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'parent.jsp' starting page</title>

 <script type="text/javascript"> 
        function openWin() { 
        	var reObj = window.showModalDialog('child.jsp', '', "dialogWidth:630px;status:no;dialogHeight:440px");
        	if (typeof(reObj) != "undefined") {
        		alert(reObj.reInfo + "," + reObj.reason );
        	} else {
        		alert("您未对当前待办任务做出任何操作...");
        	}

        } 
         
       
    </script> 
  </head> 
   
  <body> 
    name:<input type="text" id="name"/><a href="#" onclick="openWin()">请选择</a> 
    <input type="hidden" name="name" id="hname"/> 
  </body>
</html>

