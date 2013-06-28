<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>房间记录查询</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

		<script type="text/javascript">
var highlightcolor = '#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var clickcolor = '#51b2f6';
function changeto() {
	source = event.srcElement;
	if (source.tagName == "TR" || source.tagName == "TABLE")
		return;
	while (source.tagName != "TD")
		source = source.parentElement;
	source = source.parentElement;
	cs = source.children;
	//alert(cs.length);
	if (cs[1].style.backgroundColor != highlightcolor && source.id != "nc"
			&& cs[1].style.backgroundColor != clickcolor)
		for (i = 0; i < cs.length; i++) {
			cs[i].style.backgroundColor = highlightcolor;
		}
}

function changeback() {
	if (event.fromElement.contains(event.toElement)
			|| source.contains(event.toElement) || source.id == "nc")
		return

	
			if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
			//source.style.backgroundColor=originalcolor
				for(i=0;i<cs.length;i++){
					cs[i].style.backgroundColor="";
				}
			}
			
			function  clickto(){
			source=event.srcElement;
			if  (source.tagName=="TR"||source.tagName=="TABLE")
			return;
			while(source.tagName!="TD")
			source=source.parentElement;
			source=source.parentElement;
			cs  =  source.children;
			//alert(cs.length);
			if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
			for(i=0;i<cs.length;i++){
				cs[i].style.backgroundColor=clickcolor;
			}
			else
			for(i=0;i<cs.length;i++){
				cs[i].style.backgroundColor="";
			}
			}
		</script>

	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="images/tab_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30">
								<img src="images/tab_03.gif" width="12" height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46%" valign="middle">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="5%">
														<div align="center">
															<img src="images/tb.gif" width="16" height="16" />
														</div>
													</td>
													<td width="40%" class="STYLE1">
														<span class="STYLE3">你当前的位置</span>：[房间信息查询]
													</td>




													<%--<td width="40%" class="STYLE1">
														
														<script type="text/javascript">
function subQueryForm() {
	var room_no = document.getElementById("room_no");
	if (room_no == "") {
		return false;
	}
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
														<form action="RoomPageRoomAction.action"  method="post"
															name="queryForm">

															房间编号
															<input type="text" name="r.roomNo" id="room_no"
																value="<s:property value="r.roomNo"/>">
															<input type="button" value="查询" onclick="subQueryForm()" />
															<input type="hidden" name="pb.pageNow" id="page_now"
																value="<s:property value="pb.pageNow"/>" />
														</form>
												
													</td>
												--%></tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="images/tab_07.gif" width="16" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
<!---->



			<!---->
				<script type="text/javascript">
function subQueryForm() {
	var room_no = document.getElementById("room_no");
	if (room_no == "") {
		return false;
	}
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
			<tr><td><table>
			<s:form action="RoomPageRoomAction.action" method="post" name="queryForm">
			<tr>
			
			<td>房间编码查询：<input name="query.roomNo" id="room_no" value="<s:property value="query.roomNo"/>"/></td>
			<td>房间类型查询：	<s:select list="typeList" name="query.typeId" listKey="typeId"
				listValue="typeName" headerKey="0" headerValue="--请选择--"  value="query.typeId" ></s:select></td>
			<td>房间状态查询<s:select list="stList" name="query.statueId" listKey="statueId"
				listValue="statueName"  headerKey="0" headerValue="--请选择--" value="query.statueId"></s:select></td>
			<td><input type="submit" value="查询" onclick="subQueryForm()"/>
			<input type="hidden" name="pb.pageNow" id="page_now"
																value="<s:property value="pb.pageNow"/>" />
			</td>
			</tr>
			
			
			</s:form>
			</table></td></tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8" background="images/tab_12.gif">
								&nbsp;

							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">



									<tr>
										<td width="3%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">房间序号</span>
											</div>
										</td>
										<td width="5%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">房间门牌号</span>
											</div>
										</td>
										<td width="14%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">房间位置</span>
											</div>
										</td>
										<td width="18%" background="images/bg.gif" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">房间类型</span>
											</div>
										</td>
										<td width="23%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1">房间状态</span>
											</div>
										</td>
										<td width="7%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF" class="STYLE1">
											<div align="center">
												备注
											</div>
										</td>

										<td width="15%" height="22" background="images/bg.gif"
											bgcolor="#FFFFFF" class="STYLE1">
											<div align="center">
												基本操作
											</div>
										</td>
									</tr>
									<!-- 加入迭代器 -->

									<s:iterator value="pb.list" var="r" status="st">
										<tr>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center" class="STYLE1">
													<div align="center">
														<s:property value="#st.index+1" />
													</div>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><s:property value="#r.roomNo" />
													</span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><s:property
															value="#r.roomPlace" /> </span>
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><s:property
															value="#r.type.typeName" /> </span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><s:property
															value=" #r.roomstatue.statueName" /> </span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><s:property value=" #r.remark" />
													</span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<a
														href="delRoomAction.action?r.roomId=<s:property value="#r.roomId"/>">删除</a>
													<a
														href="getRoomRoomAction.action?r.roomId=<s:property value="#r.roomId"/>">修改</a>
												</div>
											</td>
										</tr>
									</s:iterator>
								</table>
							</td>
							<td width="8" background="images/tab_15.gif">
								&nbsp;

							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35" background="images/tab_19.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35">
								<img src="images/tab_18.gif" width="12" height="35" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="STYLE4">
											&nbsp;&nbsp;共有
											<s:property value="pb.totalCount" />
											条记录，当前第
											<s:property value="pb.pageNow" />
											/
											<s:property value="pb.allPage" />
											页
										</td>
										<td>
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<script type="text/javascript">
function toPage(type) {
	var pageNow = '<s:property value="pb.pageNow"/>';
	var allPage = '<s:property value="pb.allPage"/>';

	var page_now = document.getElementById("page_now");

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
		page_now.value = parseInt(allPage);
	}

	queryForm.submit();

}
</script>
												<tr>
													<td width="60">
														<!-- 如果不是首页则提供首页的链接,如果是首页则不提供链接,以下类似 -->
														<s:if test="pb.pageNow != 1">
												            [<a href="javascript:void(0)"
																onclick="toPage('1')">首页</a>]     
												        </s:if>
														<s:else>
												            [首页]
												        </s:else>
													</td>
													<td width="80">
														<s:if test="pb.pageNow>1">
															[<a href="javascript:void(0)" onclick="toPage('2')">上一页</a>]  
												        </s:if>
														<s:else>
												            [上一页] 
												        </s:else>
													</td>
													<td width="80">
														<s:if test="pb.allPage>pb.pageNow">
															[<a href="javascript:void(0)" onclick="toPage('3')">下一页</a>]
												        </s:if>
														<s:else>
												            [下一页] 
												        </s:else>
													</td>
													<td width="80">
														<s:if test="pb.allPage != pb.pageNow">
														 	[<a href="javascript:void(0)" onclick="toPage('4')">末页</a>]
												        </s:if>
														<s:else>
												            [末页]
												        </s:else>
													</td>
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
													<td width="100">
														<div align="center">
															<span class="STYLE1">转到第 <input name="pb.pageNow"
																	id="pageNum" type="text" size="4"
																	style="height: 20px; width: 20px; border: 1px solid #999999;" />
																页 </span>
														</div>
													</td>
													<td width="40">
														<img src="images/go.gif" width="37" height="15"
															onclick="subQueryForm()" />
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="images/tab_20.gif" width="16" height="35" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<a href="addJspRoomAction.action">添加</a>
	</body>
</html>
