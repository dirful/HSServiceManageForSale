$(function(){
	$("#userName").append(user.name);
	$.post("moduleController/getModuleByPermission.do",{},function(result){
		var data = jQuery.parseJSON(result),
			temp,
			html= "";
		
		for(var i in data){
			temp = data[i];
			html += "<a class='columns'  href='"+temp.URL+"' target='content'>>"+temp.MODULENAME+"</a>";
		}
		$("#items").append(html);
	});
	
//	$.post("systemFileController/getPic.do",{ID : icon},function(data){
//		if(data){
//			$("#headPhoto").attr("src",data);
//		}
//	});
	$("#exit").click(function(){
		if(window.confirm("您确定要退出吗?")){
			$.post("administratorController/logout.do",{},function(json){
				window.location.href = "index.html";
			});	
		}
	});
	
	$("#changePasswordElem").click(function(){
		 var dialog=$.modalDialog({
		  title:'修改密码',
		  width: 350,
		  height: 130,
		  parameter:null,
		  processType : "editPassWord",
		  href:'module/administratorManage/changePassWord.html',
		  buttons:[{
			  text:'修改',
			  iconCls:'icon-ok',
			  handler:function(){
				  var f=dialog.find('#fm');
				  f.form('submit',{
					  url:'administratorController/changePassWord.do',
					  onSubmit:function(param){
						  return f.form('validate');
					  },
					  success:function(result){
						  dialog.dialog('close');
						  if(result == "true"){
							  parent.$.messager.alert('消息','修改密码成功');
						  }else{
							  parent.$.messager.alert('警告','修改密码失败');
						  }
					  }
				  });
			  }
		  }]
	   });
	});
	  
});
