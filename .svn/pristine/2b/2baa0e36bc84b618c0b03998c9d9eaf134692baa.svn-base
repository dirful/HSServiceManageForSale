<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>模板管理</title>
    
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="frame/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="frame/easyui/themes/icon.css">  
		<script  src="frame/easyui/jquery.min.js"></script>
		<script  src="frame/easyui/jquery.easyui.min.js"></script>
		<!-- sypro对easyUi的扩展 -->
		<script  src="frame/easyui/extEasyUI.js"></script>
		<!-- 支持中文 -->
		<script  src="frame/easyui/locale/easyui-lang-zh_CN.js"></script>
		<!-- 对easyUI验证扩展 -->
  		<script  src="frame/easyui/validata.js"></script>
  		<!-- 对jquery扩展 -->
		<script type="text/javascript" src="frame/extUtil.js"></script>
		<!-- 上传组件 -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <script language="javascript" type="text/javascript" src="frame/fileupload/jquery.ui.widget.js"></script>
		<script language="javascript" type="text/javascript" src="frame/fileupload/jquery.iframe-transport.js"></script>
		<script language="javascript" type="text/javascript" src="frame/fileupload/jquery.fileupload.js"></script>   
 <style type="text/css">
  #outer{margin:10px}
  .add{
	border:1px solid green;
	margin:10% 1% 0 0;
	border-width:40px;
	border-height:10px;
	}
	.data{margin:5px}
	.border{margin:6px}
</style>
  </head>
  
 <body>
 <div id="dataGrid">
    <table id="dg" toolbar="#toolbar">
		</table>
	   <div id="toolbar">
	        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
	        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editer()">编辑</a>
	        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true"onclick="removable()">删除</a>
	    	<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="allRole()">刷新</a>
	     </div>
    </div>

 </body>
</html>
