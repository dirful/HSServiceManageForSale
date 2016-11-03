<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>项目信息采集模板</title>
	<link rel="stylesheet" type="text/css" href="frame/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="frame/easyui/themes/icon.css">
	
	<script src="frame/easyui/jquery.min.js"></script>
	<script src="frame/easyui/jquery.easyui.min.js"></script>
	<script src="frame/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="frame/easyui/validata.js"></script>
	<script type="text/javascript" src="frame/extUtil.js"></script>
	<script type="text/javascript" src="frame/easyui/extEasyUI.js"></script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
	<style type="text/css">
		.formLabel {
			width: 100px;
			text-align: left;
			float: left;
			height: 30px;
			line-height: 30px; 
			font-size:18px;	
		}
		
		.formInput {
			padding: 0 5px;
			width: 200px;
			text-align: left;
			float: left;
			height: 30px; 
		}
		
		.formTextArea {
			padding: 0 5px;
			width: 200px;
			text-align: left;
			float: left;
			margin-buttom:10px;
		}
		
		
		#dlg .fitem {
			margin:5px auto;
			width:400px ;	
			height:40px;
		}
	</style>
</head>

<body>

	<a class="easyui-linkbutton" iconCls="icon-add" onclick="add()">新增项目</a>

	<!-- 搜索框 -->
	<div class="searchArea" style="float:right;margin-top:3px;">
		日期：从<input class="easyui-datetimebox textbox" id="FORTIME" style="width:150px">
		到<input class="easyui-datetimebox textbox" id="SECTIME" style="width:150px">
		名称：<input class="easyui-validatebox textbox" id="NAME" style="width:150px"> 
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="sear()">查询</a>
	</div>
	
	<!-- 数据表格 -->
	<div style="position: relative;top:20px;">
		<table id="dg" style="width:auto;height:350px;" toolbar="#toolbar"></table>
	</div>
	
	<!-- 操作按键 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true"	onclick="viewTemplet()">查看 </a> 
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTemplet()">编辑</a> 
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="info()">信息</a> 
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"	onclick="removeTemplet()">删除 </a>	 
		<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="allRows()">刷新 </a>
	</div> 

	<script src="module/ProjectManagement/ProjectInfoTemplet.js"></script>
</body>
</html>