<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改房间信息界面</title>



</head>

<body>


	<div id="content">

		<table width="800" cellspacing="0" cellPadding="0" id="listTable">
			<s:form action="updateRoomsAction.action" method="post">
				<tr>

					<td>房间号</td>
					<td><s:textfield name="rooms.roomNum" />
					</td>
					<td>房间状态</td>
					<td><s:select name="roomState.roomState_id"
							list="roomStateList" listKey="roomState_id" listValue="rsName"
							headerKey="0" headerValue="--请选择--"></s:select></td>
				</tr>

				<tr>
					<td>房间类型</td>
					<td><s:select name="roomType.roomType_id" list="roomTypeList"
							listKey="roomType_id" listValue="rtName" headerKey="0"
							headerValue="--请选择--"></s:select>
					</td>
					<td>房间系统编号</td>
					<td><s:textfield name="rooms.roomSNum" />
					</td>
				</tr>

				<tr>
					<td>房间备注：</td>
					<td><s:textfield name="rooms.roomRemark" />
					</td>
					<s:hidden name="rooms.room_id"></s:hidden>
					<td colspan="2"><s:submit value="保存" /><s:reset value="重置" />
					</td>
				</tr>


			</s:form>
		</table>
	</div>



</body>
</html>
