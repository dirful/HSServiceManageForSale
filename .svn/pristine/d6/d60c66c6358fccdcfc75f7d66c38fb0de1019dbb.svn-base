var stain=" ";
var object;
$.ajax({
	url:"../../saleLogController/getSalelog.do",
	Type:"POST",
	data:{},
	async:false,
	success:function(data){
		var getData=$.parseJSON(data);
		object=getData;
		if(object==null)$("#xinzeng").show();
		if(!data.SaleLogTypeCode)
		{ stain="";
		
			for(var i=0;i<getData.length;i++)
			      {	
				$("#xinzeng").hide();
			   stain+='<div class="ProjectSubject">'+
	 '<div class="outside">'+
			'<div align="right">'+
					'<a href="Newadd.html"><img class="photo" src="img/u40.png" id="newadd" /></a>'+
					'<img class="photo" src="img/u46.png" onclick=date("'+getData[i].ID+'") />'+
			'</div>'+
				'<div class="inside">'+
					 '<div class="table" style="border-bottom:1px solid gray">'+
					 '<div class="inner"><div>日志编码</div><div class="DataContent">'+getData[i].SaleLogTypeCode+'</div></div>'+
					 '<div class="inner"><div>日志名称</div><div class="DataContent">'+getData[i].SaleLogName+'</div></div>'+
					 '<div class="inner"><div>所属大类</div><div class="DataContent">'+getData[i].groundfather+'</div></div>'+
					 '<div class="inner"><div>所属小类</div><div class="DataContent">'+getData[i].childrens+'</div></div>'+
					 '<div class="inner"><div>提交时间</div><div class="DataContent" >'+getData[i].CreateTime+'</div></div>'+
					 '</div>'+
				'</div>'+
	 '</div><br/>'+
	                  '</div><br/><br/>';
			   }
	$("body>#info").append(stain);
	     }
		else {alert("无数据!");}
	}
});
/*$("#newadd").click(function(event){
		var id = $(this).attr("id");
		$("#'"+id+"'").css("display","none");
		event.stopPropagation();
});*/
$(document).on("touchend","#clickBack",function(){
	setTimeout('$("#detail,#clickBack").hide()',200);
});


function date(q){
	$.ajax({
		url:"../../saleLogController/getdetail.do",
		Type:"POST",
		data:{ID:q},
		async:false,
		success:function(data){
			var getData=$.parseJSON(data);
			console.info(getData);
			var join='<div id="titles">销售详情</div>'+
			' <div id="styles">'+
			        '<div class="inner"><div >任务量</div>'+
				        '<div class="DataContent">'+
				              '<span id="Assignments" class="same">'+getData[0].Assignments+'</span>'+
				        ' </div> '+
						 '</div>'+
					'<div class="inner"><div >签约量</div>'+
					        '<div class="DataContent">'+
					             '<span id="ContractVolume" class="same">'+getData[0].ContractVolume+'</span>'+
					       ' </div> '+
						 '</div>'+
					'<div class="inner"><div >回款量</div>'+
						     '<div class="DataContent">'+
						           '<span id="Receivableamount" class="same">'+getData[0].Receivableamount+'</span>'+
						     '</div> '+
						 '</div>'+
					'<div class="inner"><div >销售日志</div>'+
							 '<div class="DataContent">'+
							      '<span id="SaleLogName" class="same">'+getData[0].SaleLogName+'</span>'+
							 '</div> '+
					     '</div>'+
				   '<div class="inner"><div >打电话</div>'+
							'<div class="DataContent">'+
								   '<span id="Phone" class="same">'+getData[0].Phone+'</span>'+
						    '</div> '+
					    '</div>'+
				   '<div class="inner"><div >发邮件</div>'+
						 '<div class="DataContent">'+
								 '<span id="Email" class="same">'+getData[0].Email+'</span>'+
						' </div> '+
					   '</div>'+
				   '<div class="inner"><div >拜访</div>'+
						'<div class="DataContent">'+
								'<span id="Visit" class="same">'+getData[0].Visit+'</span>'+
						 ' </div> '+
						'</div>'+
					'<div class="inner"><div >签单</div>'+
							'<div class="DataContent">'+
							    '<span id="List" class="same">'+getData[0].List+'</span>'+
							  ' </div> '+
						'</div>'+
					 '<div class="inner"><div >客户姓名</div>'+
							'<div class="DataContent">'+
							     '<span id="CustomerName" class="same">'+getData[0].CustomerName+'</span>'+
							' </div> '+
					   '</div>'+
					'<div class="inner"><div >联系人</div>'+
						'<div class="DataContent">'+
						     '<span id="ContactID" class="same">'+getData[0].ContactID+'</span>'+
						' </div> '+
				        '</div>'+
				        '<div class="inner"><div>日志编码</div>'+
						'<div class="DataContent">'+
						     '<span id="SaleLogTypeCode" class="same">'+getData[0].SaleLogTypeCode+'</span>'+
						' </div> '+
				        '</div>'+
					'<div class="inner"><div >拜访目的</div>'+
						'<div class="DataContent">'+
						     '<span id="Purpose" class="same">'+getData[0].Purpose+'</span>'+
						' </div> '+
					  '</div>'+
					'<div class="inner"><div >拜访结果</div>'+
					      '<div class="DataContent">'+
					         '<span id="Results" class="same">'+getData[0].Results+'</span>'+
					      '</div> '+
					 '</div>'+
					 '<div class="inner"><div >拜访时间</div>'+
						   '<div class="DataContent">'+
						     '<span id="CreateTime" class="same">'+getData[0].CreateTime+'</span>'+
						    '</div> '+
						'</div>'+
					'<div class="inner"><div >商谈内容:</div>'+
						  '<div class="DataContent">'+
						       '<span id="Contents" class="same">'+getData[0].Contents+'</span>'+
						   '</div> '+
					'</div>'+
			   '</div>';
			$("#clickBack").show();
			$("#detail").html(join).animate({height: 'toggle'},100);
			}
		});
	}