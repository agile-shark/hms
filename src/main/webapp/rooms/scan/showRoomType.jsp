<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>房间类型查看</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('span[id^="isExist"]').each(function(){
				if($(this).html() == 1){
					$(this).html("有");
				}else{
					$(this).html("无");
				}
			});
		});
	</script>
  </head>
  
  <body background="images/b.jpg">
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<form method="post" id="addForm" action="addroomTypeAction.action">
			<table width="800" cellspacing="0" cellPadding="0">
				<thead><tr><td colspan="2">房间类型信息</td></tr></thead>
				<tr>
					<td class="rightTd" width="200px">类型编号:</td>
					<td class="leftTd"><s:property value="roomType.rtNum"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">类型名称:</td>
					<td class="leftTd"><s:property value="roomType.rtName"/></td>
				</tr>
				 <tr>
					<td class="rightTd" width="200px">房间价格:</td>
					<td class="leftTd"><s:property value="roomType.rtPrice"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">特价:</td>
					<td class="leftTd">
						<span id="isExist1"><s:property value="roomType.rtBargain"/></span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">特价价格:</td>
					<td class="leftTd"><s:property value="roomType.rtBPrice"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">标准面积:</td>
					<td class="leftTd"><s:property value="roomType.rtArea"/></td>
				</tr>   	
				<tr>
					<td class="rightTd" width="200px">折扣:</td>
					<td class="leftTd"><s:property value="roomType.rtDiscount"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">电脑:</td>
					<td class="leftTd">							
						<span id="isExist2"><s:property value="roomType.rtComputer"/></span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">空调:</td>
					
					<td class="leftTd">							
						<span id="isExist3"><s:property value="roomType.rtCondition"/></span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">窗户:</td>
					
					<td class="leftTd">							
 						<span id="isExist4"><s:property value="roomType.rtWindow"/></span>
 					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">位置:</td>
					<td class="leftTd"><s:property value="roomType.rtLocation"/></td>
				</tr> 
				<tr>
					<td class="rightTd" width="200px">床位数:</td>
					<td class="leftTd"><s:property value="roomType.rtBNum"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd">
						<input type="button" onclick="javascript:window.close();" value="关闭"/>
					</td>
				</tr>
			</table>
		 </form>
  	</div>
 </body>
</html>
