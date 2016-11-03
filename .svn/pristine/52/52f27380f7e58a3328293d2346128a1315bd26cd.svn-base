 var fileID=[];

var picID;
$(document).ready(function(){

	/**提交具体信息*/
	var projectName;//项目名称
	var remarks;//项目描述
	var leaderID;//项目负责人
	var consumerWorkPlace;//客户姓名
	var contactsName;//联系人姓名
	var progress;//进展
	var templetID;//模板ID
	var typeID;//小类ID
	var createTime;//创建时间
	var project;
	
	$(document).on("click","#submit2",function(){
		
//		console.log(IDs);
		
		//从前台获取信息
		projectName=$("#projectNameInput").val();
		remarks=$("#remarksInput").val();
		leaderID=$("#leaderIDInput").val();
		consumerWorkPlace=$("#consumerWorkPlaceInput").val();
		contactsName=$("#contactsNameInput").val();
		progress=$("#progressInput").val();
		templetID=$("#templetName div").children().eq(1).text();
		typeID=$("#subclass div").children().eq(1).text();
		createTime=new Date();
		
		project={
			projectName:projectName,
			remarks:remarks,
			leaderID:leaderID,
			consumerWorkPlace:consumerWorkPlace,
			contactsName:contactsName,
			progress:progress,
			templetID:templetID,
			typeID:typeID,
			picID:fileID.toString(),
			createTime:createTime
		};
		
		//保存项目信息
		$.ajax({
			url:"../../../projectController/saveProjectInfo.do",
			async:false,
			type:"post",
			data:project,
			success:function(data){
				if(data=="1"){
					alert("提交成功!");
				}
				else {
					alert("提交失败!");
				}
			}
		});
		
		window.location.href="ProjectInformationCollectionAndManagement.html";
		
	});

//************************************************************
	
	//页面一点击提交按钮顶部切换样式函数
	var bigClass;
	var subclass;
	var templetName;
	
	$("#submit1").click(function(){
		bigClass=$("#bigClass div").text();
		subclass=$("#subclass div").text();
		templetName=$("#templetName div").text();
		
		if(bigClass!=""&&subclass!=""&&templetName!=""){
			$("#box1").hide();
			$("#box2").show();
			$("#btn1").css("border-bottom","solid 2px #999999");
			$("#btn2").css("border-bottom","solid 2px rgb(0,255,0)");
			$("#btn1").css("color","black");
			$("#btn2").css("color","rgb(0,255,0)");
		}
		else
			alert("内容不能为空");
	});
	
	//选择模板点击函数
	function selectTemplate(name){
		$("#box1").hide();
		$("#box_"+name).show();
	}

	//大类点击事件
	$("#bigClass").click(function(){
		selectTemplate("bigClass");
	});

	//小类点击事件
	$("#subclass").click(function(){
		if($("#subclass div").text()==""&&$("#bigClass div").text()=="")
			alert("请输入大类");
		else
			selectTemplate("subclass");
	});

	//日志模板点击事件
	$("#templetName").click(function(){
		if($("#templetName div").text()==""&&$("#subclass div").text()=="")
			alert("请输入小类");
		else
		selectTemplate("templetName");
	});

	//填报时间点击事件
	$("#submitTime").click(function(){
		var currentTime=getCurrentTimeString();
		$("#submitTime div").html(currentTime);
	});
	
	//基本数据点击修改事件
	var text;
	
	//选择模板获取数据点击函数
	function selectTemplateData(name,text){
		$("#box_"+name).hide();
		$("#box1").show();
	
		$("#"+name+" div").text(text);
	}
	
	/**获取大类数据*/
	var bigClassName;//大类名字数组
	var row_bigClassName;//每行大类数组html
	
	$.ajax({
		url:"../../../projectController/getBigClassName.do",
		async:false,
		type:"post",
		success:function(data){
			bigClassName=JSON.parse(data);
			if(bigClassName!=null){
				for(var i=0;i<bigClassName.length;i++){
					row_bigClassName="<div class=\"data_row data_row2\"><span>"+bigClassName[i].NAME+"</span><span style=\"display:none\">"+bigClassName[i].ID+"</span></div>";
					
					$("#box_bigClass").append(row_bigClassName);
				}
			}
		}
	});
	
	/**获取部门*/
	$.ajax({
		url:"../../../projectController/getDepartment.do",
		async:false,
		type:"post",
		success:function(data){
			departmentName=JSON.parse(data);
			
			if(departmentName!=null){
				for(var i=0;i<departmentName.length;i++){
					row_departmentName="<option value="+departmentName[i].ID+">"+departmentName[i].departmentName+"</option>";
					
					$("#department").append(row_departmentName);
				}
			}
			
			$("#employee").empty();
			var departmentID=$("#department").children("option:selected").val();
			$.ajax({
				url:"../../../projectController/getEmployee.do",
				async:false,
				type:"post",
				data:{departmentID:departmentID},
				success:function(data){
					employeeName=JSON.parse(data);
					if(employeeName!=null){
						for(var i=0;i<employeeName.length;i++){
							row_employeeName="<option value="+employeeName[i].ID+">"+employeeName[i].employeeName+"</option>";
							
							$("#employee").append(row_employeeName);
						}
					}
				}
			});
		}
	});
	
	
	/**根据部门获取人员*/
	$(document).on("change","#department",function(){
		$("#employee").empty();
		var departmentID=$(this).children("option:selected").val();
		
		$.ajax({
			url:"../../../projectController/getEmployee.do",
			async:false,
			type:"post",
			data:{departmentID:departmentID},
			success:function(data){
				employeeName=JSON.parse(data);
				if(employeeName!=null){
					for(var i=0;i<employeeName.length;i++){
						row_employeeName="<option value="+employeeName[i].ID+">"+employeeName[i].employeeName+"</option>";
						
						$("#employee").append(row_employeeName);
					}
				}
			}
		});
		
	});
	
	/**添加接收人*/
	
	var IDs=new Array();
	$("#addReceiveMan").click(function(){
		var name=$("#employee").children("option:selected").text();
		var ID=$("#employee").children("option:selected").val();
		
		if(!isExist(IDs,ID)&&name!=""){//验证ID是否存在
			IDs.push(ID);
			var htmlBody='<div class="receiveManDiv">'+
							'<span class="receiveManName">'+name+'</span>'+
							'<span style="display:none">'+ID+'</span>'+
						 '</div>';
			$("#receiveMan").append(htmlBody);
		}
		else{
			alert("接收人已存在，请不要重复添加!");
		}
	});
	
	
	/**删除接收人*/
	$(document).on("click","#receiveMan div",function(){
		var employeeID=$(this).children("span").eq(1).text();
		IDs.pop(employeeID);
		
		console.log(IDs);
		
		$(this).remove();
		
		
	});
	
	//大类
	var parentID;
	var subclassName;
	var row_subclassName;
	
	$("#box_bigClass div").click(function(){
		$("#subclass div").empty();
		$("#box_subclass").empty();
		$("#templetName div").empty();
		$("#box_templetName").empty();
		
		parentID=$(this).children().eq(1).text();
		
		//根据选择的大类获得小类
		$.ajax({
			url:"../../../projectController/getSubclassName.do",
			async:false,
			type:"post",
			data:{"parentID":parentID},
			success:function(data){
				subclassName=JSON.parse(data);
				if(subclassName!=null){
					for(var i=0;i<subclassName.length;i++){
						row_subclassName="<div class=\"data_row data_row2\"><span>"+subclassName[i].NAME+"</span><span style=\"display:none\">"+subclassName[i].ID+"</span></div>";
					
						$("#box_subclass").append(row_subclassName);	
					}
				}
			}
		});
		
		text=$(this).children().eq(0).text();
		selectTemplateData("bigClass",text);
	
	});
	
	//小类
	var subclassID;
	var htmlBody;
	
	$(document).on("click","#box_subclass div",function(){
		
		$("#templetName div").empty();
		$("#box_templetName").empty();
		
		text=$(this).children().eq(0).text();//得到选择小类的名称
		subclassID=$(this).children().eq(1).text();//得到选择小类的ID
		htmlBody="<span>"+text+"</span><span style=\"display:none\">"+subclassID+"</span>";
		$("#box_subclass").hide();
		$("#box1").show();
	
		$("#subclass div").html(htmlBody);
		
		/**根据小类获取模板名称和ID*/
		var templetName;//模板名字数组
		var row_templetName;//每行模板名字html
		
		$.ajax({
			url:"../../../projectController/getTempletName.do",
			async:false,
			type:"post",
			data:{subclassID:subclassID},
			success:function(data){
				templetName=JSON.parse(data);
				if(templetName!=null){
					for(var i=0;i<templetName.length;i++){
						row_templetName="<div class=\"data_row data_row2\"><span>"+templetName[i].templetName+"</span><span style=\"display:none\">"+templetName[i].ID+"</span></div>";
						
						$("#box_templetName").append(row_templetName);
					}
				}
			}
		});
	});
	
	//日志模板
	var templetID;
	var htmlBody;
	
	$(document).on("click","#box_templetName div",function(){
		
		text=$(this).children().eq(0).text();//得到选择的模板的名称
		templetID=$(this).children().eq(1).text();//得到选择模板的ID
		htmlBody="<span>"+text+"</span><span style=\"display:none\">"+templetID+"</span>";
		$("#box_templetName").hide();
		$("#box1").show();
	
		$("#templetName div").html(htmlBody);
	});
	
	
	//*********************************************************

	//基本数据点击修改事件
	
	$("#box2 div").click(function(){
		var divName=$(this).attr("id");
		$("#"+divName+"Input").focus();
	});
	
	//输入框输入文字时左对齐，输完文字后文字自动靠右对齐
	$(".data_row .data_input").focusout(function(){
		$(this).css("text-align","right");
	}).focusin(function(){
		$(this).css("text-align","left");
	});
	
//	$(".data_row .data_area").focusout(function(){
//		//$(this).css("text-align","right");	
//	});
	
	//填报时间点击事件
	$("#createTime").click(function(){
		var currentTime=getCurrentTimeString();
		$("#createTime div").html(currentTime);
	});
	
	//显示或隐藏删除框
	var clickNumber = 0;
	$("#bigpic_pic").click(function() {
		clickNumber++;
		if (clickNumber % 2 == 0) {
			$("#operate").show();
		} else {
			$("#operate").hide();
		}
	});

	//点击返回小图
	$(document).on("click", ".return", function() {
		$("#bigpic_pic").remove();
		$("#small").attr("id", "");
		$("#hah").hide();
		$("#operate").hide();
		$("#title").show();
		$("#submitMessage").show();
		$("#messageTemplateWrite").show();
	});

	//删除图片
	$(".delete").click(function() {
		PICID = $("#small").attr("name");
		//alert(PICID);
		var a = confirm("你确定要删除吗？");
		if (a) {
			$("#bigpic_pic").remove();
			$("#small").remove();
			$("#hah").hide();
			$("#imghead").show();
			for ( var i = 0; i < fileID.length; i++) {
				if (fileID[i] == PICID) {
					if (i != fileID.length) {
						fileID[i] = fileID[i + 1];
						fileID.length -= 1;
					} else{
						fileID.pop();
						$("#imghead").show();
					}
				}
			}
			$.ajax({
				type : "POST",
				url : "../../../systemFileController/deletePictureByID.do",
				async : false,
				data : {
					fileID : PICID
				},
				success : function(data) {
					$("#operate").hide();
					$("#title").show();
					$("#submitMessage").show();
					$("#messageTemplateWrite").show();
				}
			});
		} else {
		}
	});
	
	
});

