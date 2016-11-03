var audittype=1;
var saleLogtype=1;
var qpID;
var resuledate;
var row=5;
var page=1;
var url="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/audit/html/audit.html";
var type=1;
var number=1;
var lastCheckUser=0;
$(document).ready(function(){
	//隐藏详情框
	var see_height=document.documentElement.clientHeight;
	document.getElementById("choose_examine_user_li").style.height=see_height-100+"px";
//	determineLogin();
	loadingstyle();
	loadingfunction();
	// 初次默认加载我审核
	myaudit(row,1);
	$(window).scrollTop(0);
	$(".head_part").click(function() {
		if (!$(this).hasClass("head_activity")) {
			$(this).addClass("head_activity");
		}
		$(this).siblings().removeClass("head_activity");
	});
	// 上拉加载
//	$(window).scroll(function(){
//		if($(document).scrollTop() >= $(document).height() - $(window).height()){
//			page++;
//			if(audittype == 1){
//				myaudit(row,page);
//			}else if(audittype == 2){
//				apply(0,row,page);
//			}else{
//				apply(1,row,page);
//			}
//		}
//	});
	$('#center').dropload({
	    scrollArea : window,
	    loadDownFn : function(me){
	                setTimeout(function(){
	                	page++;
	        			if(audittype == 1){
	        				myaudit(row,page);
	        			}else if(audittype == 2){
	        				apply(0,row,page);
	        			}else{
	        				apply(1,row,page);
	        			}
	                    me.resetload();
	                },500);
	            }
	});
});
//判断是否登录
function determineLogin(){
	$.ajax({
		async: false,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../employeeController/determineLogin.do",
		data: {url:url}
	});
}
//各种响应样式
function interactionstyle(){
	var i=0;
	if($("#ls_s").html()=="...."){
		$("#ls_s").empty();
	}
	$("#ls_s").append(".");
	setTimeout("interactionstyle()", 1000);
}
function loadingstyle(){
	$("#loading").css("margin", (($(window).height()-25)*0.5-35)+"px auto");
}
function loadingfunction(){
	interactionstyle();
}
function bgdivload(num){
	if(num == 1){
		$("#backgound_div").show();
		$("body").css("overflow","hidden");
	}else{
		$("#backgound_div").hide();
		$("body").css("overflow","auto");
	}
}
function rddivload(num){
	if(num == 1){
		$("#resultdetails").show();
	}else{
		$("#resultdetails").hide();
	}
}
function loadload(num){
	if(num == 1){
		$("#loading").show();
	}else{
		$("#loading").hide();
	}
}
function addivload(num){
	if(num == 1){
		$("#approvaldetails").show();
		document.body.style.overflow = "hidden";
	}else{
		$("#approvaldetails").hide();
		document.body.style.overflow = "auto";
	}
}
function showauditprompt(message){
	console.info("显示:"+message);
	$(".ap_inside").empty();
	$(".ap_inside").append(message);
	$("#auditprompt").fadeIn(500);
	setTimeout("hideauditprompt()", 2000);
}
function hideauditprompt(){
	console.info("隐藏");
	$("#auditprompt").fadeOut(1000);
}
//操作信息提示
function resuletype(type){
	if(type == 1){
		return "亲！没有了！";
	}else if(type == 2){
		return "该审批消息已经审批结束！";
	}else if(type == 3){
		return "该审批消息已经被同级人员审批！";
	}else if(type == 4){
		return "该审批消息已经被撤回！";
	}else if(type == 5){
		return "操作失败！";
	}else if(type == 6){
		return "操作成功！";
	}else if(type == 7){
		return "网络出现问题啦！";
	}else if(type == 8){
		return "响应超时 请重试！";
	}else if(type == 9){
		return "服务器在开小差！";
	}else if(type == 10){
		return "未知错误";
	}else if(type == 11){
		return "抄送需要选择审核人";
	}
}
// 加载审批信息
	//报价
function loadaudit(number){
	page=1;
	$("#auditlist").empty();
	if(number == 1){
		console.info("我审核");
		audittype=1;
		myaudit(row,1);
		return;
	}
	if(number == 2){
		console.info("已审核");
		audittype=2;
		apply(0,row,page);
		return;
	}
	if(number == 3){
		console.info("待审核");
		audittype=3;
		apply(1,row,page);
		return;
	}
}
	//销售
