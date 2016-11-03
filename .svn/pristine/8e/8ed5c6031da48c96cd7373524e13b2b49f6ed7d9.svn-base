$(function(){
	$("#dg").datagrid({
		columns:[[
			        {field:'ID',title:'ID',width:100,hidden:true},                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			        {field:'TEMPLETCODE',title:'编码',width:30,align:'center'},
			        {field:'TEMPLETNAME',title:'名称',width:40,align:'center'},
			        {field:'CREATETIME',title:'创建时间',width:55,align:'center'},
			        {field:'CREATEMAN',title:'创建人',width:30,align:'center'},
			        {field:'DESCRIPTION',title:'模板说明',width:70,align:'center'},
			        {field:'REMARKS',title:'备注',width:30,align:'center'},
//			        {field:'OPERATE',title:'操作',width:100,align:'center',
//			            	formatter:function(value,rowData,rowIndex){  
//			                    var btn=""; 
//			                    btn += '<a class="searchcls" onclick="searchTemplet()">查看</a>';  
//			                    btn += '<a class="editcls" onclick="editTemplet()">编辑</a>';
//			                    btn += '<a class="infocls" onclick="info()">信息</a>';
//			                    btn += '<a class="removecls" onclick="removeTemplet()">删除</a>';
//			                    	
//			                    return btn;     
//			                }  
//			            }  
			        ]],  	
//		//初始化按钮为easyui按钮效果
//        onLoadSuccess:function(data){  
//	          $('.searchcls').linkbutton({text:'查看',plain:true,iconCls:'icon-search'});
//	          $('.editcls').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
//	          $('.infocls').linkbutton({text:'信息',plain:true,iconCls:'icon-add'});
//        	  $('.removecls').linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
//        },   

	    frozenColumns:[[
	                    {field:'ck',checkbox:true}
	                    ]],
	                    
	    fitColumns:true,//允许表格自动缩放，以适应父容器  
	    
		width:920,
		height:350,
		pageNumber:1,//初始化的页码编号
		pageSize:10,
		pageList:[10,15,20],
		nowrap:true,//数据显示在一行
		striped:true,//当true时，单元格显示条纹
		singleSelect:false,
		selectOnCheck : true,
		halign:"center",
		
	    pagination : true,//分页  
	    rownumbers : true,//行数  
		url:'templetController/getProjectInfoTempletListWithPaging.do',
		loadMsg:'数据装载中...',
	});
});

	//搜索
	function sear(){
		var condition = "1=1";
		
		//添加名称查询条件
		var NAME = $.trim($('#NAME').val());
		if(NAME != ''){
			condition += " AND templet.templetName like '%"+NAME+"%' ";
		}
		
		//添加时间查询条件
		var FORTIME=$('#FORTIME').datetimebox('getValue');
		var SECTIME=$('#SECTIME').datetimebox('getValue');
		if(FORTIME != ' ' && SECTIME != ' '){
			condition += " AND templet.createTime BETWEEN '"+FORTIME+"' AND '"+SECTIME+"'";
		}
		
		$('#dg').datagrid({
			queryParams:{condition : condition}
		});
		$('#dg').datagrid('reload');
	}
   
//   //增加项目信息采集模板
//   function addTemplet(){
//	   var dialog = parent.$.modalDialog({ 		
//			title : '添加',
//			width : 600,
//			height :550,
//		    topMost: false,
//		    maximizable:true,
//		    maximized:false,
//		    enableSaveButton: false,
//			resizable:true,
//			href : 'module/jsp/studentManage/addStudent.jsp',
//			processType:"add", 
//			buttons : [ {
//				text : '确定 ',
//				iconCls:'icon-ok',
//				handler:function(){
//					var fm = dialog.find('#fm');
//					fm.form('submit',{
//		                url: "studentController/save.do",
//		                onSubmit: function(){
//		                     if(fm.form('validate')){
//		                    	return true;
//		                    } else {
//		                    	return false;
//		                    }
//		                },
//		                success: function(result){
//		                	$.prompt();	
//		                	$('#dg').datagrid('reload');
//		                	dialog('close');
//		                }
//					});
//				}
//			}]
//		});
//   }
//   
   //删除项目信息采集模板
   function removeTemplet(){

	   var rows=$('#dg').datagrid('getSelections');//得到选中的行
	   
	   if(rows.length<=0){
		   $.messager.alert('消息','请选择');
		   return;
	   }
	   
	   //得到选中行的id
	   var ids=[];
	   for(var i=0;i<rows.length;i++){
		   ids.push(rows[i].ID);
	   }
	      
	   jQuery.ajaxSettings.traditional = true;//使用传统的方式浅层进行序列化（参数序列化）?
	   
	   $.messager.confirm('选择框','您确定删除吗?',function(r){
		   if(r){
			   $.post("templetController/deleteTemplets.do",
					   {IDs:ids},
					   function(data){
						   $('#dg').datagrid('reload');//刷新
			   });
		   }
		   else{
			   alert("删除失败");
		   }
	   });
   }
   
//   //修改项目信息采集模板
//   function editTemplet(){
//
//	   var rows=$('#dg').datagrid("getSelections");
//	   if(rows.length<=0){
//		   $.messager.alert('消息','请选择');
//		   return;
//	   }else if(rows.length>1){
//		   $.messager.alert('消息','只能选择一条数据');
//		   return;
//	   }
//	   
//	   var row=rows[0];
//	   console.log(row);
//	  
//	   var dialog = parent.$.modalDialog({
//		   title:'编辑项目',
//		   width:500,
//		   height:600,
//		   parameter:row,//传输需要编辑的数据的行的信息
//		   processType:"edit",
//		   href:'module/ProjectManagement/addProjectInfoTemplet.jsp',
//		   buttons:[{
//			   text:'保存',
//			   iconCls:'icon-ok',
//			   handler:function(){
//				  var f=dialog.find('#fm');
//				  f.form('submit',{
//					  url:"templetController/updatePropTempletByID.do?ID="+row.ID,
//					  onSubmit:function(param){
//						  return f.form('validate');
//					  },
//					  success:function(result){
//						  dialog.dialog('close');
//						  if(result==="true"){
//							  $.prompt();
//							  $('#dg').datagrid('reload');
//						  }else{
//							  alert("修改失败");
//						  }
//					  }
//				  });
//			   }
//		   }]
//	   });
//   };
//   
//   //查看
//   function searchTemplet() {   
//	   var rows=$('#dg').datagrid("getSelections");
//	   if(rows.length<=0){
//		   $.messager.alert('消息','请选择');
//		   return;
//	   }else if(rows.length>1){
//		   $.messager.alert('消息','只能选择一条数据');
//		   return;
//	   }
//	   row=rows[0];
//	   
//	   var dialog = parent.$.modalDialog({
//			title : '查看',
//			width : 500,
//			height :600,
//			topMost: false,
//			maximizable:true,
//			maximized:false,
//			enableSaveButton: false,
//			resizable:false,
//			href : 'module/ProjectManagement/addProjectInfoTemplet.jsp',
//			parameter:row,
//			processType:"view"
//   		});
//	}