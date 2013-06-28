<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
function exitWin(obj){
	if(window.confirm("您确定要退出该系统吗？")){
		window.location.href="exit.jsp"
	}
}



</script>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<div id="top">
	<div id="topIntro">
		<span id="logo"></span>
		<span id="user_operator">
			<a href="<%=request.getContextPath()%>/index"  target="_blank">网站首页</a>
			|<a href="<%=request.getContextPath()%>/admin/user/showSelf"  target="content">查询个人信息</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updateSelf"  target="content">修改个人信息</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updatePwd"  target="content">修改密码</a>
			| <a href="javascript:void(0)" onclick="exitWin(this)" target="_parent" class="logout">退出系统</a>
		</span>
	</div>
	<div id="remind">
		<span id="showDate">,欢迎[<s:property value="#session.user_session.user_name"/> -- <s:property value="#session.user_session.deptDepartment.dept_name"/>]光临如家客房后台管理系统。
		</span>
	</div>
</div>
