<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/FunsionChar/jsp/FusionCharts.jsp"%>
<html>
<head>
	<base href="<%=basePath%>">
	<title>FusionCharts - Simple Column 3D Chart</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/admin/main.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="FunsionChar/js/FusionCharts.debug.js"></script>
	
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<span> 
				<a href="#" onclick="">当日类型统计</a>
				<a href="#" onclick="">当月类型统计</a>
				<a href="#" onclick="">月销售统计</a>
			</span>
		</h3>
		
		<table width="98%" cellpadding="0" cellspacing="0" border="0" align="center">
		<tr>
			<td align="center">
				<div id="chartdiv" align="center">
					<script type="text/javascript">
						function myJs(text) {
							alert(text);
						}
						var chart = new FusionCharts(
								"FunsionChar/swf/Column2D.swf", "myfist", "900",
								"400");
						//chart.setDataURL(escape("column3DChart!initColumn3D.action"));
						$.ajax({
							url : 'toDataTestJSONAction.action',
							type : 'post',
							dataType : 'text',
							async : false,
							error : function() {
							},
							success : function(data) {
								alert(data);
								chart.setJSONData(data);
							}
						});
						chart.render("chartdiv");
					</script>
				</div> 
			</td>
		</tr>
	</table>
	</div>
	<div id="bottom">
	</div>
</body>
</html>
