<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增日志模板</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>
 <style  type="text/css">
	#top{
		height:40px;
		background-color:#F5F5F5;
		border:1px solid #B7B7B7;}
	.back{margin:10px;}
	.type{
		border:1px solid #B7B7B7;
		height:120px;
		margin:2% 0;
		width:70%;}
	.inner{
		margin-top:15px;
		margin-left:30%}
	.div{
		margin-top:10px;
		padding-left:10px;}
</style>
   <div id="top">
       <a href="module/ProjectSubjectManagement/jsp/ProjectSubjectManagement.jsp"><button class="back">返回</button></a>
     <a style="float:right">
       <button class="back">取消</button>
       <button class="back">保存</button>
     </a>
   </div>
   <div class="type">
       <div style="margin:10px;">请选择类别：</div>
       <div class="inner"> <span>大类：</span><select><option></option></select></div>
       <div class="inner" style="margin-bottom:2%"> <span>小类：</span><select><option></option></select></div>
   </div>
   <div>
    <div class="div"><a>编&nbsp;&nbsp;码：</a><input type="text"/></div>
    <div class="div"><a>名&nbsp;&nbsp;称：</a><input type="text"/></div>
    <div class="div"><a>描&nbsp;&nbsp;述：</a><input type="text"/></div>
    <div class="div"><a>创建时间：</a><input type="text"/></div>
    <div class="div"><a>配置路径：</a><input type="text"/></div>
   </div>
   <div class="div" style="border:1px solid #B7B7B7;height:300px;">
       <div style="margin:10px;">销售日志模板内容：</div>
       <table border="1px solid #B7B7B7"> 
        <caption> 拜访客户情况</caption>
	       <tr>
	           <th>拜访客户名称</th>
	           <th>拜访联系人</th>
	           <th>拜访目的</th>
	           <th>商谈内容</th>
	           <th>拜访结果</th>
	       </tr>
           <tr>
	           <td></td>
	           <td></td>
	           <td></td>
	           <td></td>
	           <td></td>
           </tr>
              <tr>
	           <td></td>
	           <td></td>
	           <td></td>
	           <td></td>
	           <td></td>
           </tr>
       </table>
      
   
   </div>
 </body>
</html>
