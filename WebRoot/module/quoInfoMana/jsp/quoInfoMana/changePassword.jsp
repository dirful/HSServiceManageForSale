<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>修改密码</title>
</head>

<body>
	
	<style type="text/css">
		.content{
			display:inline-block;
			width: 68%;
		}
		.label{
		display:inline-block;
			width: 30%;
		}
	</style>
	<form id="userForm">
		<div style="display: none;">
			<div class="label"><label>ID:</label></div>
			<div class="content"><input type="text" value="${ID}" id="ID" name="ID"/></div>
		</div>
		<div>
			<div class="label"><label>登录名:</label></div>
			<div class="content"><input type="text" disabled="disabled" value="${LOGINNAME}"/></div>
		</div>
		<div>
			<div class="label"><label for="PASSWORD">新密码:</label></div>
			<div class="content"><input type="password" id="PASSWORD" name="PASSWORD"/></div>
		</div>
		<div>
			<div class="label"><label for="r_PASSWORD">重复密码:</label></div>
			<div class="content"><input type="password" id="r_PASSWORD" name="r_PASSWORD"/></div>
		</div>
	</form>
</body>

</html>
