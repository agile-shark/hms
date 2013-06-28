<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>测试窗口</title>
<script type="text/javascript" src="js/util/tips.js"></script>

<script type="text/javascript">
	function winClose(){
		//获取传递过来的值
		var valObj = window.dialogArguments;
		alert(valObj.id);
		
		var retObj = new Object();
		retObj.name="shxt";
		//返回值
		window.returnValue = retObj;
		closePage(window);
	}
</script>
</head>

<body>

	<input type="button" id="name" value="测试关闭" onclick="winClose()" >

</body>
</html>

