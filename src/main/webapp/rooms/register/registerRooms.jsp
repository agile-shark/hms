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
    
    <title>入住登记</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
	
	
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
						"roomRes.rrTime":"required",
							"roomRes.rrPName":"required",
								"roomRes.rrDeposit":"required",
									"roomRes.rrPNum":"required",
									"roomRes.rrIdcard" : {
										required:true,
										minlength:15,
										maxlength:18
									}
				},
				messages : {
					"roomRes.rrTime" : "<font color='red'>开房日期不能为空</font>",
					"roomRes.rrPName" : "<font color='red'>房客姓名不能为空</font>",
					"roomRes.rrDeposit" : "<font color='red'>押金不能为空</font>",
					"roomRes.rrPNum" : "<font color='red'>入住人数不能为空</font>",
					"roomRes.rrIdcard" : {
						required: "<font color='red'>房客身份证不为空</font>",
						maxlength:jQuery.format("<font color='red'>房客身份证不多于18位</font>"),
						minlength:jQuery.format("<font color='red'>房客身份证不少于15位</font>")
					}  
				}
			})
		});
	
		function showResponse(responseXML, statusText, xhr, form) {
			alert("入住成功！");
			window.close();
		}
	
		function showError(responseXML, statusText, xhr, form) {
			alert("入住成功！");
			window.close();
		}
	</script>
  </head>
  
  <body>
  
  <div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="addForm" action="addroomResideRecordAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">入住信息</td></tr></thead>
			<input type="hidden" name="rooms.room_id" value='<s:property value="rooms.room_id"/>'
			<tr>
				<td class="rightTd" width="200px">客房号:</td>
				<td class="leftTd"><input type="text" id="rrNum"  name="roomRes.rrNum" value='<s:property value="rooms.roomNum"/>'/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">客房类型:</td>
				<td class="leftTd"><input type="text" id="rtName"  name="roomRes.rtName" value="<s:property value='rooms.roomType.rtName'/>"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">开房日期:</td>
				<td class="leftTd"><input type="text" id="rrTime" name="roomRes.rrTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
			</tr>
			
			<tr>
				<td class="rightTd" width="200px">房客姓名:</td>
				<td class="leftTd"><input type="text" id="rrPName" name="roomRes.rrPName" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">房客身份证号:</td>
				<td class="leftTd"><input type="text" id="rrIdcard" name="roomRes.rrIdcard" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">入住人数:</td>
				<td class="leftTd"><input type="text" id="rrPNum" name="roomRes.rrPNum" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">预计退房日期:</td>
				<td class="leftTd"><input type="text" id="rrPreTime" name="roomRes.rrPreTime"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
			</tr>
			
			<tr>
				<td class="rightTd" width="200px">入住天数:</td>
				<td class="leftTd"><input type="text" id="rrPName" name="roomRes.rrPName" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">押金:</td>
				<td class="leftTd"><input type="text" id="rrDeposit" name="roomRes.rrDeposit" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">是否是会员:</td>
				<td class="leftTd">							
					<input type="radio"  name="roomRes.rrMember" value="是" checked="checked"/>
					<span>是</span>
					<input type="radio"  name="roomRes.rrMember" value="否" />
					<span>否</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">开单人:</td>
				<td class="leftTd"><input type="text" id="rrBilling" name="roomRes.rrBilling"/></td>
			</tr>
			
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="登记"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
  </div>
  </body>
</html>
