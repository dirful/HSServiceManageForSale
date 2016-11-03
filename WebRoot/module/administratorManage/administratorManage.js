$(document).ready(function(){
	$('#dg').datagrid({  
		width:800,
		height:338,
        fitColumns:true, 
        pageSize : 10,// 默认选择的分页是每页5行数据
        pageList : [ 10, 20, 30 ],// 可以选择的分页集合
        nowrap : true,// 设置为true，当数据长度超出列宽时将会自动截取
        striped : true,// 设置为true将交替显示行背景。
        url:'../../administratorController/getAdminWithPageByCondtion.do',// url调用Action方法
        loadMsg : '数据装载中......',
        columns:[[
                  {field:"ID",title:"角色ID",hidden:true},
                  {field:"PASSWORD",title:"密码",hidden:true},
                  {field:"LOGINNAME",title:"登录名",width: 50},
                  {field:"NAME",title:"名称",width: 50},
                  {field:"pNAME",title:"角色",width: 50},
                  {field:"STATE",title:"状态",width: 50,formatter: function(val,row,index){
                	  if(val == "1"){
                		  return "正常";
                	  }else{
                		  return "禁用";
                	  }
                  }},
                  {field:"CREATTIME",title:"创建时间",width: 100}
                ]],
        singleSelect:true,// 为true时只能选择单行 为了实现批量删除必须隐去
        fitColumns:true,// 允许表格自动缩放，以适应父容器
        pagination : true,// 分页
        rownumbers : true,// 行数 .
    });
});

function allRows(){
	$('#dg').datagrid({
		queryParams:{}
	});
	$('#dg').datagrid('load');
}

function addAdmin(){
	var dialog = parent.$.modalDialog({
		title: '添加管理员',
		width: 400,
		height: 300,
		parameter: null,
		processtype: 'add',
		href: 'module/administratorManage/administratorProcess.html',
		buttons: [{
			text: '添加',
			iconCls: 'icon-ok',
			handler: function(){
				var f = dialog.find('#fm');
				f.form('submit',{
					url: 'administratorController/saveAdmin.do',
					onSubmit: function(param){
						return f.form('validate');
					},
					success: function(result){
						dialog.dialog('close');
						if(result == "true"){
							$('#dg').datagrid('reload');
							$.prompt();
						}else{
							parent.$.messager.alert('警告','添加失败');
						}
					}
				});
			}
		}]
	});
}

function editAdmin(){
	var rows = $('#dg').datagrid('getSelections');
	if(rows.length <= 0){
		$.messager.alert('消息','请选择');
		return;
	}else if(rows.length > 1){
		$.messager.alert('消息','只能选择一条数据');
	}
	var row = rows[0];
	var dialog = parent.$.modalDialog({
		title: '编辑管理员',
		width: 400,
		height: 300,
		parameter: row,
		processType: 'edit',
		href: 'module/administratorManage/administratorProcess.html',
		buttons: [{
			text: '保存',
			iconCls: 'icon-ok',
			handler: function(){
				var f = dialog.find('#fm');
				f.form('submit',{
					url: 'administratorController/updataAdmin.do',
					onSubmit: function(param){
						return f.form('validate');
					},
					success: function(result){
						dialog.dialog('close');
						if(result == "true"){
							$('#dg').datagrid('reload');
							$.prompt();
						}else{
							parent.$.messager.alert('警告','修改失败');
						}
					}
				});
			}
		}]
	});
}

function removeAdmin(){
	var rows = $('#dg').datagrid('getSelections');
	if(rows.length <= 0){
		$.messager.alert('消息','请选择');
		return;
	}else if(rows.length > 1){
		$.messager.alert('消息','只能选择一条数据');
		return;
	}
	var row = rows[0].ID;
	$.messager.confirm('选择框','您确定删除吗？', function(r){
		if(r){
			$.post("../../administratorController/deleteAdmin.do",{ID: row},function(result){
				if(result == "true"){
					$.prompt();
				}else{
					$.messager.alert('警告','删除失败');
				}
				$('#dg').datagrid('reload');
			})
		}
	});
}
function editPassWord(){
	var rows = $('#dg').datagrid('getSelections');
	if(rows.length <= 0){
		$.messager.alert('消息','请选择');
		return;
	}else if(rows.length > 1){
		$.messager.alert('消息','只能选择一条数据');
	}
	var row = rows[0];
	var dialog = parent.$.modalDialog({
		title: '修改密码',
		width: 350,
		height: 130,
		parameter: row,
		processType: 'editPassWord',
		href: 'module/administratorManage/changePassWord.html',
		buttons: [{
			text: '保存',
			iconCls: 'icon-ok',
			handler: function(){
				var f = dialog.find('#fm');
				f.form('submit',{
					url: 'administratorController/changePassWord.do',
					onSubmit: function(param){
						return f.form('validate');
					},
					success: function(result){
						dialog.dialog('close');
						if(result == "true"){
							$('#dg').datagrid('reload');
							$.prompt();
						}else{
							parent.$.messager.alert('警告','修改密码失败');
						}
					}
				});
			}
		}]
	});
}