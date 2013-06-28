<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/FunsionChar/jsp/FusionCharts.jsp"%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>FusionCharts - Simple Column 3D Chart</title>
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="FunsionChar/js/FusionCharts.debug.js"></script>
		<script type="text/javascript"></script>
	</head>

	<body bgcolor="#ffffff">
		<h3>
			JQUERY-AJAX读取数据
		</h3>
		<table width="98%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td align="center">
					<div id="chartdiv" align="center"></div>
					<script type="text/javascript">
						function myJs(text) {
							alert(text);
						}
						var chart = new FusionCharts("FunsionChar/swf/Pareto3D.swf", "myfist", "900", "400");
						//chart.setDataURL(escape("column3DChart!initColumn3D.action"));
						$.ajax( {
							url : 'toDataTestXMLAction.action',
							type : 'post',
							dataType : 'text',
							async : false,
							error : function() {
							},
							success : function(data) {
								chart.setDataXML(data);
							}
						});
						chart.render("chartdiv");
					</script>
				</td>
			</tr>
		</table>



	</body>
</html>
