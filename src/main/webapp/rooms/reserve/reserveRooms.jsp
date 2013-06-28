<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>房间预订</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript">

		$(document).ready(function() {
			
			$("#addForm").validate({
				submitHandler:function(form){
					var options = {
						success : showResponse, // 成功提交表单之后显示此页面
						error : showError,
						dataType : "text"
					};
					$(form).ajaxSubmit(options); // 用ajax提交表单
				},
				rules :{
					"roomSchedule.rrPName":"required" 
				},
				messages : {
					"roomSchedule.rrPName" : "<font color='red'>预订人姓名不能为空</font>" 
				}
			})
		});
	
		function showResponse(responseXML, statusText, xhr, form) {
			alert("预订成功！");
			window.close();
		}
	
		function showError(responseXML, statusText, xhr, form) {
			alert("预订成功！");
			window.close();
		}
	</script>
  
  </head>
  
  <body>
  
  <div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="addForm" action="reserveUpdateroomScheduleAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">房间预订</td></tr></thead>
			<input type="hidden" name="rooms.room_id" value='<s:property value="rooms.room_id"/>'
			<tr>
				<td class="rightTd" width="200px">预订人姓名:</td>
				<td class="leftTd"><input type="text" id="rrPName" name="roomSchedule.rrPName" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">预住日期:</td>
				<td class="leftTd"><input type="text" id="scheTime" name="roomSchedule.scheTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
			</tr>
			
			<tr>
				<td class="rightTd" width="200px">预住天数:</td>
				<td class="leftTd"><input type="text" id="scheDay" name="roomSchedule.scheDay" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">押金:</td>
				<td class="leftTd"><input type="text" id="scheDeposit" name="roomSchedule.scheDeposit" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">预订房间编号:</td>
				<td class="leftTd"><input type="text" id="scheNum" disabled="disabled" name="roomSchedule.scheNum" value="<s:property value='rooms.roomNum'/>" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">开单人:</td>
				<td class="leftTd"><input type="text" id="scheBilling" name="roomSchedule.scheBilling" /></td>
			</tr>
			
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="预订"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
  </div>
  </body>
</html>
