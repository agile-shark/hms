<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		function moduleWin(type, id){
		var url = "";
		switch(type){
			case 'add':
				url = "<%=request.getContextPath() %>/toAddRoomsJspRoomsAction.action";
				break;
			case 'update':
				url = "<%=request.getContextPath() %>/toUpdateRoomTypeJspRoomsAction.action?roomType.roomType_id="+id;
				break;
			case 'view':
				url = "<%=request.getContextPath() %>/toLoadRoomTypeJspRoomsAction.action?roomType.roomType_id="+id;
				break;
		}
		//调用打开模态窗口
		//设置属性
		var options = new Object();
		options.url=url;
		//传递参数
		options.args = {};
		options.width="600px";
		options.height="450px";
		
		var win = getPageSize();
		
		options.left=(win.pageWidth-options.width)/2
		options.top=(win.pageHeight-options.height)/2
		
		var obj = openModelPage(options);
		
		
		window.location.reload(true);
		window.parent.frames["nav"].location.reload();  
	}
	
	function moduleDel(id){
		if(window.confirm("删除房间类型，需要谨慎，您确定?")){
			var url = "<%=request.getContextPath() %>/delroomTypeAction.action?roomType.roomType_id="+id;
			$.ajax({
				type : "post",// 请求方式return confirm('确实要删除吗?')
				url : url,// 要访问的servlet
				dataType : "text"// 访问成功后，返回的数据格式，是xml,html还是其他
			});
			$("#" + id).remove();
			return false;
		}
	}
	
 </script>

 <script type="text/javascript">

		function toPage(type) {
			//获取当期页信息
			var pageNow = '<s:property value="pb.pageNow"/>';
			
			//总页数
			var totalPages = '<s:property value="pb.allPage"/>';
		
			if (type == '1') {
				document.getElementById('page_now').value = '1';
			}
			if (type == '2') {
				
				document.getElementById('page_now').value = parseInt(pageNow) - 1;
			}
			if (type == '3') {
				document.getElementById('page_now').value = parseInt(pageNow) + 1;
			}
			if (type == '4') {
				document.getElementById('page_now').value = totalPages;
			}
			
		
			roomsForm.submit();
		
		}
		
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
		 
			roomsForm.submit();
		}
	</script>
	<script type="text/javascript">
		function subForm() {
			var pageNow = '<s:property value="pb.pageNow"/>';
			var allPage = '<s:property value="pb.allPage"/>';
			var page_num = document.getElementById("pageNum");
			if (page_num < 0 || page_num > allPage) {
				alert("抱歉你输入有误!");
				return false;
			}
			pageForm.submit();
		}
	</script>
</head>

<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<s:form action="RoomPageRoomsAction.action" method="post"
				name="roomsForm">
				<span>
					房间号
					<input type="text" name="query.roomNum" id="type_name"
						value="<s:property value="query.roomNum"/>">
					房间状态
					<s:select name="query.roomState_id" id="roomState_id"
							list="roomStateList" listKey="roomState_id" listValue="rsName"
							headerKey="0" headerValue="--请选择--" value="query.roomState_id"></s:select>
					房间类型
					<s:select name="query.roomType_id" id="type_id"
							list="roomTypeList" listKey="roomType_id" listValue="rtName"
							headerKey="0" headerValue="--请选择--" value="query.roomType_id"></s:select>
					<input type="button" value="查询" onclick="subQueryForm()" />
					<input type="hidden" name="pb.pageNow" id="page_now"
						value="<s:property value="pb.pageNow"/>" />
				</span>
			</s:form>
		</h3>
		<table width="800" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td>序号</td>
					<td>房间号</td>
					<td>房间状态</td>
					<td>房间类型</td>
					<td>房间系统编号</td>
					<td>备注</td>
					<td>基本操作</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pb.list" var="ri" status="ty">
					<tr id="<s:property value='#ri.room_id'/>">
						<td><s:property value="#ty.index+1" /></td>
						<td><s:property value="#ri.roomNum" /></td>
						<td><s:property value="#ri.roomState.rsName" /></td>
						<td><s:property value="#ri.roomType.rtName" /></td>
						<td><s:property value="#ri.roomSNum" /></td>
						<td><s:property value="#ri.roomRemark" /></td>
						<td>
							<a href="javascript:void(0)" onclick="moduleDel(<s:property value='#ri.room_id'/>);">删除</a>
							<a href="javascript:void(0)" onclick="moduleWin('update', <s:property value='#ri.room_id'/>);">修改</a>
						</td>
					</tr>
				</s:iterator>
				<tr align="center">
					<td colspan="7">
						<a href="javascript:void(0)" onclick="moduleWin('add');">添加房间信息</a>
					</td>
				</tr>
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