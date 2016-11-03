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

<title>保存修改用户</title>

   
    <link rel="stylesheet" type="text/css" href="frame/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="frame/easyui/themes/icon.css">

	<script  src="frame/easyui/jquery.min.js"></script>
	<script  src="frame/easyui/jquery.easyui.min.js"></script>
	<script  src="frame/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	
</head>

<body>
<style type="text/css">
	#leftForm {
		width: 250px;
		float: left;
		margin-left: 10px;
		margin-top: 30px;
	}
	
	#rightForm {
		width: 250px;
		float: right;
		/*margin-left: 20px;*/
		margin-top: 30px;
	}
	.formLabel{
		width:60px;
		text-align:right;
		float:left;
		height:20px;
		line-height:20px;
	}
	.formInput{
		text-align:left;
		float:right;
		height:20px;
	}
	.requiredMark{
	   color:red;
	}
	.fitem{
		height: 40px;
	}
	.myselect{
		width: 175px; !important
	}
	#quotedPriceDtaile{
	overflow: auto;
	display:block;
	height:100px;
	width: 200px;
    margin: 10px;
    border:none;
    background: #fff;
	}
	#quotedPriceDtaile>div{
		height: 18px;
	    width: initial;
	    border-bottom: none;
	}
	
	.details{
	    display: -moz-box;  /* Firefox */ 
	    display: -ms-flexbox;    /* IE10 */ 
	    display: -webkit-box;    /* Safari */  
	    display: -webkit-flex;    /* Chrome, WebKit */ 
	    display: box;  
	    display: flexbox;  
	    display: flex;
	    display:inline-box;
	    height:initial;
	    border-bottom:1px #000 solid;
	    -webkit-justify-content:space-between;
	    justify-content:space-between;
	    -webkit-box-pack:justify;
	    -webkit-flex-direction:row;
	    flex-direction: row;
	    -webkit-box-direction:normal;
	}
	.details>div{
		display: -moz-box;  /* Firefox */ 
	    display: -ms-flexbox;    /* IE10 */ 
	    display: -webkit-box;    /* Safari */  
	    display: -webkit-flex;    /* Chrome, WebKit */ 
	    display: box;  
	    display: flexbox;  
	    display: flex;
	    display:inline-box;
		-webkit-justify-content:space-between;
	    justify-content:space-between;
		height: 18px;
	    width: initial;
		-webkit-flex-direction: row;
	    flex-direction: row;
	    border:1px solid #A9A9A9;
	    flex:1;
	}
	input,.details>div{
		color:#898989;
	}
</style>
	<div id="dlg">
		<form id="fm" method="post">
			<div id="leftForm">
				<input type="hidden" name="ID" id="ID"> 
<!-- 				<input type="hidden" name="CREATTIME" id="CREATTIME"> -->
				<div class="fitem">
					<div class="formLabel">用户名称:</div>
					<div class="formInput">
						<input name="employeeName" id="employeeName" class="easyui-validatebox" > 
					</div>
					<div style="clear: both;"></div>
				</div>
				<div class="fitem">
					<div class="formLabel">状态:</div>
					<div class="formInput">
						<input name="stateName" id="stateName" class="easyui-validatebox" > 
					</div>
					<div style="clear: both;"></div>
				</div>
				<div class="fitem">
					<div class="formLabel">创建时间:</div>
					<div class="formInput">
						<input name="thisJoinTime" id="thisJoinTime" class="easyui-validatebox" > 
					</div>
					<div style="clear: both;"></div>
				</div>
								<div class="fitem">
					<div class="formLabel">报价细项:</div>
					<div class="formInput">
						<div name="quotedPriceDtaile" id="quotedPriceDtaile"></div>
					</div>
					<div style="clear: both;"></div>
				</div>
					<!-- 用户存储FileID -->
					<input name="ICON" id="picture" style="display: none;" />

		</form>
	</div>
	<script type="text/javascript" src="frame/ajaxfileupload.js"></script>
	<script type="text/javascript">;
	 	$(".formInput>input").attr("disabled","disabled");
	 	console.log(row);
	 	console.info($.processType());
	 	$("#employeeName").val(row.employeeName);
	 	$("#stateName").val(row.stateName);
	 	$("#thisJoinTime").val(row.thisJoinTime);

	 	$.ajax({
		type    : "POST",
		url     : "quotedPriceController/quoDetailsListBack.do",
		data    :{
			ID:row.ID
		},
		async   : false,
		success : function(myData){


		myData = $.parseJSON(myData);
		var detailsList;
		console.log(myData[0]);
		console.log(myData.length);
		var datailsListBack="";
			for(var i=0;i < myData.length; i++ ){
		datailsListBack = datailsListBack + "<div class='details'><div>"+myData[i].modelName+"</div><div>"+(myData[i].modelPrice/100).toFixed(2)+"￥</div></div>";
		}
		 	$("#quotedPriceDtaile").html(datailsListBack);
		}});
	 	
	</script>

</body>

</html>
