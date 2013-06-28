<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
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
			}
		})
	});

	function showResponse(responseXML, statusText, xhr, form) {
		if(confirm("创建成功！继续创建？")){
			$(form).validate().resetForm();
		}else{
			window.close();
		}
	}

	function showError(responseXML, statusText, xhr, form) {
		alert("error");
	}
  </script>
  </head>
  
  <body>
  
  <div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="addForm" action="addRoomsAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">添加房间信息</td></tr></thead>
			<tr>
				<td class="rightTd" width="200px">房间门牌号：</td>
				<td class="leftTd"><input type="text" id="roomNo" name="rooms.roomNum"/></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">房间类型：</td>
				<td class="leftTd">
					<select name="roomType.roomType_id">
						<option selected="selected" value="">--请选择房间类型--</option>
						<s:iterator value="roomTypeList">
							<option value='<s:property value="roomType_id"/>'>
		 						<s:property value="rtName" />
		 					</option>
						</s:iterator>			
					</select>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">房间状态：</td>
				<td class="leftTd">
					<select name="roomState.roomState_id">
						<option selected="selected" value="">--请选择房间状态--</option>
						<s:iterator value="roomStateList">
							<option value='<s:property value="roomState_id"/>'>
		 						<s:property value="rsName" />
		 					</option>
						</s:iterator>			
					</select>
				</td>
			</tr>
			 <tr>
				<td class="rightTd" width="200px">备注：</td>
				<td class="leftTd"><input type="text" id="remark" name="rooms.roomRemark" /></td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="添加房间信息"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
  </div>
  </body>
</html>
