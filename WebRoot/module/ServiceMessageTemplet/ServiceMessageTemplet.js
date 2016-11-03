$(function(){
	$("#dg").datagrid({
		height:300,
		width:600,
	    pageSize:10,
	    pageList:[10,15,20],
	    nowrap:true,
	    striped:true,
	    singleSelect:true,
	    fitColumns : true,
		pagination : true,// 分页
		rownumbers : true,// 行数
		queryParams : {condition : "templet.type = 2"},
		url : '../../templetController/getServiceMessageTemplet.do',
		loadMsg : "数据加载中......",
		columns : [ [ {field : "TECODE",title : "模板编码",width : 300}, 
		              {field : "TENAME",title : "模板名称",width : 300}, 
		              {field : "CREATETIME",title : "创建时间",width : 300},
		              {field : "DESCRIPTION",title : "描述",width : 300},
		] ]
	});
});
//删除
function removeTemplet() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length <= 0) {
		$.messager.alert('消息', '请选择需要删除的消息');
		return;
	} else {
		jQuery.ajaxSettings.traditional = true;
		$.messager.confirm('选择框', '您确定删除吗？', function(r) {
			if (r == true) {
				$.post("../../templetController/deleteServiceTemplet.do", {
					ID : rows[0].ID
				}, function(data) {
					$('#dg').datagrid('reload');
				});
			} else {
				$.messager.alert("消息", "删除失败");
			}

		});
	}
}
//刷新
function reloadTemplet(){
	$('#dg').datagrid('reload');
}
//搜索
function sear(){
	var name = $.trim($('#TENAME').val()),
	    firstTime = $('#FIRTIME').datetimebox('getValue'),
	    secondTime = ($('#SECTIME').datetimebox('getValue'));
//	console.log('firstTime'+firstTime);
	if(name != ""||firstTime !="" || secondTime!=""){
		if(firstTime !="" && secondTime!=""){
		$('#dg').datagrid({
			queryParams : {condition : " AND templet.templetName LIKE '%"+ name +"%' AND templet.createTime BETWEEN '"+firstTime+"' AND '"+secondTime+"'"},
		});
		}else if(firstTime !="" && secondTime ==""){
			$('#dg').datagrid({
				queryParams : {condition : " AND templet.templetName LIKE '%"+ name +"%' AND templet.createTime >= '"+firstTime+"'"},
			});	
		}else if(firstTime =="" && secondTime !=""){
			$('#dg').datagrid({
				queryParams : {condition : " AND templet.templetName LIKE '%"+ name +"%' AND templet.createTime <= '"+secondTime+"'"},
			});
		}
		$('#dg').datagrid('reload');
	}else{
		$.messager.alert("消息","请输入搜索条件！");
	}
}