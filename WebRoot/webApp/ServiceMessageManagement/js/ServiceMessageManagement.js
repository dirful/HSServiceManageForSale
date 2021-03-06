var ISSMessageList, IRSMessageList, row = 6, page = 1, state = 0;
// state=0为我发送的，1位我接收到的
$(document).ready(function() {
	ISend(page);

	$('.inner').dropload({
		scrollArea : window,
		loadDownFn : function(me) {
			// 为了测试，延迟1秒加载
			setTimeout(function() {
				page++;
				console.log("page:" + page);
				if (state == 0) {
					ISend(page);
				} else {
					IReceive(page);
				}
				me.resetload();
			}, 1000);
		}
	});
	$("#bkgd1").click(function() {
		$("#dianjixianshi").hide();
		$("body").css("overflow", "auto");
	});
	$(".message").click(function() {
		$("body").css("overflow", "hidden");
	});
	$("#hah ,.background1").click(function() {
		$("#dianjixianshi").show();
		$("#title").show();
		$(".content").show();
		$("#hah").hide();
	});
});
function chooseMethod(p) {
	$(".content").empty();
	$("#dianjixianshi").hide();
	page = 1;
	if (p == 1) {
		ISend(page);
	} else {
		IReceive(page);
	}
}
// 我收到的
function ISend(q) {
	state = 0;
	$.ajax({
				url : "../../../serviceMessageController/ISendServiceMessage.do",
				async : false,
				data : {
					row : 3,
					page : q
				},
				type : "post",
				success : function(data) {
					ISSMessageList = $.parseJSON(data);
					if (ISSMessageList.length > 0) {
						var i, ISM = "";
						for (i = 0; i < ISSMessageList.length; i++) {
							ISM += "<div class='message' onclick='seeDetails(1,"
									+ i
									+ ")'>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息标题</div>"
									+ "<div class='detial' style='float:left'>"
									+ ISSMessageList[i].Title
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>项目名称</div>"
									+ "<div class='detial' style='float:left'>"
									+ ISSMessageList[i].ProjectName
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>报价总额</div>"
									+ "<div class='detial' style='float:left'>"
									+ ISSMessageList[i].TheTotalOffer
									+ "元"
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息模板</div>"
									+ "<div class='detial' style='float:left'>"
									+ ISSMessageList[i].TemplateName
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息时间</div>"
									+ "<div class='detial' style='float:left'>"
									+ ISSMessageList[i].offerTime
									+ "</div>"
									+ "</div>"

									+ "</div>";
						}
						$(".content").html(ISM);
					} else {
						$(".pull").fadeIn(1000);
						$(".pull").fadeOut(3000);
					}
				}
			});
	$("#send").css({
		"color" : "rgb(0,204,0)",
		"border-color" : "rgb(0,204,0)"
	});
	$("#receive").css({
		"color" : "rgb(0,0,0)",
		"border-color" : "rgb(0,0,0)"
	});
}

function IReceive(p) {
	$("#receive").css({
		"color" : "rgb(0,204,0)",
		"border-color" : "rgb(0,204,0)"
	});
	$("#send").css({
		"color" : "rgb(0,0,0)",
		"border-color" : "rgb(0,0,0)"
	});
	state = 1;
	$.ajax({
				url : "../../../serviceMessageController/IReceiveServiceMessage.do",
				async : false,
				data : {
					row : 3,
					page : p
				},
				type : "post",
				success : function(data) {
					IRSMessageList = $.parseJSON(data);
					if (IRSMessageList.length > 0) {
						var i, IRSM = "";
						for (i = 0; i < IRSMessageList.length; i++) {
							IRSM += "<div class='message' onclick='seeDetails(2,"
									+ i
									+ ")'>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息标题</div>"
									+ "<div class='detial' style='float:left'>"
									+ IRSMessageList[i].Title
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>项目名称</div>"
									+ "<div class='detial' style='float:left'>"
									+ IRSMessageList[i].ProjectName
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>报价总额</div>"
									+ "<div class='detial' style='float:left'>"
									+ IRSMessageList[i].TheTotalOffer
									+ "元"
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息模板</div>"
									+ "<div class='detial' style='float:left'>"
									+ IRSMessageList[i].TemplateName
									+ "</div>"
									+ "</div>"
									+ "<div class='row'>"
									+ "<div class='caption' style='float:left'>消息时间</div>"
									+ "<div class='detial' style='float:left'>"
									+ IRSMessageList[i].offerTime
									+ "</div>"
									+ "</div>" + "</div>";
						}
						$(".content").html(IRSM);
					} else {
						$(".pull").fadeIn(1000);
						$(".pull").fadeOut(3000);
					}

				}
			});
}
// 查看详情 p==1为我发送的，2为我接收的
function seeDetails(p, q) {
	$("#dianjixianshi").show();
	var a1 = "";
	if (p == 1) {
		if (ISSMessageList[q].pictureID != null
				&& typeof (ISSMessageList[q].pictureID) != "undefined"
				&& ISSMessageList[q].pictureID != "") {
			for ( var k = 0; k < ISSMessageList[q].FileNameRoute.length; k++) {
				a1 += "<img src='" + ISSMessageList[q].FileNameRoute[k]
						+ "'class='photo'></img>";
				$("#chooseProject").css({
					"height" : "250px"
				});
			}
		} else {
			$("#chooseProject").css({
				"height" : "180px"
			});
		}
		var content = "<div class='name' id='nameTitle'>" + "详细信息"
				+ "</div>" + "<div class='row'>"
				+ "<div class='caption' style='float:left'>项目名称</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ ISSMessageList[q].ProjectName
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>联系人</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ ISSMessageList[q].contactsName
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>报价总额</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ ISSMessageList[q].TheTotalOffer
				+ "元"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>报价人</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ ISSMessageList[q].employeeName
				+ "</div>"
				+ "</div>"
				+ "</div>" + "<div class='pictureRow'>" + a1 + "</div>";
	} else {
		if (IRSMessageList[q].pictureID != null
				&& typeof (IRSMessageList[q].pictureID) != "undefined"
				&& IRSMessageList[q].pictureID != "") {
			for ( var k = 0; k < IRSMessageList[q].FileNameRoute.length; k++) {
				a1 += "<img src='" + IRSMessageList[q].FileNameRoute[k]
						+ "'class='photo'></img>";
				$("#chooseProject").css({
					"height" : "250px"
				});
			}
		} else {
			$("#chooseProject").css({
				"height" : "180px"
			});
		}
		console.log(IRSMessageList[q]);
		var content = "<div class='name' id='nameTitle'>" + "项目名称"
				+ "</div>" + "<div class='row'>"
				+ "<div class='caption' style='float:left'>项目名称</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ IRSMessageList[q].ProjectName
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>联系人</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ IRSMessageList[q].contactsName
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>报价总额</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ IRSMessageList[q].TheTotalOffer
				+ "元"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='row'>"
				+ "<div class='caption' style='float:left'>报价人</div>"
				+ "<div class='detial' style='float:left'>"
				+ "<div id='projectName' class='xinxi' >"
				+ IRSMessageList[q].employeeName
				+ "</div>"
				+ "</div>"
				+ "<div class='pictureRow'>" + a1 + "</div>";
	}
	$("#chooseProject").html(content);
}

