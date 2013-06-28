<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>购买商品</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
	
</head>
  
  <body>
  
  <div id="content">
	<h3 class="admin_link_bar"></h3>
	<form method="post" id="addForm" action="addconsumeRecordAction.action">
		<table width="800" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">购买商品</td></tr></thead>
			<tr>
				<td class="rightTd" width="200px">商品名称:</td>
				<td class="leftTd"><input type="text" id="csName" name="consumeRecord.csName" value="<s:property value='goods.goodsName'/>"/></td>
			</tr>
			 <tr>
				<td class="rightTd" width="200px">商品单价:</td>
				<td class="leftTd"><input type="text" id="csPrice" name="consumeRecord.csPrice"  value="<s:property value='goods.goodsPrice'/>"/></td>
			</tr>
			<input type="hidden" value="<s:property value='goods.goodsType.cdt_id'/>" name="consumeRecord.goodsType.cdt_id"/>
			<tr>
				<td class="rightTd" width="200px">商品数量:</td>
				<td class="leftTd"><input type="text" id="csNum" name="consumeRecord.csNum" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">客房号:</td>
				<td class="leftTd">
					<select name="consumeRecord.roomResideRecord.rr_id">
						<option value="0">--请选择客房号--</option>
						<s:iterator value="resideRecords">
							<option value="<s:property value='rr_id'/>"><s:property value='rrNum'/></option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">客户身份证号:</td>
				<td class="leftTd">
					<select name="consumeRecord.rrIdcard">
						<option value="0">--请选择身份证号--</option>
						<s:iterator value="resideRecords">
							<option value="<s:property value='rrIdcard'/>"><s:property value='rrIdcard'/></option>
						</s:iterator>
					</select>
			</tr>
			<tr>
				<td class="rightTd" width="200px">开单人:</td>
				<td class="leftTd"><input type="text" id="csBilling" name="consumeRecord.csBilling" /></td>
			</tr>
			<tr>
				<td class="rightTd" width="200px">备注:</td>
				<td class="leftTd"><input type="text" id="csDes" name="consumeRecord.csDes" /></td>
			</tr>
			
			<tr>
				<td colspan="2" class="centerTd">
				<input type="submit" value="确认购买"/>
				<input type="reset" value="重置"/>
				<input type="button" onclick="javascript:window.close();" value="关闭"/>
				</td>
			</tr>
		</table>
	 </form>
  </div>
  </body>
</html>
