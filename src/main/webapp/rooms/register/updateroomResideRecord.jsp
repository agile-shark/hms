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
    <title>顾客入住信息查看</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>

	

  </head>
  
  <body background="images/b.jpg">
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<form method="post" id="addForm" action="updateroomResideRecordAction.action" name="queryForm">
			<input type="hidden" name="roomRes.rr_id" value="<s:property value="roomRes.rr_id"/>" />
			<table width="800" cellspacing="0" cellPadding="0">
				<thead><tr><td colspan="2">顾客结账</td></tr></thead>
				
				<tr>
					<td class="rightTd" width="200px">客房号:</td>
					<td class="leftTd"><s:property value="roomRes.rrNum"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">客房类型:</td>
					<td class="leftTd"><s:property value="roomRes.rtName"/></td>
				</tr>
				 <tr>
					<td class="rightTd" width="200px">订房日期:</td>
					<td class="leftTd"><s:property value="roomRes.rrTime"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">房客姓名:</td>
					<td class="leftTd">
						<s:property value="roomRes.rrPName"/>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">房客身份证号:</td>
					<td class="leftTd"><s:property value="roomRes.rrIdcard"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">房客人数:</td>
					<td class="leftTd"><s:property value="roomRes.rrPNum"/></td>
				</tr>   	
				<tr>
					<td class="rightTd" width="200px">预计退房日期:</td>
					<td class="leftTd"><s:property value="roomRes.rrPreTime"/></td>
				</tr>
				
				<tr>
					<td class="rightTd" width="200px">押金:</td>
					<td class="leftTd">							
						<s:property value="roomRes.rrDeposit"/>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">应付金额:</td>
					
					<td class="leftTd">							
 						<s:property value="roomRes.rrPreMoney"/>
 					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">实际金额:</td>
					<td class="leftTd"><s:property value="roomRes.rrRealityMoney"/></td>
				</tr> 
				<tr>
					<td class="rightTd" width="200px">入住天数:</td>
					<td class="leftTd"><s:property value="roomRes.rrDate"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">是否是会员:</td>
					<td class="leftTd"><s:property value="roomRes.rrMember"/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">开单人:</td>
					<td class="leftTd"><input type="text" name="roomRes.rrBilling" id="rrBilling"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd">
						<%--<input type="button" value="退宿" onclick="outCheck()"/>
						--%><input type="submit" value="退宿" />  
						<input type="button" onclick="javascript:window.close();" value="关闭"/>
					</td>
				</tr>
			</table>
		 </form>
  	</div>
 </body>
</html>
