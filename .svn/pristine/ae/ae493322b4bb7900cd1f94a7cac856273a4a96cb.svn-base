var row=null;
$(function(){
    $("#dg").datagrid({
       width:800,
       height:300,
       pageSize:10,
       pageList:[10,15,20],
       nowrap:true,
       striped:true,
       singleSelect:true,
       url:'quotedPriceController/getTemplet.do',
       loadMsg:"数据装载中......",
       columns:[[
          {field:'ID',title:'ID',hidden:true,width:50},
          {field:'templetCode',title:'编码',width:100},
//          {field:'employeeName',title:'用户名称',width:100},templetName
          {field:'templetName',title:'模板名称',width:100},
          {field:'stateName',title:"状态",width:80},
          {field:'thisJoinTime',title:"创建时间",width:150},  
          {field:'description',title:"描述",width:80},
       ]],
       fitColumns:true,
       pagination:true,//分页
       rownumbers:true//行数
    });	
});
   //搜索
   function sear(n){
	   var find;
	   console.log($.trim($('#timeBefore').val()));
	   console.log($.trim($('#timeAfter').val()));
	   switch(n){
	   case 1:find ="employee.employeeName LIKE '%"+ $.trim($('#userName').val())+"%'";break;
	   case 2:find ="DATE_FORMAT(Templet.createTime,'%Y-%m-%d') BETWEEN '"+$.trim($('#timeBefore').val())+"' and '"+$.trim($('#timeAfter').val())+"'";
	   }
	   if(find){
		   $('#dg').datagrid({
			   queryParams:{condition : find}
		   });
		   $('#dg').datagrid('reload');
	   }
   }
   
   //刷新
   function allRows(){
	   $('#dg').datagrid({
		   queryParams:{}
	   });
	   $('#dg').datagrid('reload');
   }
   
   //查看报价
   function view(){
	   var rows=$('#dg').datagrid("getSelections");
	   if(rows.length<=0){
		   $.messager.alert('消息','请选择');
		   return;
	   }else if(rows.length>1){
		   $.messager.alert('消息','只能选择一条数据');
		   return;
		   }
	   row = rows[0];
	   var dialog=$.modalDialog({
		  title:'添加员工',
		  width:550,
		  height:320,
		  parameter:row,
		  processType:"view",
		  href:'module/jsp/quoInfoMana/quoInfoProcess.jsp',
		  buttons:[{
			  text:'查看',
		  iconCls:'icon-ok',
		  handler:function(){
			  var f=dialog.find('#fm');
			  f.form('submit',{
					  url:'userController/saveUser.do',
					  onSubmit:function(param){
						  return f.form('validate');
					  },
					  success:function(result){
						  dialog.dialog('close');
						  if(result==="true"){
							  $('#dg').datagrid('reload');
							  $.prompt();
						  }else{
							  alert("添加失败");
						  }
					  }
				  });
			  }
		  }]
	   });
   }
   
   //修改员工
   function editUser(){
	   
	   var rows=$('#dg').datagrid("getSelections");
	   if(rows.length<=0){
		   $.messager.alert('消息','请选择');
		   return;
	   }else if(rows.length>1){
		   $.messager.alert('消息','只能选择一条数据');
		   return;
	   }
	   
	   var row=rows[0];
	   
	   var dialog=$.modalDialog({
		   title:'编辑员工',
		   width:550,
		   height:320,
		   parameter:row,
		   processType:"edit",
		   href:"module/jsp/quoInfoMana/quoInfoProcess.jsp",
		   buttons:[{
			   text:'保存',
			   iconCls:'icon-ok',
			   handler:function(){
				   var f=dialog.find('#fm');
				   f.form('submit',{
					  url:"userController/editUser.do",
					  onSubmit:function(param){
						  return f.form('validate');
					  },
					  success:function(result){
						  dialog.dialog('close');
						  //alert(result);
						  if(result==="true"){
							  $.prompt();
							  $('#dg').datagrid('reload');
						  }else{
							  alert("修改失败");
						  }
					  }
				   });
			   }
		   }]
	   });
   }
   
   //删除模板
   function removeUser(){
	   var rows=$('#dg').datagrid('getSelections');
	   if(rows.length<=0){
		   $.messager.alert('消息','请选择');
		   return;
	   }
	   
	   var ids=[];
	   for(var i=0;i<rows.length;i++){
		   ids.push(rows[i].ID);
	   }
	   jQuery.ajaxSettings.traditional = true;
	   $.messager.confirm('选择框','您确定删除吗？',function(r){
		  if(r){
			  $.post("quotedPriceController/deleteTemplet.do",{IDs:ids},function(data){
				  $('#dg').datagrid('reload');
			  });
		  } else{
			  alert("删除失败");
		  }
	   });
   }
   
   