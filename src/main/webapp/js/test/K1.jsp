<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <title>KindEditor JSP</title>
	<link rel="stylesheet" href="js/kindeditor-4.1.7/themes/default/default.css" />
	<link rel="stylesheet" href="js/kindeditor-4.1.7/plugins/code/prettify.css" />
	<script charset="utf-8" src="js/kindeditor-4.1.7/kindeditor-all.js"></script>
	<script charset="utf-8" src="js/kindeditor-4.1.7/lang/zh_CN.js"></script>
	<script charset="utf-8" src="js/kindeditor-4.1.7/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="kc.content"]', {
				cssPath : 'js/kindeditor-4.1.7/plugins/code/prettify.css',
				uploadJson : 'js/kindeditor-4.1.7/struts2_images_upload_json.jsp',
				fileManagerJson : 'js/kindeditor-4.1.7/struts2_images_manager_json.jsp',
				allowFileManager : true,
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<form name="example" method="post" action="addKCAction.action">
		标题:<input type="text" name="kc.name">
		<textarea name="kc.content" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
</body>
</html>
