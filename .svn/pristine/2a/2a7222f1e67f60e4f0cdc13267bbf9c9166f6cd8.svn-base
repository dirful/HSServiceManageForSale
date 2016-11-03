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

	<title>用户管理界面</title>

	<link rel="stylesheet" type="text/css" href="frame/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="frame/easyui/themes/icon.css">

	<script type="text/javascript" src="frame/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="frame/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="frame/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="frame/extUtil.js"></script>
		<script type="text/javascript" src="frame/easyui/extEasyUI.js"></script>
	<script type="text/javascript" src="module/quoInfoMana/js/quoInfoMana/Calendar3.js"></script>
	<script type="text/javascript" src="module/quoInfoMana/js/quoInfoMana/quoInfoManaUi.js"></script>
	<style type="text/css">
		.tree {
			margin : 10px 0 0 10px;
		}
		
		.searchArea {
			margin: 10px 0 10px 10px;
			display:inline-block;
		}
		.content {
			margin : 0;
		}
	</style>
</head>
<body>
	<div class="content">
		<div class = "searchArea" >
				用户名称: <input class="easyui-validatebox textbox" style="width:180px" id="userName"> 
				<a class="easyui-linkbutton" onclick="sear(1)" iconCls="icon-search">搜索</a>
		</div> 
		<div class = "searchArea" >
				时间: <input name="birthday" type="text" id="timeBefore" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"> 
		</div>
		<div class = "searchArea" >
				<input name="birthday" type="text" id="timeAfter" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"> 
				<a class="easyui-linkbutton" onclick="sear(2)" iconCls="icon-search">搜索</a>
		</div>
	
		<table id="dg" style="height:300px;" toolbar="#toolbar">
			
		</table>
		<div id="toolbar">
<!-- 			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">新增</a>  -->
<!-- 			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>  -->
<!-- 			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">删除 </a>  -->
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="allRows()">刷新</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="view()">查看</a>
		</div>
	</div>
</body>
</html>