// $(document).on("click","#bkgd1",function(){
// $("#dianjixianshi").hide();
// $("body").css("overflow","auto");
// });

// $(document).on("click",".message",function(){
// $("body").css("overflow","hidden");
// });

// 点击放大图片
$(document).on("click", ".photo", function() {
	var now_pic = $(this).attr("src");
	var windowHeight = $(window).height();
	var windowWidth = $(window).width();
	var tempPic = "<img id= 'bigpic_pic'src='" + now_pic + "'></img>";
	$(".background1").css({
		"height" : windowHeight + "px"
	});
	$(".background1").css({
		"visibility" : "hidden"
	});
	$(".background1").html(tempPic);
	var img = $(this);
	var realWidth;// 真实的宽度
	var realHeight;// 真实的高度

	// 这里做下说明，$("<img/>")这里是创建一个临时的img标签，类似js创建一个new Image()对象！
	$("<img/>").attr("src", $(img).attr("src")).load(function() {
		realWidth = this.width;
		realHeight = this.height;
		// 确定图片缩放比例
		if ((realWidth >= windowWidth) && (realHeight >= windowHeight)) {
			if ((realWidth / windowWidth) >= (realHeight / windowHeight)) {
				var sScale = windowWidth / realWidth;
				realWidth = windowWidth;
				realHeight = realHeight * sScale;
			} else {
				var sScale = windowHeight / realHeight;
				realHeight = windowHeight;
				realWidth = realWidth * sScale;
			}
		} else if (realWidth >= windowWidth && realHeight < windowHeight) {
			var sScale = windowWidth / realWidth;
			realWidth = windowWidth;
			realHeight = realHeight * sScale;
		} else if (realWidth < windowWidth && realHeight >= windowHeight) {
			var sScale = windowHeight / realHeight;
			realHeight = windowHeight;
			realWidth = realWidth * sScale;
		}
		$("#bigpic_pic").css({
			"position" : "absolute",
			"top" : "50%",
			"left" : "50%",
			"margin-top" : "-" + realHeight / 2 + "px",
			"margin-left" : "-" + realWidth / 2 + "px",
			"height" : realHeight + "px",
			"width" : realWidth + "px"
		});
		$(".background1").css({
			"visibility" : "visible"
		});
	});
	$("#dianjixianshi").hide();
	$("#title").hide();
	$(".content").hide();
	$("#hah").show();
});
// $(document).on("click","#hah",".background1",function(){
// $("#dianjixianshi").show();
// $("#title").show();
// $(".content").show();
// $("#hah").hide();
// });
// $(document).on("touchend","#hah",".background1",function(){
// $("#dianjixianshi").show();
// $("#title").show();
// $(".content").show();
// $("#hah").hide();
// });

// 新增
function add() {
	$("#send").css({
		"color" : "rgb(0,0,0)",
		"border-color" : "rgb(0,0,0)"
	});
	$("#receive").css({
		"color" : "rgb(0,0,0)",
		"border-color" : "rgb(0,0,0)"
	});
	$("#new").css({
		"color" : "rgb(0,204,0)",
		"border-color" : "rgb(0,204,0)"
	});
	window.location.href = "../../ServiceMessageManagement/html/added.html?backurl="
			+ window.location.href;
}
