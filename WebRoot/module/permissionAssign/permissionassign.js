PageData = {};
PageData.isTrigger = true;//防止触发权限树的onCheck事件
PageData.data = null;//对应权限的权限分配数据
PageData.roleID = null;//权限ID

$(document).ready(function(){
	$('#roleTree').tree({
        url: "../../permissionController/getPermissionTree.do",
		animate :true,
		onLoadSuccess : function(){
//			 $('#roleTree').tree("expandAll");
		},
    	onClick: function (node) {//向远程数据传递conditon语句
    		var id = node.attributes ? node.attributes.nodeCode : null;
			if(id){
				PageData.roleID = id;
	        	$.post("../../permissionAssignController/getPermissionAssignsByPermissionID.do",{ID : id},function(data){
					PageData.data = eval("("+data+")");
//					console.info("权限分配数据：");
//					console.info(PageData.data);
					PageData.isTrigger = false;
					var checkedNode =  $('#permissionTree').tree("getChecked");
//					console.info(checkedNode);
//					console.info("----------------------");
					//遍历选中的节点取消选中
					if(checkedNode){
						for(var i in checkedNode){
//							console.info(checkedNode[i].target);
							if(checkedNode[i].target){
								$('#permissionTree').tree("uncheck",checkedNode[i].target)
							}
						}
					}
//					console.info($('#permissionTree').tree("getRoot").target);
					//取出$('#permissionTree')的根节点的所有子节点
					var nodes = $('#permissionTree').tree("getChildren",$('#permissionTree').tree("getRoot").target);
//					console.info(nodes);
					for(var i in nodes){
						var cacheNode = nodes[i];
//						console.info($('#permissionTree').tree("isLeaf",cacheNode.target));
						if($('#permissionTree').tree("isLeaf",cacheNode.target)){
							autoCheck(cacheNode);
						}
					}
					PageData.isTrigger = true;
				});
			}
		}
    });
	
	$('#permissionTree').tree({
        url: "../../moduleController/getModuleTree.do",
    	checkbox : true,
		animate :true,
		onlyLeafCheck : true,
		onLoadSuccess : function(){
//			 $('#permissionTree').tree("expandAll");
		},
		onCheck : function(node){
			if(!PageData.isTrigger){
				return;
			}
			if(!PageData.roleID){
				alert("请选择角色!");
				return;
			}
//			console.info(node);
			console.info(node.checked);
			$.post("../../permissionAssignController/checkPermissionAssign.do",{checked : node.checked , roleID : PageData.roleID, moduleID :  node.attributes.nodeCode},function(data){
				if(data == "true"){
					alert("操作成功");
				}
				else{
					alert("操作失败");
				}
			});
		
		}
    });
});

function autoCheck(node){
	for(var i in PageData.data){
		var data = PageData.data[i];
//		console.info("data.MODULEID:"+data.MODULEID);
//		console.info("node.attributes.nodeCode:"+node.attributes.nodeCode);
		if(data.MODULEID == node.attributes.nodeCode){
//			console.info("他有权限呀!");
			$('#permissionTree').tree("check", node.target);
			return;
		}
	}
//	console.info("他没有权限呀！");
}