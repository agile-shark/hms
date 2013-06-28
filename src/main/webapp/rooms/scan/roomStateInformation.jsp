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
    <title>房间类型显示</title>
    <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admin/main.css" />

<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/util/tips.js"></script>
    
    
    <script type="text/javascript">
 
 function toPage(type){
	//获取当期页信息
		var pageNow = '<s:property value="pb.pageNow"/>';
		//总页数
		var totalPages = '<s:property value="pb.allPage"/>';
		var page_now = document.getElementById('page_now');

		if (type == '1') {
			page_now.value = "1";
		}

		if (type == '2') {
			page_now.value = parseInt(pageNow) - 1;
		}

		if (type == '3') {
			page_now.value = parseInt(pageNow) + 1;
		}

		if (type == '4') {
			page_now.value = parseInt(totalPages);
		}

		queryForm.submit();
 }
 
 </script>
<script type="text/javascript">
function subQueryForm() {
	
	var page_now = document.getElementById("page_now");
	page_now.value = "1";

	var page_num = document.getElementById("pageNum").value;

	var allPage = '<s:property value="pb.allPage"/>';
	if (page_num.length > 0) {
		if (parseInt(page_num) < 0 || page_num > parseInt(allPage)) {
			alert("抱歉你输入有误!");
			return false;
		} else {
			page_now.value = page_num;
		}
	}

	queryForm.submit();
}
</script>

<script type="text/javascript">
function subForm() {
	var pageNow = '<s:property value="pb.pageNow"/>';
	var allPage = '<s:property value="pb.allPage"/>';

	if (pageNow < 0 || pageNow > allPage) {
		alert("抱歉你输入有误!");
		return false;
	}
	pageForm.submit();
}
</script>

<script type="text/javascript">
	function delCheck(id){
		if(Window().confirm("确定要删除吗？")){
			window.location.href="delroomStateAction.action?roomState.roomState_id="+id;
		}
	}
</script>
    
  </head>
  
  <body>
  
  <div id="content">
		<h3 class="admin_link_bar">
			<span> <s:form action="RoomStatePageroomStateAction.action"
					method="post" name="queryForm">
			房间状态名称查询：<s:select list="rsList" name="roomState.rsName"
						listKey="rsName" listValue="rsName" headerKey="0"
						headerValue="--请选择--" value="roomState.rsName"></s:select>
						
					<input type="submit" value="查询" onclick="subQueryForm()" />
					<input type="hidden" name="pb.pageNow" id="page_now"
						value="<s:property value="pb.pageNow"/>" />
				</s:form> </span>
		</h3>
  	<table width="820" cellspacing="0" cellPadding="0" id="listTable1">
  		<thead>
  			<tr>
  			<td>序号</td>
  			<td>客房状态名</td>
  			<td>备注</td>
  			<td>基本操作</td>
  			</tr>
  		</thead>
  		<tbody>
  		<s:iterator value="pb.list"  var="rs" status="ty">
  		<tr>
  		<td><s:property value="#ty.index+1"/></td>
  		<td><s:property value="#rs.rsName"/></td>
  		<td><s:property value="#rs.rsRemark"/></td>
  		<td><a href="delroomStateAction.action?roomState.id=<s:property value="#rs.roomState_id"/>">删除</a>
  		<a href="getRoomStateToUpdateroomStateAction.action?roomState.id=<s:property value="#rs.roomState_id"/>">修改</a>
  		</td></tr>
  		</s:iterator>
  		</tbody>
  		</table>
	</div>
  		<div id="bottom">
		共有
		<s:property value="pb.totalCount" />
		条记录，当前第
		<s:property value="pb.pageNow" />
		/
		<s:property value="pb.allPage" />
		页
		<!-- 如果不是首页则提供首页的链接,如果是首页则不提供链接,以下类似 -->
		<s:if test="pb.pageNow != 1"> 
	[<a href="javascript:void(0)" onclick="toPage('1')">首页</a>]     
	</s:if>
		<s:else> [首页] </s:else>

		<s:if test="pb.pageNow>1">
	[<a href="javascript:void(0)" onclick="toPage('2')">上一页</a>]  
	</s:if>
		<s:else> [上一页]  </s:else>

		<s:if test="pb.allPage>pb.pageNow">
	[<a href="javascript:void(0)" onclick="toPage('3')">下一页</a>]
	</s:if>
		<s:else> [下一页] </s:else>

		<s:if test="pb.allPage != pb.pageNow">
	[<a href="javascript:void(0)" onclick="toPage('4')">末页</a>]
	</s:if>
		<s:else> [末页] </s:else>
		<span>转到第 <input name="pb.pageNow" id="pageNum" type="text"
			size="4" />页</span> <img src="images/go.gif" width="37" height="15"
			onclick="subQueryForm()" />
	</div>
  		
  </body>
</html>
