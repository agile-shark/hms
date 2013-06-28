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
	
	<script type="text/javascript">
		function module(type){
			switch(type){
				case 'day':
					url = "<%=request.getContextPath() %>/dayGoodStatisticsAction.action";
					break;
				case 'month':
					url = "<%=request.getContextPath() %>/monthGoodStatisticsAction.action";
					break;
				case 'year':
					url = "<%=request.getContextPath() %>/yearGoodStatisticsAction.action";
					break;
			}
			var chart = new FusionCharts(
					"FunsionChar/swf/Column2D.swf", "myfist", "750",
					"400");
			//chart.setDataURL(escape("column3DChart!initColumn3D.action"));
			$.ajax({
				url : url,
				type : 'post',
				dataType : 'text',
				async : false,
				error : function() {
				},
				success : function(data) {
					chart.setJSONData(data);
				}
			});
			chart.render("chartdiv");
			return false;
		}
	</script>	
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<span style="color: white;"> 
				<a href="javascript:void(0)" onclick="module('day');"><font color="white">今日销售商品</font></a>
				<a href="javascript:void(0)" onclick="module('month')"><font color="white">本月销售商品</font></a>
				<a href="javascript:void(0)" onclick="module('year')"><font color="white">年销售统计</font></a>
			</span>
		</h3>
		
		<table width="98%" cellpadding="0" cellspacing="0" border="0" align="center">
		<tr>
			<td align="center">
				<div id="chartdiv" align="center">
					<script type="text/javascript">
						var chart = new FusionCharts(
								"FunsionChar/swf/Column2D.swf", "myfist", "750",
								"400");
						//chart.setDataURL(escape("column3DChart!initColumn3D.action"));
						$.ajax({
							url : 'dayGoodStatisticsAction.action',
							type : 'post',
							dataType : 'text',
							async : false,
							error : function() {
							},
							success : function(data) {
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
