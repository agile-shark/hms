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
    <title>房间类型修改</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
		
			$("input[type='hidden']").each(function(){
				var is = $(this).val();
				$(this).siblings(".leftTd").children("input[type='radio']").each(function(){
					if($(this).val() == is){
						$(this).attr("checked", "checked");
					}
				})
			})
		});
	</script>
  </head>
  
  <body background="images/b.jpg">
	<div id="content">
		<h3 class="admin_link_bar"></h3>
		<form method="post" id="addForm" action="updateroomTypeAction.action">
			<input type="hidden" name="roomType.roomType_id" value="<s:property value="roomType.roomType_id"/>">
			<table width="800" cellspacing="0" cellPadding="0">
				<thead><tr><td colspan="2">房间类型信息</td></tr></thead>
				<tr>
					<td class="rightTd" width="200px">类型编号:</td>
					<td class="leftTd"><s:property value="roomType.rtNum"/> </td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">类型名称:</td>
					<td class="leftTd"><input type="text" id="rtName" name="roomType.rtName"  value='<s:property value="roomType.rtName"/>'/></td>
				</tr>
				 <tr>
					<td class="rightTd" width="200px">房间价格:</td>
					<td class="leftTd"><input type="text" id="rtPrice" name="roomType.rtPrice"  value='<s:property value="roomType.rtPrice"/>'/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">特价:</td>
					<input type="hidden" id="isExist1" value='<s:property value="roomType.rtBargain"/>'/>
					<td class="leftTd">
						<input type="radio" id="rtBargain1" name="roomType.rtBargain" value="0" ="checked"/>
						<span>无</span>
						<input type="radio" id="rtBargain2" name="roomType.rtBargain" value="1" />
						<span>有</span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">特价价格:</td>
					<td class="leftTd"><input type="text" id="rtBPrice" name="roomType.rtBPrice"  value='<s:property value="roomType.rtBPrice"/>'/></td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">标准面积:</td>
					<td class="leftTd"><input type="text" id="rtArea" name="roomType.rtArea"  value='<s:property value="roomType.rtArea"/>'/></td>
				</tr>   	
				<tr>
					<td class="rightTd" width="200px">折扣:</td>
					<td class="leftTd">	
						<input type="text" id="rtArea" name="roomType.rtDiscount" value='<s:property value="roomType.rtDiscount"/>'/>						
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">电脑:</td>
					<input type="hidden" id="isExist2" value='<s:property value="roomType.rtComputer"/>'/>
					<td class="leftTd">							
						<input type="radio" id="rtComputer1" name="roomType.rtComputer" value="0"/>
						<span>无</span>
						<input type="radio" id="rtComputer2" name="roomType.rtComputer" value="1" />
						<span>有</span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">空调:</td>
					<input type="hidden" id="isExist3" value='<s:property value="roomType.rtCondition"/>'/>
					<td class="leftTd">							
						<input type="radio" id="rtCondition1" name="roomType.rtCondition" value="0"/>
						<span>无</span>
						<input type="radio" id="rtCondition2" name="roomType.rtCondition" value="1" />
						<span>有</span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">窗户:</td>
					<input type="hidden" id="isExist4" value='<s:property value="roomType.rtWindow"/>'/>
					<td class="leftTd">							
						<input type="radio" id="rtWindow1" name="roomType.rtWindow" value="0"/>
						<span>无</span>
						<input type="radio" id="rtWindow2" name="roomType.rtWindow" value="1" />
						<span>有</span>
					</td>
				</tr>
				<tr>
					<td class="rightTd" width="200px">位置:</td>
					<td class="leftTd"><input type="text" id="rtLocation" name="roomType.rtLocation"  value='<s:property value="roomType.rtLocation"/>'/></td>
				</tr> 
				<tr>
					<td class="rightTd" width="200px">床位数:</td>
					<td class="leftTd"><input type="text" id="rtBNum" name="roomType.rtBNum"  value='<s:property value="roomType.rtBNum"/>'/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd">
					<input type="submit" value="修改">
						<input type="button" onclick="javascript:window.close();" value="关闭"/>
					</td>
				</tr>
			</table>
		 </form>
  	</div>
 </body>
</html>