// 图片上传及实时显示
function openBrowse() {
	// $("#upload").click(); 这一句可代替下面的第三句，也可以代替本方法的功能，其他语句是浏览器兼容问题
	var ie = navigator.appName == "Microsoft Internet Explorer" ? true : false;
	if (ie) {
		document.getElementById("upload").click();
		// document.getElementById("filename").value=document.getElementById("upload").value;
	} else {
		var a = document.createEvent("MouseEvents");// FF的处理
		a.initEvent("click", true, true);
		document.getElementById("upload").dispatchEvent(a);
	}
}	

//图片上传预览    IE是用了滤镜。
function previewImage(file){
	if (file.files && file.files[0]) {
		var icon = document.getElementById('imghead');
		var parent = document.getElementById('photos');
		var img = document.createElement("img");
		img.setAttribute("class", "photo");
		parent.insertBefore(img, icon);
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		};
		reader.readAsDataURL(file.files[0]);
		var photos = document.getElementsByClassName("photo");
		if (photos.length == 4) {
			$("#imghead").hide();
		};
	}
	//图片上传
	
	$.ajaxFileUpload({
//	$("#form1").ajaxSubmit({
		url : "../../../systemFileController/uploadProjectImg.do",//用于文件上传的服务器端请求地址
		secureuri : true,//是否启用安全提交，一般设置为false
		fileElementId : 'upload',//文件上传控件的id
		dataType : 'json',
		success : function(result) {
//			console.log(result);
			fileID.push(result[0].fileID);
			picID = result[0].fileID;
			$('.photo:last').attr("name", picID);
		}
	});
}

