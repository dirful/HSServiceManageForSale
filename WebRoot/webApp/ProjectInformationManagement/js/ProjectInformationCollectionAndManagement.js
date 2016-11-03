	$(function(){
	
	//从数据库得到项目信息
	
	var projects;//项目信息数组
	var date;//时间
	var dateString;//时间字符串
	var boxBody;//显示每个项目信息的html代码
	
	$.ajax({
		url:"../../../projectController/getProjectsInfo.do",
		async:false,
		type:"post",
		success:function(data){
			projects=JSON.parse(data);
	
			if(projects!=""){
				for(var i=0;i<projects.length;i++){
					//转换当前时间为字符串
					date = projects[i].createTime;
					dateString = (date.year+1900)+"-"+(date.month+1)+"-"+date.date+" "+date.hours+":"+date.minutes+":"+date.seconds;
					
					boxBody="<div class=\"box\" id=\"box"+projects[i].ID+"\">"+
									"<div class=\"img_box\">"+
										"<img alt=\"add\" src=\"../img/add.png\" />"+
										"<img alt=\"delete\" src=\"../img/delete.png\" />"+
										//"<img alt=\"modify\" src=\"../img/modify.png\" />"+
										"<img alt=\"query\" src=\"../img/query.png\" />"+
										"</div>"+
								
									"<div class=\"data_box\">"+
										"<div class=\"data_row2\" id=\"projectCode\">项目编码<div class=\"data2\">"+projects[i].projectCode+"</div></div>"+
										"<div class=\"data_row2\" id=\"projectName\">项目名称<div class=\"data2\">"+projects[i].projectName+"</div></div>"+
										"<div class=\"data_row2\" id=\"bigClass\">所属大类<div class=\"data2\">"+projects[i].bigClassName+"</div></div>"+
										"<div class=\"data_row2\" id=\"subclass\">所属小类<div class=\"data2\">"+projects[i].subclassName+"</div></div>"+
										"<div class=\"data_row2\" id=\"submitTime\">提交时间<div class=\"data2\">"+dateString+"</div></div>"+
									"</div>"+
								"</div>";
					
					$("#projectBox").append(boxBody);
				}
				
			}
			else{
				$("#add").on("click",function(){
					window.location.href="NewProjectInformation.html";
				}).show();
				
			}
		}
	});
	
	//保证显示项目信息时如果有多行排版正确
	$(".box .data_box").children("div").each(function(i){
		if($(this).hasClass("data_row2")){
			var dataHeight=$(this).children("div").css("height");
			if(dataHeight.replace("px","")>45){
				$(this).attr("class","data_row1");
				$(this).children("div").attr("class","data1");
				$(this).css({
					"height":dataHeight,
					"line-height":"40px"	
				});
				$(this).children("div").css({
					"height":dataHeight,
					"line-height":"27px"
				});
			}
			else{
				$(this).css({
					"height":"45px",
					"line-height":"45px"
				});
			}	
		}	
	});
	
	//增加项目信息点击事件
	$(".box .img_box img:nth-child(1)").click(function(){
		window.location.href="NewProjectInformation.html";
	});
	
	//删除项目信息点击事件
	
	var ID;
	$(".box .img_box img:nth-child(2)").click(function(){
		
		if(confirm("确认删除此表？")){
			
			ID=$(this).parent().parent().attr("id").replace("box","");
			
			$.ajax({
				url:"../../../projectController/deleteProjectInfo.do",
				async:false,
				data:{ID:ID},
				success:function(data){
					if(data=="1"){
						location.reload();//重新加载当前页面
						alert("删除成功!");
					}
					else
						alert("删除失败!");
				}
			});
		}
	});
	
//	//修改项目信息点击事件
//	$(".box .img_box img:nth-child(3)").click(function(){
//		alert("modify");
//	});
	
	//查询项目信息点击事件
	$(".box .img_box img:nth-child(3)").click(function(){
		$("#data_pic").empty();
		
		ID=$(this).parent().parent().attr("id").replace("box","");
		
		projectCode=$(this).parent().next().find("div div").eq(0).text();
		projectName=$(this).parent().next().find("div div").eq(1).text();
		bigClass=$(this).parent().next().find("div div").eq(2).text();	
		subclass=$(this).parent().next().find("div div").eq(3).text();
		createtTime=$(this).parent().next().find("div div").eq(4).text();
	
		$.ajax({
			url:"../../../projectController/searchProjectDetailInfo.do",
			async:false,
			type:"post",
			data:{ID:ID},
			success:function(data){
				var project=JSON.parse(data);
		
				$("#projectCode2 div").text(projectCode);
				$("#projectName2 div").text(projectName);
				$("#bigClass2 div").text(bigClass);
				$("#subclass2 div").text(subclass);
				$("#createTime2 div").text(createtTime);
				$("#templetName2 div").text(project[0].templetName);
				$("#remarks2 div").text(project[0].remarks);
				$("#leaderID2 div").text(project[0].leaderID);
				$("#consumerWorkPlace2 div").text(project[0].consumerWorkPlace);
				$("#contactsName2 div").text(project[0].contactsName);
				$("#progress2 div").text(project[0].progress);
			
				$("#detailBox").show();
				$("#projectBox").hide();
			}
			
		});
		
		//显示图片
		$.ajax({
			url:"../../../projectController/getPicFilePath.do",
			async:false,
			type:"post",
			data:{ID:ID},
			success:function(data){
				var filePaths=JSON.parse(data);
				for(var i=0;i<filePaths.length;i++){
					$("#data_pic").append("<img class='pic' src="+filePaths[i].filePath+">");
				}
			}
		});
		
		//保证查询项目信息时如果有多行排版正确
		$(".detailBox .detailData_box").children("div").each(function(i){
			if($(this).hasClass("data_row2")){
				var dataHeight=$(this).children("div").css("height");
				if(dataHeight.replace("px","")>45){
					$(this).attr("class","data_row1");
					$(this).children("div").attr("class","data1");
					$(this).css({
						"height":dataHeight,
						"line-height":"40px"	
					});
					
					$(this).children("div").css({
						"height":dataHeight,
						"line-height":"27px"
					});
				}
				else{
					$(this).css({
						"height":"45px",
						"line-height":"45px"
					});
				}	
			}	
		});
	});
	
	$("#return").click(function(){
		$("#detailBox").hide();
		$("#projectBox").show();
	});

});