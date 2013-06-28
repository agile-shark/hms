<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
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
					url = "<%=request.getContextPath() %>/toAddAccountJspAccountAction.action";
					break;
				case 'update':
					url = "<%=request.getContextPath() %>/toUpdateAccountJspAccountAction.action?account.account_id="+id;
					break;
				case 'view':
					url = "<%=request.getContextPath() %>/toLoadAccountJspAccountAction.action?account.account_id="+id;
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
			if(window.confirm("删除用户，需要谨慎，您确定?")){
				var url = "<%=request.getContextPath() %>/deleteAccountAction.action?account.account_id="+id;
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
		
			accountForm.submit();
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
		
			accountForm.submit();
		}
	</script>
</head>
<body>
	<div id="content">
		<h3 class="admin_link_bar">
			<span>
				<form action="toShowUserAccountAction.action" method="post"
					name="accountForm">
					用户姓名<input type="text" name="query.user_name"
						value="<s:property value="query.user_name"/>"> 
					帐号<input type="text" name="query.account"
						value="<s:property value="query.account"/>"> 
					部门名称<input type="text" name="query.dept_name"
						value="<s:property value="query.dept_name"/>"> 
					<input type="button" value="go" onclick="subQueryForm()"> 
					<input type="hidden" name="pb.pageNow" id="page_now" value="<s:property value="pb.pageNow"/>">
				</form> 
			</span>
		</h3>
		
		<table width="800" cellspacing="0" cellPadding="0" id="listTable">
			<thead>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>帐号</td>
				<td>部门</td>
				<td>操作</td>
			</tr>
			</thead>
			<tbody>
				
				<s:iterator value="pb.list" var="ac" status="st">
					<tr id="<s:property value='#ac.account_id'/>">
						<td><s:property value="#ac.account_id"/>
						</td>
						<td><s:property value="#ac.user_name" />
						</td>
						<td><s:property value="#ac.account" />
						</td>
						<td><s:property value="#ac.deptDepartment.dept_name" />
						</td>
						<td>
							<a href="javascript:void(0)" onclick="moduleWin('view', <s:property value='#ac.account_id'/>);">查看</a>
							<a href="javascript:void(0)" onclick="moduleDel(<s:property value='#ac.account_id'/>);">删除</a>
							<a href="javascript:void(0)" onclick="moduleWin('update', <s:property value='#ac.account_id'/>);">修改</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="5" align="center">
						<a href="javascript:void(0)" onclick="moduleWin('add', null);">新增用户</a>
					</td>
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