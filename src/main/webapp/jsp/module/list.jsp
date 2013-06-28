<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/util/tips.js"></script>

<script type="text/javascript">
	function moduleWin(type){
		var url = "";
		switch(type){
			case 'add':
				url = "<%=request.getContextPath() %>/toAddRootJspModuleAction.action";
				break;
			case 'update':
				var val=$('input:radio[name="module.module_id"]:checked').val();
				url = "<%=request.getContextPath() %>/toUpdateRootJspModuleAction.action?module.module_id="+val;
				break;
		}
		//调用打开模态窗口
		//设置属性
		var options = new Object();
		options.url=url;
		//传递参数
		options.args = {};
		options.width="400px";
		options.height="200px";
		
		var win = getPageSize();
		
		options.left=(win.pageWidth-options.width)/2
		options.top=(win.pageHeight-options.height)/2
		
		var obj = openModelPage(options);
		
		
		window.location.reload(true);
		window.parent.frames["nav"].location.reload();  
	}
	
	function moduleDel(obj){
		if(window.confirm("删除Root节点，需要谨慎，您确定?")){
			var val=$('input:radio[name="module.module_id"]:checked').val();
			url = "<%=request.getContextPath() %>/toDeleteRootModuleAction.action?module.module_id="+val;
			
			alert(url);
			return false;
			obj.href=url;
		}
	}
	

</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<span>
			<a href="javascript:void(0)" onclick="moduleWin('add')" class="admin_link">新增Root</a>
			<a href="javascript:void(0)" onclick="moduleWin('update')" class="admin_link">编辑Root</a>
			<a href="javascript:void(0)" onclick="moduleDel(this)" class="admin_link">删除Root</a>
			<a href="<%=request.getContextPath() %>/admin/role/roles" class="admin_link">新增子模块</a>
		</span>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>序号</td>
			<td>根模块名称</td>
			<td>模块路径</td>
		</tr>
		</thead>
		<tbody>
		<s:iterator value="allModuleList" var="module" status="st">
			<tr>
				<td><input type="radio" name="module.module_id" value="<s:property value="#module.module_id"/>"  <s:if test="#st.first">checked="checked"</s:if>/></td>
				<td><s:property value="#module.name"/></td>
				<td><s:if test="#module.url==null">无访问路径</s:if></td>
			</tr>
		</s:iterator>
		
		</tbody>
	</table>
</div>
</body>
</html>