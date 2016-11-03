<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmployee.jsp' starting page</title>
    
	<!-- <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">
#dlg label {margin-left:40px;}
#dlg input{height:30px;width:180px;}

</style>
</head>
  
  <body>
   <div id="dlg">
		<form id="fm" method="post">
  
            <div class="fitem" >
				<div class="formLabel"><label>模板编码:</label></div>
				<div class="formInput">
				     <input id="TEMPLETCODE" name="TEMPLETCODE" class="easyui-validatebox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>	          	
	        </div>

	        <div class="fitem">
				<div class="formLabel"><label>模板名称:</label></div>
				<div class="formInput">
				     <input id="TEMPLETNAME" name="TEMPLETNAME" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	        </div>
	        
	        <div class="fitem">
				<div class="formLabel"><label>创建时间:</label></div>
				<div class="formInput">
				    <input id="CREATETIME" name="CREATETIME" class="easyui-datetimebox textbox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	        
	        <!-- <div class="fitem">
				<div class="formLabel"><label>创建人:</label></div>
				<div class="formInput">
				     <input id="CREATEMAN" name="CREATEMAN" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	        </div> -->

            <div class="fitem" style="height:170px">
				<div class="formLabel"><label>模板说明:</label></div>
				<div class="formTextArea">
	          		<textarea id="DESCRIPTION" name="DESCRIPTION" class="easyui-validatebox" data-options="required:true"  rows="10" cols="26" ></textarea>
	          	</div>
	         </div>	     	   
    
	         <!-- <div class="fitem" style="height:170px">
				<div class="formLabel"><label>备注:</label></div>
				<div class="formTextArea">
	          		<textarea id="REMARKS" name="REMARKS" class="easyui-validatebox" data-options="required:true"  rows="10" cols="26"></textarea>
	          	</div>
	         </div>
 -->	               	         
	      </form>
	 </div>
	
	 <script type="text/javascript">
    
	 //将选中行的数据加载到此页面上			
        var parameter = $.dialogParameter();
        console.log(parameter);
        if(parameter!=null){
	   		$("#TEMPLETCODE").val(parameter.TEMPLETCODE);
	   		$("#TEMPLETNAME").val(parameter.TEMPLETNAME);
	   		$("#CREATETIME").val(parameter.CREATETIME);
	   	//	$("#CREATEMAN").val(parameter.CREATEMAN);
	   		$("#DESCRIPTION").val(parameter.DESCRIPTION);
	   	//	$("#REMARKS").val(parameter.REMARKS);	
   		} 
             
    </script> 
  </body>
</html>
