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
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<span> <s:form action="goodsTypePagegoodsTypeAction.action"
					method="post" name="queryForm">
			商品类型名称查询：
			<select name="goodsType.cdt_id">
				<option value="0">--请选择商品类型名称--</option>
				<s:iterator value="gtList">
					<option value="<s:property value='cdt_id'/>"><s:property value="goodsType"/></option>
				</s:iterator>
				</select> 
				<input type="submit" value="查询" onclick="subQueryForm()" />
				<input type="hidden" name="pb.pageNow" id="page_now"
						value="<s:property value="pb.pageNow"/>" />
				</s:form> </span>
		</h3>
		<table width="820" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
				<tr>
					<td>房间序号</td>
					<td>类型名称</td>
					<td>商品类型描述</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pb.list" var="r" status="st">
					<tr id="<s:property value='#r.cdt_id'/>">
						<td><s:property value="#st.index+1" />
						</td>
						<td><s:property value="#r.goodsType" />
						</td>
						<td><s:property value="#r.goodsTypeDes" />
						</td>

						<td>
							<a href="javascript:void(0)" onclick="moduleWin('view', <s:property value='#r.cdt_id'/>);">查看</a>
							<a href="javascript:void(0)" onclick="moduleDel(<s:property value='#r.cdt_id'/>);">删除</a>
							<a href="javascript:void(0)" onclick="moduleWin('update', <s:property value='#r.cdt_id'/>);">修改</a>
						</td>
					</tr>
				</s:iterator>
				<tr align="center">
					<td colspan="7"><a href="javascript:void(0)"
						onclick="moduleWin('add',<s:property value='#r.cdt_id'/>);">添加商品类型</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="bottom">
		 共有 <s:property value="pb.totalCount" />条记录，当前第 <s:property value="pb.pageNow" />/<s:property value="pb.allPage" /> 页
		<!-- 如果不是首页则提供首页的链接,如果是首页则不提供链接,以下类似 --> 
		<s:if test="pb.pageNow != 1"> 
		[<a href="javascript:void(0)" onclick="toPage('1')" class="pager_link">首页</a>]     
		</s:if> 
		<s:else> [首页] </s:else>
		
		<s:if test="pb.pageNow>1">
		[<a href="javascript:void(0)" onclick="toPage('2')" class="pager_link">上一页</a>]  
		</s:if> 
		<s:else> [上一页]  </s:else>
		
		<s:if test="pb.allPage>pb.pageNow">
		[<a href="javascript:void(0)" onclick="toPage('3')" class="pager_link">下一页</a>]
		</s:if> <s:else> [下一页] </s:else>
		
		<s:if test="pb.allPage != pb.pageNow">
		[<a href="javascript:void(0)" onclick="toPage('4')" class="pager_link">末页</a>]
		</s:if> 
		<s:else> [末页] </s:else>
		<span>转到第 <input name="pb.pageNow" id="pageNum" type="text" size="4" />页</span>
		<img src="images/go.gif" width="37" height="15" onclick="subQueryForm()" />
	</div>
</body>
</html>