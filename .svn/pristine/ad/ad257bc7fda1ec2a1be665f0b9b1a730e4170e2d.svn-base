var daylist = "";
var day = "";
var lineLong = 6;//一行有多长
var beforOrAfter = 0;//判断是之前的时间还是之后的时间0为之前1为之后
var openBeForOrAfter = 0;//开启双框1为开启0为关闭
var ssdate = new Date();
var type = 3;
$(function(){
	var one = 0;
	var line = 0;
	$("#date").append('<div id="top"><div id="changeYear"><div class="changeTime" id="yl"><</div><div  id="year">2015</div><div class="changeTime" id="yr">></div></div><div id="changeMonth"><div class="changeTime" id="ml"><</div><div id="month">1</div><div class="changeTime"id="mr">></div></div></div><div id="day"></div>');
    var now = new Date();
    var cDay = now.getDate();
    var cMonth=now.getMonth()+1;
    if(cMonth<10){
    	cMonth = "0" + cMonth;
    }
    if(cDay<10){
    	cDay = "0" + cDay;
    }
    
//    $("#between>div").html(now.getFullYear()+"-"+cMonth+"-"+cDay);
    //日表
	for(var i = 1; i <= 31; i++ ){
        if(one == 0){

            day = "<div class='line'>" + day;
            one = 1;
        }
    	if(i < 10){
    		i = "0"+i;
    	}
        day = day + "<div  class='day' day='"+i+"'>"+i+"</div>";
        line++;
        if(i == 31){
        	for(var a = 0; a < 5; a++){
        		day = day + "<div class='noday' day='"+(31+1+a)+"' ></div>";
        	}        	
        }

        if(line == lineLong || i == 31){
            daylist = daylist + day + "</div>";
            day = "";
            line = 0;
            one = 0;
        }
    }

    //决定日历放哪
    $("#day").append(daylist);
    //隐藏日历
	$("#date").hide();
    if(openBeForOrAfter != 1){
    	beforOrAfter = 0;
    	$("#timeA").hide();
    }
});


//开启选时
//$(document).on("touchend",".changeMode",function() {
////	var bOa = $(this).attr("id");
////	switch(bOa){
////	case "timeB":
////		beforOrAfter = 0;
////		break;
////	case "timeA":
////		beforOrAfter = 1;
////		break;
////	}
//	$("#date").show("normal");
////	$("#between>div").css("background","#ffffff");
////	$(this).css("background","#ececec");
//});
//点击某个改变时间
$(document).on("touchend",".changeTime",function() {
    var changeWhat = $(this).attr("id");
    var y = $("#year").html();
    var m = $("#month").html();
    //发动改变年月的方法
    changeYorM(changeWhat,y*1,m*1);
    //获取改变后的年月
    var y = $("#year").html();
    var m = $("#month").html();
    //通过当前年月决定哪些day有效
    changeDay(y*1,m*1);
});
//换年或者月的方法
function changeYorM(changeWhat,y,m) {
    switch(changeWhat)  {
        case "yl":
            $("#year").html(y - 1);
            break;
        case "yr":
            $("#year").html(y + 1);
            break;
        case "ml":
            if(m == 1){
                $("#year").html(y - 1);
                $("#month").html(12);
            }else{
                $("#month").html(m - 1);
            }
            break;
        case "mr":
            if(m == 12){
                $("#year").html(y + 1);
                $("#month").html(1);
            }else{
                $("#month").html(m + 1);
            }
            break;
    }
}
//换日期页的方法
function changeDay(Y,m) {
    var f = 30;
    if(m == 2){//2月时时闰年还是平年
        if(Y%4 == 0){
            f = 29;
        }else{
            f = 28;
        }
    }else if(m%2 == 1){//判断长月还是断短
        f = 31;
    }
    //先恢复原来的样式
        $(".noday").attr("class","day");
    //开始失效
    for(f=f+1; f <= 36; f++){
        $(".day[day="+f+"]").attr("class","noday");
    }
}
//判断传入的时间是否在timeB的时间之前，beforOrAfter=0为之前
function judgeBeforOrAfter(y,m,d){
	var tb = $("#timeB").html();
	var ymd = new Array();
	ymd = tb.split("-");
	if(y < ymd[0]){
		beforOrAfter = 0;
	}else if(y == ymd[0]){
		if(m < ymd[1]){
			beforOrAfter = 0;
		}else if(m == ymd[1]){
			if(d < ymd[2]){
				beforOrAfter = 0;
			}
		}
	}
}
$(document).on("touchend","#container",function() {
	var role = $(this).attr("role");
	console.log(role);
		$("[role = shower]").hide("normal");
});

