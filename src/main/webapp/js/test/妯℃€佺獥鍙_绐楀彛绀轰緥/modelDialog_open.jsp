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
	function openWin() {
		var options = new Object();
		options.url="<%=path%>/js/test/dialog_return.jsp?name=shxt";
		options.name="win1";
		options.width=500;
		options.height=300;
		//传递参数
		options.args = {
			id:99		
		};
		
		var win = getPageSize();
		
		options.left=(win.pageWidth-options.width)/2
		options.top=(win.pageHeight-options.height)/2
		
		var obj = openModelPage(options);
		if (typeof(obj) != "undefined") {
			alert(obj.name);
		}

	}
</script>
</head>

<body>
<%!
	int count=1;
%>
<h1><%=count++ %></h1>

	<input type="button" id="name" value="window.open打开窗口" onclick="openWin()">

</body>
</html>

