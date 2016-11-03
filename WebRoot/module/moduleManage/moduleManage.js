PageData = {};
PageData.PARENTID = '-1';// 父模块
PageData.LEVEL0 = 0;// 模块等级
PageData.HASCHILD = false;// 是否有子模块
PageData.ISENDOFMODULELEVEL = true;// 是否是级末
PageData.condition =  " PARENTID IS NULL ";// 判断条件

$(document).ready(function(){
	// 初始化树
    $('#Moduletree').tree({
        url: "../../moduleController/getModuleTree.do",
        onBeforeExpand: function (node) {
        	
        },
    	onClick: function (node) {// 向远程数据传递conditon语句
    		var id = node.attributes ? node.attributes.nodeCode : null;
    		var level0 = node.attributes ? node.attributes.LEVEL0 : 0;
    		var hasChild = node.attributes ? node.attributes.hasChild : null;
    		if(id == "root"){
    			PageData.PARENTID = null;
    		}else{
    			PageData.PARENTID = id;
    			PageData.LEVEL0 = parseInt(level0)+1;
    		}
    		var condition = "";
    		if(id != null && id != "" && id !="root") {
    			if(hasChild){
    				condition = " m.parent = '"+id+"'";
    			}
    			else{
    				condition = " m.moduleID = '"+ id +"'";
    			}
//    			PageData.condition = condition;
    			$('#dg').datagrid({ 
    				queryParams:{condition:condition}
    			});
			}
    		else{
//    			PageData.condition = "  PARENTID IS NULL  ";
    			$('#dg').datagrid({
    				queryParams:{condition:condition}
    			});
    		}
        }
    });
    
  // 初始表格
	$('#dg').datagrid({  
		width:800,
		height:338,
        fitColumns:true, 
        pageSize : 10,// 默认选择的分页是每页5行数据
        pageList : [ 10, 20, 30 ],// 可以选择的分页集合
        nowrap : true,// 设置为true，当数据长度超出列宽时将会自动截取
        striped : true,// 设置为true将交替显示行背景。
        url:'../../moduleController/getModuleWithPage.do',// url调用Action方法
        loadMsg : '数据装载中......',
        columns:[[
                  {field:"MODULEID",title:"模块ID",hidden:true},
                  {field:"PARENT",title:"父模块ID",hidden:true},
                  {field:"LEVEL0",title:"等级",hidden:true},
                  {field:"MODULENAME",title:"模版名",width:10},
                  {field:"URL",title:"URL",width:40},
                  {field:"HASCHILD",title:"是否有子模块",width:10,formatter(val,row,index){
                	  if(val == "0"){
                		  return "否";
                	  }else{
                		  return "有";
                	  }
                  }},
                  {field:"SHOWMENUPAGE",title:"是否展示",width:10,formatter(val,row,index){
                	  if(val == "0"){
                		  return "不展示";
                	  }else{
                		  return "展示";
                	  }
                  }}
                ]],
        singleSelect:true,// 为true时只能选择单行 为了实现批量删除必须隐去
        fitColumns:true,// 允许表格自动缩放，以适应父容器
        pagination : true,// 分页
        rownumbers : true,// 行数 
    });
	
	function sear() {
    	if($('#searchForm').form('validate')){
			var searchName =  $.trim($('#searchName').val());
    		$('#dg').datagrid({
    			queryParams:{condition : "m.moduleName Like \'%"+searchName+"%\'"}
    		});
    		$('#dg').datagrid('reload'); 
    	}
    }
    
    $('#searchName').keydown(function(e){
		if(e.keyCode==13){
			sear();
		}
    })
});
function allRows() {
	$('#dg').datagrid({
		queryParams:{}
	});
	$('#dg').datagrid('load'); 
}

function treeDataReload(){
	$("#dg").datagrid("load");
	$("#Moduletree").tree("load");
}

function addModule(){
	if(PageData.PARENTID == "-1"){
		$.messager.alert("警告","请选择父模块");
		return;
	}
	var dialog = parent.$.modalDialog({
		title:"新增",
		width:400,
		height:250,
		processType:"add",
		parameter:{PageData:PageData},
		href:"module/moduleManage/moduleActivityl.html",
		buttons:[{
			text:"确定",
			iconCls:"icon-ok",
			handler:function(){
				var f=dialog.find("#fm");
				f.form('submit',{
					url:"moduleController/saveModule.do",
					onSubmit:function(){
						return f.form('validate');
					},
					success:function(result){
						dialog.dialog('close');
						if(result == "true"){
							allRows();
							treeDataReload();
							$.prompt();
						}else{
							$.messager.alert("警告","添加失败");
						}
					}
				});
			}
		}]
	});
}

function editModule(){
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length == 0){
		$.messager.alert("警告","请选择");
		return;
	}else if(rows.length > 1){
		$.messager.alert("警告","只能选择一条数据");
		return;
	}
	var dialog = parent.$.modalDialog({
		title:"修改",
		width:400,
		height:250,
		processType:"edit",
		parameter:rows[0],
		href:"module/moduleManage/moduleActivityl.html",
		buttons:[{
			text:"确定",
			iconCls:"icon-ok",
			handler:function(){
				var f=dialog.find("#fm");
				f.form('submit',{
					url:"moduleController/updataModuleByID.do",
					onSubmit:function(){
						return f.form('validate');
					},
					success:function(result){
						dialog.dialog('close');
						if(result == "true"){
							treeDataReload();
							$.prompt();
						}else{
							$.messager.alert("警告","修改失败");
						}
					}
				});
			}
		}]
	});
}

function removeModule(){
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length == 0){
		$.messager.alert("警告","请选择");
		return;
	}else if(rows.length > 1){
		$.messager.alert("警告","只能选择一条数据");
		return;
	}
	$.messager.confirm("选择框","确定删除吗?",function(t){
		if(t){
			$.post("../../moduleController/deleteModuleByID.do",{ID:rows[0].MODULEID},function(result){
				if(result == "true"){
					treeDataReload();
					$.prompt();
				}else{
					$.messager.alert("警告","删除失败");
				}
			});
		}
	});
}