//图片点击放大
	$(document).on("click", ".photo", function(){
	if($(this).attr("id")!="imghead"){
		var now_pic = $(this).attr("src");
		$(this).attr("id", "small");
		//$(this).attr("id", "picID");
		$("#hah").show();
		var realWidth;//真实的宽度
		var realHeight;//真实的高度
		var tempPic = "<img id= 'bigpic_pic'src='" + now_pic + "'></img>";
		var windowWidth = $(window).width();
		var windowHeight = $(window).height();
		//alert(windowWidth+windowHeight);
		$("#hah").css({
			"height" : windowHeight + "px"
		});
		$(".background1").css({
			"visibility" : "hidden"
		});
		$(".background1").html(tempPic);
		var img = $(this);
		//这里做下说明，$("<img/>")这里是创建一个临时的img标签，类似js创建一个new Image()对象！
		$("<img/>").attr("src", $(img).attr("src")).load(function() {
			realWidth = this.width;
			realHeight = this.height;
		//	alert("realWidth"+this.width+"realHeight"+realHeight);
			//确定图片缩放比例
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
		//	alert("realWidth"+realWidth+"realWidth"+realWidth);
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
			$("#operate").show();
			$("#title").hide();
			$("#submitMessage").hide();
			$("#messageTemplateWrite").hide();
		});	
	}
});
	
/**判断新增加的接收人是否存在*/
function isExist(IDs,ID){
	var isExist=false;
	for(var i=0;i<IDs.length;i++){
		if(IDs[i]==ID){
			isExist=true;
		};
	}
	
	return isExist;
};

		