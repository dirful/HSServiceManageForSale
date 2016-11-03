 $(function(){ 
    	//初始表格
    	$('#dg').datagrid({  
	       // title : 'datagrid实例',  
	        width : 600,  
	        pageSize : 5,//默认选择的分页是每页5行数据  
	        pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
	        nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
	        striped : true,//设置为true将交替显示行背景。  
	        url:'goodsController/getGoodsWithPaging.do',//url调用Action方法  
	        loadMsg : '数据装载中......',  
	        //singleSelect:true,//为true时只能选择单行 为了实现批量删除必须隐去  
	        fitColumns:false,//允许表格自动缩放，以适应父容器  
	        pagination : true,//分页  
	        rownumbers : true//行数  .
	    });
    	
    	//初始化树
        $('#tree').tree({
            url: "goodsController/treeTest.do?location=root",
            onBeforeExpand: function (node) {
            	$('#tree').tree('options').url = "goodsController/treeTest.do?location=" + node.id;
            },
        	onClick: function (node) {
   			 $.messager.alert('消息',node.id);

        		/*if(node.prop)
        			 $.messager.alert('消息',node.prop.nodeCode);
        		else 
        			 $.messager.alert('消息',node.text);*/
            }
        });
    });  
    function sear() {
    	if($('#searchForm').form('validate')){
			var goodsName =  $('#goodsName').val();
    		$('#dg').datagrid({
    			 //url:'goodsController/getGoodsWithPaging.do?goodsName=' + goodsName//url调用Action方法  
    			queryParams:{goodsName : goodsName}
    		});
    		$('#dg').datagrid('reload'); 
    	}
    }
    
    function allRows() {
    	$('#dg').datagrid({
			 //url:'goodsController/getGoodsWithPaging.do'//url调用Action方法  
    		queryParams:{}
		});
    	$('#dg').datagrid('reload'); 
    }
    
    function addGoods() {
    	$('#dlg').dialog({
    		buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
					 $('#fm').form('submit',{
			                url: "goodsController/saveGoods.do",
			                onSubmit: function(){
			                    return $(this).form('validate');
			                },
			                success: function(result){
			                	$('#fm').form('clear');
			                	$('#dlg').dialog('close');  
			                	$('#dg').datagrid('reload');   
			                }
			          });
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#dlg').dialog('close')
				}
			}]
    	});
    	$('#dlg').dialog('open');
    }
    
    
    function editGoods(){
    	var rows = $('#dg').datagrid('getSelections');  
    	if(rows.length <= 0){
    		 $.messager.alert('消息','请选择');
    		return ;
    	} else if(rows.length > 1) {
    		 $.messager.alert('消息','只能选择一条数据');
    		return ;
    	}

		var row = rows[0];
		
    	$('#fm').form('load',row); 
    	$('#dlg').dialog({
    		buttons:[{
				text:'修改',
				iconCls:'icon-ok',
				handler:function(){
					$('#fm').form('submit',{
		                url: "goodsController/updateGoods.do",
		                onSubmit: function(){
		                    return $(this).form('validate');
		                },
		                success: function(result){
		                	$('#fm').form('clear');
		                	$('#dlg').dialog('close');  
		                	$('#dg').datagrid('reload');   
		                }
		          });
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#dlg').dialog('close')
				}
			}]
    	});
    	$('#dlg').dialog('open');
    }
    
    function removeGoods(){
		var rows = $('#dg').datagrid('getSelections');  
    	if(rows.length <= 0){
    		$.messager.alert('消息','请选择');
    		return ;
    	}
    	
    	var ids = [];
    	for(var i = 0; i < rows.length; i++) {
    		ids.push(rows[i].GOODSID);
    	}
    	
    	jQuery.ajaxSettings.traditional = true;
    	
    	console.dir(ids);
    	$.messager.confirm('选择框', '您确定删除吗?', function(r){
               if (r){
            	  $.post("goodsController/deleteEntities.do",{IDs:ids}, function(data){
            	   	$('#dg').datagrid('reload');   
         		  }); 
               } else {
            	   alert('删除失败');
               }
        });
    }