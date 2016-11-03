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
				<div class="formLabel"><label>项目编码:</label></div>
				<div class="formInput">
				     <input id="projectCode" name="projectCode" class="easyui-validatebox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>	          	
	        </div>

	        <div class="fitem">
				<div class="formLabel"><label>项目名称:</label></div>
				<div class="formInput">
				     <input id="projectName" name="projectName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	        </div>
	        
	        <div class="fitem">
				<div class="formLabel"><label>公司名称:</label></div>
				<div class="formInput">
				     <input id="companyName" name="companyName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	        </div>
	        
	        <div class="fitem">
				<div class="formLabel"><label>客户单位:</label></div>
				<div class="formInput">
				     <input id="consumerWorkPlace" name="consumerWorkPlace" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	        </div>

            <div class="fitem">
				<div class="formLabel"><label>联系人:</label></div>
				<div class="formInput">
				     <input id="contactsName" name="contactsName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>	     	   
	         
	          <div class="fitem">
				<div class="formLabel"><label>创建时间:</label></div>
				<div class="formInput">
				    <input id="createTime" name="createTime" class="easyui-datetimebox textbox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	          <div class="fitem">
				<div class="formLabel"><label>开始时间:</label></div>
				<div class="formInput">
				    <input id="startTime" name="startTime" class="easyui-datetimebox textbox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	          <div class="fitem">
				<div class="formLabel"><label>结束时间:</label></div>
				<div class="formInput">
				    <input id="endTime" name="endTime" class="easyui-datetimebox textbox" data-options="required:true"  style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>负责人:</label></div>
				<div class="formInput">
				     <input id="leaderName" name="leaderName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>模板名称:</label></div>
				<div class="formInput">
				     <input id="templetID" name="templetID" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>网址:</label></div>
				<div class="formInput">
				     <input id="webSite" name="webSite" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>项目类型:</label></div>
				<div class="formInput">
				     <input id="projectType" name="projectType" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
    	     <div class="fitem ">
				<div class="formLabel"><label>项目类型:</label></div>
				<div class="formInput">
				     <input id="projectType" name="projectType" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>所属行业:</label></div>
				<div class="formInput">
				     <input id="trade" name="trade" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>分类名称:</label></div>
				<div class="formInput">
				     <input id="typeName" name="typeName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         
	         <div class="fitem ">
				<div class="formLabel"><label>提交人:</label></div>
				<div class="formInput">
				     <input id="offerName" name="offerName" class="easyui-validatebox" data-options="required:true" style="width:200px;height:25px;"> 
	          	</div>
	         </div>
	         	         
	      </form>
	 </div>
	
	 <script type="text/javascript">
    
	 //将选中行的数据加载到此页面上			
        var parameter = $.dialogParameter();
        console.log(parameter);
        if(parameter!=null){
	   		$("#projectCode").val(parameter.projectCode);
	   		$("#projectName").val(parameter.projectName);
	   		$("#companyName").val(parameter.companyName);
	   		$("#consumerWorkPlace").val(parameter.consumerWorkPlace);
	   		$("#contactsName").val(parameter.contactsName);
	   		//创建时间
	   		//开始时间
	   		//结束时间
	   		$("#leaderName").val(parameter.leaderName);
	   		$("#templetName").val(parameter.templetName);
	   		$("#webSite").val(parameter.webSite);
	   		$("#projectType").val(parameter.projectType);
	   		$("#trade").val(parameter.trade);
	   		$("#typeName").val(parameter.typeName);
	   		$("#offerName").val(parameter.offerName);
	   			
   		}  		
    </script> 
  </body>
</html>
