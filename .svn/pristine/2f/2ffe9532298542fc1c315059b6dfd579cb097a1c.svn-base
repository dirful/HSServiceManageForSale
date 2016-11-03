$(function(){
	$("#dg").datagrid({
		width:1000,
		height:400,
		pageSize:10,
		pageList:[10,15,20],
		nowrap:true,
		striped:true,
		singleSelect:true,
		url:"typeController/getnext.do",
		loadMsg:"请等待一会...",
		columns:[[
//		   {field:'ck',title:'code',checkbox:true,align:"center"},
           {field:'ID',title:'ID',width:100,hidden:true,align:"center"},
		   {field:'DESCRIPTION',title:'名称',width:50,align:"center"},
		   {field:'PARENTID',title:'父类ID',width:50,align:"center"},
		   {field:'CODE',title:'编码',width:100,align:"center"},
		   {field:'NAME',title:'父分类',width:100,align:"center",hidden:true},
//		   {field:'childrens',title:'所属小类',width:100,align:"center"},
		   //{field:'childrens',title:'描述',width:100,align:"center"},
		   {field:'STATE',title:'状态',width:100,align:"center"},
	       {field:'operate',title:'操作',width:100,align:"center",formatter:function(value,row,index){
		   return "<input class='back2' type='button' value='查看' onclick='see("+index+")' />"+
		   "<input class='back2' type='button' value='禁用' onclick='change("+index+")' />";
		   }}
		]],
		fitColumns:true,
		pagination:true,
		rownumbers:true,
//		checkOnSelect:false

	});
});
//查看
function see(index){
	var rows=$("#dg").datagrid("getRows");
	$.ajax({
	     url:"typeController/getType.do",
	     type:"POST",
	     data:{
	    	 ID:rows[index].ID
	    	 },
		 async:false,
		 success:function(data){
				var add=parent.$.modalDialog({
					title:"分类信息",
					width:500,
					height:600,
					parameter:null,
					processType:"add",
					href:"module/ProjectSubjectManagement/jsp/editSaleLogType.jsp",
				});
		}
	});
	
}
//禁用
function change(index){
	var exchange=0;
	var rows=$("#dg").datagrid("getRows");
	if(rows[index].STATE=="禁用")
	   {exchange=1;}
	else if(rows[index].STATE=="启用") 
		{exchange=0;}
	$.ajax({
	     url:"typeController/savastate.do",
	     type:"POST",
	     data:{
	    	 ID:rows[index].ID,
	    	 condition:exchange
	    	 },
		 async:false,
		 success:function(data){
			 $('#dg').datagrid('reload');
				               }
		});
	
}

//刷新
function allRole(){
	$("#dg").datagrid({
		queryParams:{}
	});
	$("#dg").datagrid("reload");
}

//修改
function editer(){
	var modys=$("#dg").datagrid("getSelections");
	if(modys.length<=0){
		$.messager.alert("提示","请选择！");
		return ;
	}else if(modys.length>1){
		$.messager.alert("提示","请选择一条进行修改！");
		return ;
	}
	var mody=modys[0];
	var dialog=parent.$.modalDialog({
		title:"修改分类",
		width:300,
		height:300,
		parameter:mody,
		processType:"edit",
		href:"module/ProjectSubjectManagement/jsp/editSaleLogType.jsp",
		buttons:[{
			text:"保存",
			iconCls:'icon-ok',
			  handler:function(){
				  alert();
				  var f=dialog.find('#join');
				  f.form('submit',{
					  url:'typeController/updataType.do',
					  onSubmit:function(param){
						  return f.form('validate');
					  },
					  success:function(result){
						  dialog.dialog('close');
						  if(result==="true"){
							  $('#dg').datagrid('reload');
							  $.prompt();
						  }else{
							  alert("failed 失败");
						  }
					  }
				  });
			  }
		}]
	});	
}
//删除
function removable(){
	var modys=$("#dg").datagrid("getSelections");
	if(modys.length<=0){
		$.messager.alert("提示","请选择！");
		return ;
	}
	var mody=[];
	for(var i=0;i<modys.length;i++){
		mody.push(modys[i].ID);
	}
	jQuery.ajaxSettings.traditional=true;//
	$.messager.confirm("选择框","确定删除吗？",function(removable){
		if(removable!="-1"){
			$.post("typeController/deleteType.do",{ids:mody},function(data){
				$("#dg").datagrid("reload");
			});
		}else{
			alert("删除失败！");
		}
	});	
}
	PageData = {};
	PageData.LEVEL = 1;
	PageData.PARENTID = "";
//进入下级
function next(){
	var nexts=$("#dg").datagrid("getSelections");
	if(nexts.length<=0){
		$.messager.alert("提示","请选择！");
		return ;
	}else if(nexts.length>1){
		$.messager.alert("提示","请选择一条！");
		return ;
	}
	var row=nexts[0];	
	if(row.LEVEL == 2){
		$.messager.alert("提示","已经到底了。");
		return;
	}
	PageData.LEVEL = row.LEVEL*1 + 1;
	PageData.PARENTID=row.PARENTID;
//	var currentNode = new columnNode(row.ID,row.PARENTID,row.TYPE);
//	PageData.node.push(currentNode);	
	refreshData(row.ID,row.PARENTID);
}
//返回上级
function prev(){
	if(PageData.LEVEL == 2){
		PageData.LEVEL = PageData.LEVEL*1 - 1;
		refreshData(PageData.LEVEL,1);
	}else{
		$.messager.alert("提示","已经到顶了。");
		return;
	}
}
//点击导航后的刷新事件
function refreshData(val1,val2){
	$('#dg').datagrid({
		queryParams:{
			condition:val1,
			PARENTID:val2
			}
	});
	$("#dg").datagrid("reload");
}
//栏目类的导航节点初始化
function columnNode(PARENTID){
	var node = {};
	node.PARENTID = PARENTID;
	return node;
}