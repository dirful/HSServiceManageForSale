var page = 1;
var row = 5; 
var evalData="";//保存取出的信息
var thebody="";//
var total = 0;
$(document).ready(start());
function start(){
	thebody = "";
	$.ajax({
		type    : "POST",
		url     : "../../quotedPriceController/getQuotedPriceInfo.do",
		data    :{
			page:page,
			row:row
		},
		async   : false,
		success : function(data){
			console.log($.parseJSON(data));
		evalData = $.parseJSON(data)[0].list;
		total = $.parseJSON(data)[0].total;
		console.log(total);
		if(evalData.length > 0){
			for(var a = 0;a < evalData.length; a++){
				var date = new Date(evalData[a].joinTime.time);
				var time = date.getFullYear()+"-"+(date.getMonth()*1+1*1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() ;
				thebody = thebody +
				'<div id="num' + evalData[a].ID + '">'+
			 	'<div>'+
			 		'<img class="openDetails" thisNum="'+evalData[a].ID+'"  src="img/donotknow.png"></img>'+
//			 		'<img src="img/change.png">'+
//			 		'</img><img class="delet" deID="'+evalData[a].ID+'" src="img/delete.png"></img>
			 		'<img class="add" src="img/add.png"></img>'+
			 	'</div>'+
			 	'<table>'+
			 		'<tr>'+
			 			'<td>报价单编码</td>'+
			 			'<td>'+evalData[a].quotedPriceCode+'</td>'+
			 		'</tr>'+
			 		'<tr>'+
			 			'<td>所属大类</td>'+
			 			'<td>'+evalData[a].fatherName+'</td>'+
			 		'</tr>'+
			 		 '<tr>'+
			 			'<td>所属小类</td>'+
			 			'<td>'+evalData[a].childName+'</td>'+
			 		'</tr>'+
			 		 '<tr>'+
			 			'<td>项目名称</td>'+
			 			'<td>'+evalData[a].name+'</td>'+
			 		'</tr>'+
			 		 '<tr>'+
			 			'<td>提交时间</td>'+
			 			'<td>'+time+'</td>'+
			 		'</tr>'+
			 	'</table>'+
		 	'</div>';

			}
//			thebody = thebody + '<div class="b_box" ><img src="img/add.png"></img></div>';
			$("body").append(thebody);

		}
		}
	});	
}
	
 //删除功能
	$(document).on("touchstart",".delet",function(){
		var divID=$(this).attr("deID");
		if(confirm("你确定要报价单?")){
			$.ajax({
			   type    : "POST",
			   url     : "../../quotedPriceController/deletQuotedPriceInfo.do",
			   data    : {
				   condition:divID,//穿报价单id给controller层对应方法的condition
				         },
				async   : false,
				success : function(data) {
					if(data = "1"){
						alert("删除成功");
					}
				}
		});
			page=1;
			$("div[id='num"+divID+"']").remove();
		}
	});
 //新建功能
$(document).on("touchstart",".add",function(){
		window.location.href="../newQuoInfoMana/newQuoInfoMana.html";//跳转到新建网址
});
//查看详情
$(document).on("touchend",".openDetails",function(){
	var thisNum = $(this).attr("thisNum");
	var quoDetailsList =  findquoDetailsList(thisNum);
	var thisdetails = findThisDetails(thisNum);//得到寻找详情的结果
	thedetails(thisdetails,quoDetailsList);//发素材给制作详情列表的方法
	$("#info,#clickBack").show();
});
//寻找详情
function findThisDetails(thisNum) {
	for(var a = 0;a < evalData.length; a++){
		if(evalData[a].ID == thisNum ){
			return evalData[a];
		}
	}
}
//制造详情页面
function thedetails(thisdetails,quoDetailsList){
	console.log(thisdetails);
	console.log(quoDetailsList);
	var detailsList ='';
	var totail = 0;
	for(var i=0;i < quoDetailsList.length; i++ ){
		detailsList = detailsList + '<div class="details"><div>'+quoDetailsList[i].modelName+'</div><div>'+(quoDetailsList[i].modelPrice/100).toFixed(2)+'￥</div></div>';
		totail = totail + quoDetailsList[i].modelPrice*1;
	}
	var date = new Date(thisdetails.joinTime.time);
	var time = date.getFullYear()+"-"+(date.getMonth()*1+1*1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() ;
	var detailsDiv =     
	'<div id="detailsID" class="details"><div>报价单编号</div><div>'+thisdetails.quotedPriceCode+'</div></div>'+
    '<div id="detailsName" class="details"><div>报价单名称</div><div>'+thisdetails.name+'</div></div>'+
    '<div id="detailsTime" class="details"><div>报价时间</div><div>'+time+'</div></div>'+
    '<div id="detailsUser" class="details"><div>报价人姓名</div><div>'+thisdetails.employeeName+'</div></div>'+
    '<div id="detailsTypeB" class="details"><div>所属大类</div><div>'+thisdetails.fatherName+'</div></div>'+
    '<div id="detailsTypeL" class="details"><div>所属小类</div><div>'+thisdetails.childName+'</div></div>'+
    '<div id="templet" class="details"><div>模板</div><div>'+thisdetails.grandsonName+'</div></div>'+
    '<div id="totail" class="details"><div>报价细项</div><div>'+(totail/100).toFixed(2)+'</div></div>'+
    '<div id="detailsList">'+
    	detailsList+
    '</div>';
	$("#info").html(detailsDiv);
}
//获取报价细项
function findquoDetailsList(thisNum){
	var quoDetailsList;
	$.ajax({
		type    : "POST",
		url     : "../../quotedPriceController/quoDetailsList.do",
		data    :{condition:thisNum},
		async   : false,
		success : function(data){
			quoDetailsList =  $.parseJSON(data);
		}
		});
	return quoDetailsList;
}
//点击关闭详情
$(document).on("touchend","#clickBack",function(){
	setTimeout($("#clickBack,#info").hide(), 300);
});
//下拉读取
var noMore = 0;
$(window).scroll(function(){
	if(($(document).height()-$(window).height()-$(window).scrollTop()) < 40 ){
		console.log(page < total);
		console.log(total);
		if(page*row < total){
			page += 1;
			start();
		}else{
			if(noMore == 0){
				noMore = 1;
				$("body").append('<div id="noMore">没有更多了</div>');
			}
		}
	}
});