function loadauditSaleLog(number){
	page=1;
	$("#auditlist").empty();
	if(number == 1){
		console.info("我审核销售");
		saleLogtype=1;
		myauditSaleLog(row,1);
//		saleLogMyaudit(row,1);
		return;
	}
	if(number == 2){
		console.info("已审核销售");
		saleLogtype=2;
		saleLogApply(0,row,page);
		return;
	}
	if(number == 3){
		console.info("待审核销售");
		saleLogtype=3;
		saleLogApply(1,row,page);
		return;
	}
}
//销售审核的内容
function myauditSaleLog(row,page){
	console.info("page:"+page);
	$.ajax({
		async: true,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../quotedPriceController/getMySaleLogByCheckName.do",
		data: {
			row: row,
			page: page
		},
		success: function(result){
			date=jQuery.parseJSON(result);
			console.log("取出了销售？");
			console.info(date);
			//加载界面交互
			appendmyaudit(date);
			if($("#auditlist").find("li").length != 0){
		if($("body").hasClass("sto")){
					$("body").removeClass("sto");
				}
			}else{

				$("body").addClass("sto");
				$(".sto").css("background-position",  "center "+($(window).height()-200)*0.5+"px");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			if(textStatus == "timeout"){
				showauditprompt(resuletype(8));
			}else if(textStatus == "error"){
				alert("加载失败");
				showauditprompt(resuletype(10));
			}else{
				showauditprompt(resuletype(7));
			}
		}
	});
}
// 0 1 2 3 4 5 6 7 8 9 10 row=5
// page=1,0~4,5*(1-1)~5*(1)-1
// 0 ~ 4
// page=2,5~9,5*(2-1)~5*(2)-1
// 5 ~ 9
// row*(page-1)~row*(page)-1
function appendappley(data){
//	console.info((row*(page1-1))+" ~ "+((row*page1)-1));
//	baginrow=row*(page1-1);
//	finalrow=(row*page1)-1;
//	if(data.length < baginrow){
//		page--;
//		showauditprompt(resuletype(1));
//		return;
//	}
	if(data.length == 0){
		page--;
		showauditprompt(resuletype(1));
		return;
	}
//	for(var i=baginrow,html="";(i<data.length && i<finalrow);i++){
	for(var i=0,html="";i<data.length;i++){
		html+='<li>'+
		'<div class="li_div">'+
			'<div class="li_of_1" onclick="getProcessDescription('+type+',\''+data[i].ID+'\')">'+
				'<a class="projecname">'+data[i].NAME+'</a>';
		if(data[i].STATE == "驳回"){
			html+='<a class="state content" style="color:red">'+data[i].STATE+'</a>';
		}else{
			html+='<a class="state content">'+data[i].STATE+'</a>';
		}
			html+='<div class="auditinfo">'+
					'<a class="content">项目名称：'+data[i].PROJECTNAME+'</a>'+
					'<a class="content">提交人：'+data[i].EMPLOYEENAME+'</a>'+
					'<a class="content">总金额：'+data[i].PRICE+'</a>'+
					'<a class="content">提交时间：'+data[i].JOINTIME+'</a>'+
					/* '<a class="content">审核详情：</a>'+ */
				'</div>'+
			'</div>'+
			'<div class="li_of_2">';
		if(data[i].STATE == "待审核" || data[i].STATE == "审核中"){
			html+='<div class="withdraw" onclick="operationQuotedPrice(3,\''+data[i].ID+'\')">'+
					'<a>撤回</a>'+
				'</div>';
		}
		html+='</div>'+
			'</div>'+
		'</li>';
	}
	$("#auditlist").append(html);
}
function saleLogApply(type,row,page){
//	loadload(1);
//	bgdivload(1);
	console.info("page:"+page);
	if(type == 0){
		condition=" (sl.state ='2' OR sl.state ='3' OR sl.state ='4') ";
	}else if(type == 1){
		condition=" (sl.state ='0' OR sl.state ='1') ";
	}
	$.ajax({
		async: true,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../quotedPriceController/getSaleLogByOfferorsID.do",
		data: {condition: condition,row: row,page: page},
		success: function(result){
			data=jQuery.parseJSON(result);
//			loadload(0);
//			bgdivload(0);
			appendappley(data);
//			console.info($("#auditlist").find("li").length == 0);
			if($("#auditlist").find("li").length != 0){
//				alert("not null")
				if($("body").hasClass("sto")){
					$("body").removeClass("sto");
				}
			}else{
//				alert("null");
				$("body").addClass("sto");
				$(".sto").css("background-position",  "center "+($(window).height()-200)*0.5+"px");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
//			loadload(0);
//			bgdivload(0);
			if(textStatus == "timeout"){
				showauditprompt(resuletype(8));
			}else if(textStatus == "error"){
				showauditprompt(resuletype(10));
			}else{
				showauditprompt(resuletype(7));
			}
		}
	});
}
function apply(type,row,page){
//	loadload(1);
//	bgdivload(1);
	console.info("page:"+page);
	if(type == 0){
		condition=" (qp.state ='2' OR qp.state ='3' OR qp.state ='4') ";
	}else if(type == 1){
		condition=" (qp.state ='0' OR qp.state ='1') ";
	}
	$.ajax({
		async: true,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../quotedPriceController/getQuotedPriceByOfferorsID.do",
		data: {condition: condition,row: row,page: page},
		success: function(result){
			data=jQuery.parseJSON(result);
//			loadload(0);
//			bgdivload(0);
			appendappley(data);
//			console.info($("#auditlist").find("li").length == 0);
			if($("#auditlist").find("li").length != 0){
//				alert("not null")
				if($("body").hasClass("sto")){
					$("body").removeClass("sto");
				}
			}else{
//				alert("null");
				$("body").addClass("sto");
				$(".sto").css("background-position",  "center "+($(window).height()-200)*0.5+"px");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
//			loadload(0);
//			bgdivload(0);
			if(textStatus == "timeout"){
				showauditprompt(resuletype(8));
			}else if(textStatus == "error"){
				showauditprompt(resuletype(10));
			}else{
				showauditprompt(resuletype(7));
			}
		}
	});
}
function appendmyaudit(data){
	console.log(1);
//	console.info((row*(page1-1))+" ~ "+((row*page1)-1));
//	baginrow=row*(page1-1);
//	finalrow=(row*page1)-1;
//	if(data.length < baginrow){
//		page--;
//		showauditprompt(resuletype(1));
//		return;
//	}
//	for(var i=baginrow,html="";(i<data.length && i<finalrow);i++)
	if(data.length == 0){
		page--;
		showauditprompt(resuletype(1));
		return;
	}
	for(var i=0,html="";i<data.length;i++){
		html+='<li>'+
		'<div class="li_div">'+
			'<div class="li_of_1" onclick="getProcessDescription('+type+',\''+data[i].ID+'\')">'+
				'<a class="projecname">'+data[i].NAME+'</a>';
		if(data[i].STATE == "驳回"){
			html+='<a class="state content" style="color:red">'+data[i].STATE+'</a>';
		}else{
			html+='<a class="state content">'+data[i].MYSTATE+'</a>';
		}
			html+='<div class="auditinfo">'+
					'<a class="content">项目名称：'+data[i].PROJECTNAME+'</a>'+
					'<a class="content">提交人：'+data[i].EMPLOYEENAME+'</a>'+
					'<a class="content">总金额：'+data[i].PRICE+'</a>'+
					'<a class="content">提交时间：'+data[i].JOINTIME+'</a>'+
					/* '<a class="content">审核详情：'+data[i].STATE+'</a>'+ */
				'</div>'+
			'</div>'+
			'<div class="li_of_2">';
//		if(data[i].MYSTATE == "1"){
//			html+='<div class="through" onclick="operationQuotedPrice(1,'+data[i].ID+')">'+
//					'<a>通过</a>'+
//				'</div>'+
//				'<div class="rejected" onclick="determineQuotedPrice(2,'+data[i].ID+')">'+
//					'<a>驳回</a>'+
//				'</div>';
//		}
		html+='</div>'+
			'</div>'+
		'</li>';
	}
	$("#auditlist").append(html);
}
function myaudit(row,page){
	//加载界面交互
//	loadload(1);
//	bgdivload(1);
	console.info("page:"+page);
	$.ajax({
		async: true,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../quotedPriceController/getMyQuotedPriceByCheckName.do",
		data: {
			row: row,
			page: page
		},
		success: function(result){
			date=jQuery.parseJSON(result);
			console.info(date);
			//加载界面交互
//			loadload(0);
//			bgdivload(0);
			appendmyaudit(date);
//			console.info($("#auditlist").find("li").length == 0);
			if($("#auditlist").find("li").length != 0){
//				alert("not null")
				if($("body").hasClass("sto")){
					$("body").removeClass("sto");
				}
			}else{
//				alert("null");
				$("body").addClass("sto");
				$(".sto").css("background-position",  "center "+($(window).height()-200)*0.5+"px");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			//加载界面交互
//			loadload(0);
//			bgdivload(0);
			if(textStatus == "timeout"){
				showauditprompt(resuletype(8));
			}else if(textStatus == "error"){
				alert("加载失败");
				showauditprompt(resuletype(10));
			}else{
				showauditprompt(resuletype(7));
			}
		}
	});
}
//
function determineQuotedPrice(type,quotedPriceID){
	$("#rd_content_textarea").val("");
	qpID=quotedPriceID;
	bgdivload(1);
	rddivload(1);
}
//驳回审批消息提示信息
function rd_determine(){
	se=confirm("您确定要驳回此消息吗");
	if(!se){
		return;
	}
	if(this.type==1){
		console.info("content:"+$("#rd_content_textarea").val());
		ajaxQuotedPrice(qpID,2,$("#rd_content_textarea").val()+"");
	}else if(this.type==2){
		console.log("驳回报销");
	}
	bgdivload(0);
	rddivload(0);
}
// 审批信息的提示信息
function operationQuotedPrice(type,quotedPriceID){
	var reason="";
	var message="";
	if(type == 1){
		message="通过";
		lastCheckUser=1;
	}else if(type == 3){
		message="撤回";
	}else if(type == 11){
		message="通过并抄送";
		lastCheckUser=0;
		type=1;
	}
	se=confirm("您确定要"+message+"此消息吗");
	if(!se){
		return;
	}
	if(this.type==1){
		console.log("报价的按钮");
		ajaxQuotedPrice(quotedPriceID,type,"");
	}else if(this.type==2){
		console.log("销售的按钮");
	}

	
}
function ajaxQuotedPrice(quotedPriceID,type,reason){
	var theCheckUserID = $("#choose_examine_user").attr("theCheckUserID");
	loadload(1);
	bgdivload(1);
	$.ajax({
		async: false,
		cache: false,
		type: "POST",
		timeout: 10000,
		url:"../../../quotedPriceController/operationQuotedPrice.do",
		data: {
				quotedPriceID: quotedPriceID,
				type: type,
				reason: reason,
				lastCheckUser:lastCheckUser,
				theCheckUserID:theCheckUserID
			},
		success: function(result){
			if(result == "2"){
				showauditprompt(resuletype(2));
			}else if(result == "3"){
				showauditprompt(resuletype(3));
			}else if(result == "4"){
				showauditprompt(resuletype(4));
			}else if(result == "true"){
				showauditprompt(resuletype(6));
				close_this(1);
			}else if(result == "11"){
				showauditprompt(resuletype(11));
			}else{
				showauditprompt(resuletype(5));
			}
			loadload(0);
			bgdivload(0);
			loadaudit(audittype);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			loadload(0);
			bgdivload(0);
			if(textStatus == "timeout"){
				showauditprompt(resuletype(8));
			}else if(textStatus == "error"){
				showauditprompt(resuletype(10));
			}else{
				showauditprompt(resuletype(7));
			}
		}
	});
}
// 查看审批流程信息
function getProcessDescription(theType,ID){
//	bgdivload(1);
//	addivload(1);
	console.log(ID);
	$("#operation_submit_box submit").show();
	$("#reason").empty();
	show_this(1);
	$("#across_this").attr("onclick","operationQuotedPrice(1,\'"+ID+"\')");
	$("#throw_this").attr("onclick","operationQuotedPrice(11,\'"+ID+"\')");
	$("#revoke_this").attr("onclick","operationQuotedPrice(3,\'"+ID+"\')");
	$("#feedback").attr("onclick","determineQuotedPrice(2,\'"+ID+"\')");
	$("#choose_examine_user").attr("theCheckUserID","");
	$("#choose_examine_user").html("请选择审核人");
	close_this(6);
	if(theType == 1 ){
		console.log("报价详情");
		$.ajax({
			async: false,
			cache: false,
			type: "POST",
			timeout: 10000,
			url:"../../../processDescriptionController/originalSearchForeign.do",
			data: { quotedPriceID: ID , sort: "ASC"},
			success: function(theresult){
				var newResult = jQuery.parseJSON(theresult);
				var result=newResult[0].remark;
				var theqp = newResult[0].qp;
				var theqpList = newResult[0].qpl;
				var thep = newResult[0].p;
				var theName = newResult[0].userName;
				var theIsMine = newResult[0].isMine;
				console.log("改变");
				console.log(theqp);
				console.log("获取我的审核状态");
				console.info(theqpList[0].JOINTIME);
				console.log("获取流程");
				console.info(thep);
				if(theIsMine=="1"){
					for(var i = 3; i <= 5;i++){
						close_this(i);
					}
					if(theqp.state == "2"){
						close_this(8);
					}
				}else if(theIsMine=="0"){
					if(theqp.state == "2" || theqpList[0].MYSTATE == "已审核" ){
						for(var i = 3; i <= 5;i++){
							close_this(i);
						}
						close_this(8);
					}else if(thep.type == "0"){
						close_this(4);
					}else if(thep.type == "1"){
						show_this(6);
					}
				}
				var html="";
				var remark="无";
				for(var i=0;i<result.length;i++){
					if(result[i].state == 0){
						if(result[i].remark != "" && typeof(result[i].remark) != "undefined"){
							remark=result[i].remark;
						}
						html+="<p>"+result[i].employeeName+"驳回了审批，"+"原因："+remark+"</p>";
					}else if(result[i].state == 2){
						html+="<p>"+result[i].employeeName+"通过了审批"+"</p>";
					}
				}
				if(html == ""){
					html="<p>无</p>";
				}

				loadload(0);
				bgdivload(0);
	            $("#operation_user").html(theName);
	            $("#operation_name_title").html("报价单名称：");
	            $("#operation_name").html(theqp.name);
	            $("#operation_price_name").html("总金额：");
	            $("#operation_price").html(theqp.price + "￥");
	            $("#operation_time").html(theqpList[0].JOINTIME);
				$("#reason").append(html);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				loadload(0);
				bgdivload(0);
				if(textStatus == "timeout"){
					showauditprompt(resuletype(8));
				}else if(textStatus == "error"){
					showauditprompt(resuletype(10));
				}else{
					showauditprompt(resuletype(7));
				}
			}
		});
	}else if(theType == 2){
		console.log("销售详情");
		console.log(ID);
		$.ajax({
			async: false,
			cache: false,
			type: "POST",
			timeout: 10000,
			url:"../../../processDescriptionController/theSaleLogOfOriginalSearchForeign.do",
			data: { saleLogID:ID , sort: "ASC"},
			success: function(theresult){
				var newResult = jQuery.parseJSON(theresult);
				var result=newResult[0].remark;
				var thesl = newResult[0].sl;
				var theslList = newResult[0].sll;
				var thep = newResult[0].p;
				var theName = newResult[0].userName;
				var theIsMine = newResult[0].isMine;
				console.log("改变");
				console.log(thesl.receivableamount);
				console.log("获取我的审核时间");
				console.info(theslList[0].JOINTIME);
				console.log("获取流程");
				console.info(thep);
				console.info("是否是自己的"+(theIsMine=="1"));
				if(theIsMine=="1"){
					for(var i = 3; i <= 5;i++){
						close_this(i);
					}
					if(thesl.state == "2"){
						close_this(8);
					}
				}else if(theIsMine=="0"){
					if(thesl.state == "2" || theslList[0].MYSTATE == "已审核" ){
						for(var i = 3; i <= 5;i++){
							close_this(i);
						}
						close_this(8);
					}else if(thep.type == "0"){
						close_this(4);
					}else if(thep.type == "1"){
						show_this(6);
					}
				}
				var html="";
				var remark="无";
				for(var i=0;i<result.length;i++){
					if(result[i].state == 0){
						if(result[i].remark != "" && typeof(result[i].remark) != "undefined"){
							remark=result[i].remark;
						}
						html+="<p>"+result[i].employeeName+"驳回了审批，"+"原因："+remark+"</p>";
					}else if(result[i].state == 2){
						html+="<p>"+result[i].employeeName+"通过了审批"+"</p>";
					}
				}
				if(html == ""){
					html="<p>无</p>";
				}

				loadload(0);
				bgdivload(0);
	            $("#operation_user").html(theName);
	            $("#operation_name_title").html("销售单名称：");
	            $("#operation_name").html(thesl.saleLogName);
	            $("#operation_price_name").html("回款量：");
	            $("#operation_price").html(thesl.receivableamount + "￥");
	            $("#operation_time").html(theslList[0].JOINTIME);
				$("#reason").append(html);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				loadload(0);
				bgdivload(0);
				if(textStatus == "timeout"){
					showauditprompt(resuletype(8));
				}else if(textStatus == "error"){
					showauditprompt(resuletype(10));
				}else{
					showauditprompt(resuletype(7));
				}
			}
		});
	}
	
}
//模块的显示与隐藏
function ad_return(){
	bgdivload(0);
	addivload(0);
}
function cancel(){
	bgdivload(0);
	rddivload(0);
}
//销售与报价之间的切换
	//第二行标签
function change_type(theType){
	type=theType;
	if(type==1){
		loadaudit(number);
	}else if(type==2){
		$("#auditlist").empty();
		console.info("销售日志");
		loadauditSaleLog(number);
	}else{
		showauditprompt(resuletype(10));
	}
}
	//第一行标签
function change_number(thenumber){
	number=thenumber;
	if(type==1){
		loadaudit(number);
	}else if(type==2){
		$("#auditlist").empty();
		console.info("销售日志");
		loadauditSaleLog(number);
	}else{
		showauditprompt(resuletype(10));
	}
}
//审核人列表的功能
function openTheExamineUserList(type){
	if(type == "1"){
		$.ajax({
			async: false,
			cache: false,
			type: "POST",
			timeout: 10000,
			url:"../../../quotedPriceController/getEmployeeNotMe.do",
			data: {},
			success: function(UserList){
				$("#choose_examine_user_li").empty();
				var theUserList = jQuery.parseJSON(UserList);
				console.log(theUserList);
				for(var o in theUserList){
					console.log(theUserList[o]);
					$("#choose_examine_user_li").append('<li><input type="radio" name="examine_user" userName="'+theUserList[o].employeeName+'" value="'+theUserList[o].ID+'">&nbsp;'+theUserList[o].employeeName+'&nbsp;</li>');
				}
				show_this(7);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				loadload(0);
				bgdivload(0);
				if(textStatus == "timeout"){
					showauditprompt(resuletype(8));
				}else if(textStatus == "error"){
					showauditprompt(resuletype(10));
				}else{
					showauditprompt(resuletype(7));
				}
			}
		});
	}else if(type == "2"){
		console.log("确认审核人3");
		var checkedUserID =  $('input:radio[name="examine_user"]:checked').attr("value");
		console.log($('input:radio[name="examine_user"]:checked').attr("userName"));
		$("#choose_examine_user").attr("thecheckuserid",checkedUserID);
		$("#choose_examine_user").html($('input:radio[name="examine_user"]:checked').attr("userName"));
		$("#choose_examine_user").css("color","#000");
		close_this(7);
	}else{
		showauditprompt(resuletype(10));
	}
}
//和关闭有关的方法
function close_this(type){
	switch(type){
	case 1:$("#operation_background").hide();console.log("关闭详情窗口");break;//关闭详情窗口
	case 2:$("#choose_examine_user_list").hide();console.log("关闭审核人窗口");break;//关闭选择审核人窗口
	case 3:$("#across_this").hide();console.log("关闭通过");break;
	case 4:$("#throw_this").hide();console.log("关闭抄送");break;
	case 5:$("#feedback").hide();console.log("关闭驳回");break;
	case 6:$("#choose_examine_user_titile,#choose_examine_user").hide();console.log("关闭选择审核人功能");break;
    case 7:$("#choose_examine_user_list").hide();console.log("关闭审核人列表");break;
    case 8:$("#revoke_this").hide();console.log("关闭撤销");break;
	default:console.log("关闭窗口失败,错误值");
	}
}
//和开启有关的方法
function show_this(type){
    switch(type){
    case 1:$("#operation_background").show();console.log("开启详情窗口");break;//关闭详情窗口
    case 2:$("#choose_examine_user_list").show();console.log("开启审核人窗口");break;//关闭选择审核人窗口
    case 3:$("#across_this").show();console.log("开启通过");break;
    case 4:$("#throw_this").show();console.log("开启抄送");break;
    case 5:$("#feedback").show();console.log("开启驳回");break;
    case 6:$("#choose_examine_user_titile,#choose_examine_user").show();console.log("开启选择审核人功能");break;
    case 7:$("#choose_examine_user_list").show();console.log("开启审核人列表");break;
    case 8:$("#revoke_this").show();console.log("开启撤销");break;
    default:console.log("开启窗口失败,错误值");
    }
}