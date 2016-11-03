$.prompt = function(message) {
	message = message ? message : "操作成功";
	parent.$.messager.show({
		title : '提示',
		msg : message,
		showType:'show'
	});
}


$.alert = function(message) {
	message = message ? message : "操作失败";
	parent.$.messager.alert('警告',message);
}

$.confirm = function(message,_callback) {
	parent.$.messager.confirm('请选择', message,_callback);
}


$.getDialogResult = function(){
	var content = parent.$("#mainContent");
	return content.data("dialogResult");
}

$.loading = function() {
	parent.loading();
}


$.unloading = function() {
	parent.unloading();
}

