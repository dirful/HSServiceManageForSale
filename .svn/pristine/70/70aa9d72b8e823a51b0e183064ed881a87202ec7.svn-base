//取数据
var name_arry = new Array();//名字数组
var time_arry = new Array();//时间数组
var num_list;//次数组
var IDs = "111,222";
name_arry = IDs.split(",");
var betweens1 = "2015-09-02";
var betweens2 = "2015-12-02";
var betweens = betweens1+","+betweens2;
var type = 3;
var alldata;
var series;
var datas = new Array();
var temdata = new Array();
var max_five_num = 0;
var now_type = 3;
//点击发送时间数据和模式
$(document).on("touchend","#postDate",function(){
	betweens = "";
	for(var b = 1; b <= max_five_num; b++){
		console.log($("#myChoose>div:nth-of-type("+b+")").html());
		if(b >= max_five_num){
			betweens = betweens + $("#myChoose>div:nth-of-type("+b+")").html();
		}else{
			betweens = betweens + $("#myChoose>div:nth-of-type("+b+")").html() +",";
		}
		
	}
	$("#myChoose").hide();
	$.ajax({
		type    : "POST",
		url     : "../../quotedPriceController/getEmployeeInfo.do",
		data    :{
			IDs:IDs,
			type:type,
			betweens:betweens,
			},
		async   : false,
		success : function(data){
			betweens = betweens.split(",");
			console.log(max_five_num);
			alldata = $.parseJSON(data);
			alldata = alldata[0];
			for(var i = 0; i < alldata[0].length; i++){
				name_arry[i] = alldata[0][i].name;
			}
			for(var a = 0; a < max_five_num; a++){
				var arry = [];
				for(var i = 0; i < alldata[0].length; i++){
					arry[i] = alldata[a][i].num;
				}
				console.log(arry);
				var time_object = {
						    name: betweens[a],
						    data: arry
						    };
				time_arry[a] = time_object;
			}
			console.log(name_arry);
			console.log(time_arry);
			excel();
		}
			});
});
//console.log(dataArrayS);
//$.ajax({
//	type    : "POST",
//	url     : "../../quotedPriceController/getEmployeeInfo.do",
//	data    :{
//		IDs:IDs,
//		type:type,
//		betweens:betweens,
//		},
//	async   : false,
//	success : function(data){
//		alldata = $.parseJSON(data);
//		num_list = alldata[0].num.split("-");
//		console.log(num_list);
//	//	console.log(dataArrayS);
//		for(var i = 0; i < alldata[0].name.length; i++){
//			name_arry[i] = alldata[0].name[i].name;
//		}
//			for(var a = 0;a < betArray2[1]-betArray1[1]; a++){//对象数循环
//				var dataArrayM = [];
//				var dataArrayS = {
//						name:"0",
//						data:dataArrayM,
//				};
//				dataArrayS.name = betArray1[1]*1+a+"月";
//				for(var s=0; s <name_arry.length; s++){//循环某月，循环长度为人数
//					temdata = num_list[s].split(",");
//					dataArrayS.data[s] = 1*temdata[a];
//				}
//				datas[a] = dataArrayS;
//			}
//		series = datas;
//		excel();
//			$("g[class=highcharts-button]").hide();
//	}
//});
//启动模块
function excel() {
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Monthly Average Rainfall'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories:name_arry
        },
        yAxis: {
            min: 0,
            title: {
                text: ''
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 次</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series:time_arry
    });
}		
//选择模式
$(document).on("touchend",".changeMode",function(){
	var id =$(this).attr("id");
	$("#date div").show();
	$("#changeMonth").show();
	$("#yearOK").show();
	$("#monthOK").show();
	$("#date>#day").show();
	$("#myChoose").show();
	switch(id){
	case "cy":$("#monthOK").hide();$("#date>#day").hide();$("#changeMonth").hide();type=0;break;
	case "cm":$("#yearOK").hide();$("#date>#day").hide();type=1;break;
	case "cw":$("#monthOK").hide();$("#yearOK").hide();$("#date>#day").hide();$("#date div").hide();type=2;$("#timeB").html("上周情况");break;
	case "cd":$("#monthOK").hide();$("#yearOK").hide();type=3;break;
	}
	
	$("#date").show("normal");
	if(type !=now_type ){
		$("#myChoose").empty();
		max_five_num = 0;
	}
		now_type=type;
});
//选择并显示时间(月和年)
$(document).on("touchend",".OK",function() {
    var onyear = $("#year").html();
    var onmonth = "01";
    if($(this).attr("id") == "monthOK"){
    	onmonth = $("#month").html();
    	if(onmonth*1 < 10){
    		onmonth = "0" + onmonth;
    	}
    	$("#myChoose").append("<div num='"+max_five_num+"'>"+onyear+"-"+onmonth+"</div>");
    }else{
    	$("#myChoose").append("<div num='"+max_five_num+"'>"+onyear+"</div>");
    }
    max_five_num++;
    $("#date").hide("normal");
});
//选择并显示时间(日)
$(document).on("touchend",".day",function() {
    var onyear = $("#year").html();
    var onmonth = $("#month").html();
    var onday = $(this).attr("day");
    if(openBeForOrAfter != 1){
    	beforOrAfter = 0;
    	$("#timeA").hide("");
    }
    if(1*onmonth < 10){
    	onmonth = "0" + onmonth;
    }
    $("#myChoose").append("<div num='"+max_five_num+"'>"+onyear+"-"+onmonth+"-"+onday+"</div>");
    $("#date").hide("normal");
    max_five_num++;
});