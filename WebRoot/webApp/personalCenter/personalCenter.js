var k = "";
var id = "1";
$(document).ready(function() {
	showMessage();
});
function showMessage() {
	$.ajax({
				url : "../../employeeController/getEmployeeByID.do",
				async : false,
				data : {},
				type : "post",
				success : function(data) {
					var EmployeeList = $.parseJSON(data);
					var photoName = EmployeeList[0].photoName;
					var empname = EmployeeList[0].employeename;
					var weChat = EmployeeList[0].wechat;
					var address = EmployeeList[0].address;
					var department = EmployeeList[0].departmentName;
					var duties = EmployeeList[0].duties;

					if (photoName == "" || photoName == undefined
							|| photoName == null) {
						$("#picture111").attr("src", "img/1.jpg");
					} else {
						$("#picture111").attr("src", photoName);
					}
					if (empname == "" || empname == undefined
							|| empname == null) {
						$("#realName").html("暂无");
					} else {
						$("#realName").html(empname);
					}
					if (weChat == "" || weChat == undefined || weChat == null) {
						$("#weChat").html("暂无");
					} else {
						$("#weChat").html(weChat);
					}
					if (address == "" || address == undefined
							|| address == null) {
						$("#address").html("暂无");
					} else {
						$("#address").html(address);
					}
					if (department == "" || department == undefined
							|| department == null) {
						$("#department").html("暂无");
					} else {
						$("#department").html(department);
					}
					if (duties == "" || duties == undefined || duties == null) {
						$("#post").html("暂无");
					} else {
						$("#post").html(duties);
					}
				}
			});

}
// 修改信息
function revise(p) {
	// 0头像，1名称，2微信号，3二维码，4地址，5签名
	$("#specific").hide();
	$(".change").show();
	$(".xiugaijiemian").show();
	if (p == 1) {
		k = 1;
		var name = $("#realName").text();
		if(name =="" || name =="暂无"){
			$(".data0").val("");
		}else{
			$(".data0").val(name);
		}
		$(".tishi").html("您的真实姓名！");
	} else if (p == 2) {
		k = 2;
		var weChat = $("#weChat").text();
		if(weChat =="" || weChat =="暂无"){
			$(".data0").val("");
		}else{
			$(".data0").val(weChat);
		}
		$(".tishi").html("您的微信号！");
	} else if (p == 4) {
		k = 4;
		var address = $("#address").text();
		if(address =="" || address == "暂无"){
			$(".data0").val("");
		}else{
			$(".data0").val(address);
		}
		$(".tishi").html("您的真实地址！");
	} else if (p == 5) {
		k = 5;
		$(".tishi").html("您的签名！");
	}
}
// 放弃修改
function giveUp() {
	$("#specific").show();
	$(".change").hide();
	$(".xiugaijiemian").hide();
}
// 保存修改
function keep() {
	$("#specific").show();
	$(".change").hide();
	$(".xiugaijiemian").hide();
	var mes = $(".data0").val();
	var ad = $.trim(mes);
	if(ad==""){ad="暂无";}
	if (k == 1) {
		document.getElementById('realName').innerHTML = '' + ad;
		saveName(ad);
	} else if (k == 2) {
		document.getElementById('weChat').innerHTML = '' + ad;
		saveWeChat(ad);
	} else if (k == 4) {
		document.getElementById('address').innerHTML = '' + ad;
		saveAddress(ad);
	} else if (k == 5) {
		document.getElementById('Signature').innerHTML = '' + ad;
		saveSignature(ad);
	}
}
function saveName(q) {
	$.ajax({
		url : "../../employeeController/updateEmployeenameByID.do",
		async : false,
		data : {
			ID : id,
			employeename : q
		},
		type : "post",
		success : function(data) {
			if (data == "true") {
				alert("修改成功");
			} else {
				("修改失败");
			}
		}
	});
}
function saveWeChat(q) {
	$.ajax({
		url : "../../employeeController/updateWeChatByID.do",
		async : false,
		data : {
			ID : id,
			wechat : q
		},
		type : "post",
		success : function(data) {
			alert(data);
			if (data == "true") {
				alert("修改成功");
			} else {
				alert("修改失败");
			}
		}
	});
}
function saveAddress(q) {
	$.ajax({
		url : "../../employeeController/updateAddressByID.do",
		async : false,
		data : {
			ID : id,
			address : q
		},
		type : "post",
		success : function(data) {
			if (data == "true") {
				alert("修改成功");
			} else {
				alert("修改失败");
			}
		}
	});
}
//修改头像
//图片上传及实时显示
$(".changeButton").fileupload({
	dataType : 'json',
	success : function(result) {
		var photoName = result.ID+".jpg";
		if (result && result.ID) {
			$("#picture").attr("src",photoName);
			console.info(photoName);
			$("#tupian").val(result.ID);
			edituser(id, result.ID);
		}
	}
});
function edituser(userID, picID) {
	var photoName = picID+".jpg";
	$.ajax({
		cache : true,
		type : "POST",
		url : "../../employeeController/editUserPicByID.do",
		data : {ID : userID,
			   PICID : picID}, 
		async : false,
		error : function(request) {
			alert("修改失败！");
		},
		success : function(data) {
			if (data == "true") {
				alert("修改成功");
				$("#picture111").attr("src","http://localhost:8282/img/"+ photoName);
			} else {
				alert("修改失败");
			}
		}
	});
}
