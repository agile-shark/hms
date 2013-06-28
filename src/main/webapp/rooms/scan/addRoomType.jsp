<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<base href="<%=basePath%>">
		<title>添加房间类型界面</title>
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
			},
			rules :{
				"roomType.rtNum" : {
					required : true,
					remote : {
					    type : "POST",
						url : "checkTyperoomTypeAction.action",
						error : function() {
							alert("已存在的类型编号");
						}
					},
					number : true,
					minlength:5,
					maxlength:8
				}
			},
			messages : {
				"roomType.rtNum" : {
					required : "类型编号不能为空",
					remote : "该类型编号已被使用",
					number: "类型编号不是数字",
					minlength:jQuery.format(" 类型编号不少于 5位 "),
					maxlength:jQuery.format(" 类型编号不多于 8位")
				}
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
	<form method="post" id="addForm" action="addroomTypeAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">添加房间类型</td></tr></thead>
			<tr>
				<td class="rightTd" width="200px">类型编号:</td>
				<td class="leftTd"><input type="text" id="rtNum" name="roomType.rtNum" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">类型名称:</td>
				<td class="leftTd"><input type="text" id="rtName" name="roomType.rtName" /></td>
			</tr>
			 <tr>
				<td class="rightTd" width="200px">房间价格:</td>
				<td class="leftTd"><input type="text" id="rtPrice" name="roomType.rtPrice" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">特价:</td>
				<td class="leftTd">
					<input type="radio" id="rtBargain1" name="roomType.rtBargain" value="0" checked="checked"/>
					<span>无</span>
					<input type="radio" id="rtBargain2" name="roomType.rtBargain" value="1" />
					<span>有</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">特价价格:</td>
				<td class="leftTd"><input type="text" id="rtBPrice" name="roomType.rtBPrice" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">标准面积:</td>
				<td class="leftTd"><input type="text" id="rtArea" name="roomType.rtArea" /></td>
			</tr>   	
			<tr>
				<td class="rightTd" width="200px">折扣:</td>
				<td class="leftTd">	
					<input type="text" id="rtArea" name="roomType.rtDiscount" />						
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">电脑:</td>
				<td class="leftTd">							
					<input type="radio" id="rtComputer1" name="roomType.rtComputer" value="0" checked="checked"/>
					<span>无</span>
					<input type="radio" id="rtComputer2" name="roomType.rtComputer" value="1" />
					<span>有</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">空调:</td>
				<td class="leftTd">							
					<input type="radio" id="rtCondition1" name="roomType.rtCondition" value="0" checked="checked"/>
					<span>无</span>
					<input type="radio" id="rtCondition2" name="roomType.rtCondition" value="1" />
					<span>有</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">窗户:</td>
				<td class="leftTd">							
					<input type="radio" id="rtWindow1" name="roomType.rtWindow" value="0" checked="checked"/>
					<span>无</span>
					<input type="radio" id="rtWindow2" name="roomType.rtWindow" value="1" />
					<span>有</span>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">位置:</td>
				<td class="leftTd"><input type="text" id="rtLocation" name="roomType.rtLocation" /></td>
			</tr> 
			<tr>
				<td class="rightTd" width="200px">床位数:</td>
				<td class="leftTd"><input type="text" id="rtBNum" name="roomType.rtBNum" /></td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="添加房间类型"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
  </div>
  </body>
</html>
