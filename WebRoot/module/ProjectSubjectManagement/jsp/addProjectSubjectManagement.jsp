<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>保存修改客户信息</title>
</head>
<body>
<style type="text/css">
.must{color:red;}
</style>
<form id="join" method="post">
  <div style="text-align:center;margin-top:5%;font-size:20px;">
     <div style="margin-top:3%;display:none">日志ID:<input type="text" name="ID" class="easyui-validatebox"></div>
     <div style="margin-top:3%;">日志名称:<input type="text" name="SaleLogName" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;display:none">日志编码:<input type="text" name="SaleLogTypeCode" class="easyui-validatebox" ></div>
     <div style="margin-top:3%;">&nbsp;任务量:<input type="text" name="Assignments" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;联系人:<input type="text" name="ContactID" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;签约量:<input type="text" name="ContractVolume" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;邮件量:<input type="text" name="Email" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;签单量:<input type="text" name="List" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;提交人:<input type="text" name="OfferorsID" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;电话量:<input type="text" name="Phone" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">审核流程:<input type="text" name="progress" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;&nbsp;目的:<input type="text" name="Purpose" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;汇款量:<input type="text" name="Receivableamount" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">客户姓名:<input type="text" name="CustomerName" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;&nbsp;结果:<input type="text" name="Results" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;&nbsp;状态:<input type="text" name="State" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;&nbsp;模板:<input type="text" name="TempletID" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">&nbsp;拜访量:<input type="text" name="Visit" class="easyui-validatebox" required="true"><span class="must">*</span></div>
     <div style="margin-top:3%;">商谈内容:<textarea name="Contents" class="easyui-validatebox" required="true"></textarea><span class="must">*</span></div>
   </div>
</form>
	<script type="text/javascript">
		var form = $("#join");
		$(function(){
			if ($.processType() == "edit"&& $.dialogParameter()){
				form.form('load', $.dialogParameter());
			}
		});
	</script>
</body>
</html>