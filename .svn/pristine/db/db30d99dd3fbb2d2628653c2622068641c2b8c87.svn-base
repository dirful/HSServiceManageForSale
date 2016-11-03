<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>保存修改分类信息</title>
</head>
<body>
<form id="join" method="post">
  <div style="text-align:center;margin-top:5%;font-size:20px;">
     <div style="margin-top:3%;display:none">ID:<input type="text" name="ID" class="easyui-validatebox" validType="ID"></div>
     <div style="margin-top:3%;">&nbsp;名称:<input type="text" name="DESCRIPTION" class="easyui-validatebox" validType="name" required="true"></div>
     <div style="margin-top:3%;">&nbsp;编码:<input type="text" name="CODE" class="easyui-validatebox" required="true"></div>
     <div style="margin-top:3%;">父分类:<input type="text" name="NAME" class="easyui-validatebox" required="true"></div>
     <div style="margin-top:3%;">&nbsp;状态:<input type="text" name="STATE" class="easyui-validatebox" required="true"></div>
   </div>
</form>
	<script type="text/javascript">
		var form = $("#join");
		$(function() {
			if ($.processType() == "edit" && $.dialogParameter()) {
				form.form('load', $.dialogParameter());
			}
		});
	</script>
</body>
</html>