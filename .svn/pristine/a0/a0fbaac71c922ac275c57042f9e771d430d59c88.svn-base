$(document).ready(function(){
	$("#password,#loginName").bind("keyup",function(event){
		var e = event || window.event;
		if(e.keyCode == 13){
			login();
		}
	});
	$("#loginBut").click(login);
	
});
function login(){
	$(".loginFormDiv").removeClass("has-error");  //TODO
	$("#loginBut").attr("disabled","disabled");
	var $loginName = $("#loginName");
	var $password = $("#password");
	if($.trim($loginName.val())  == ""){
		prompt("用户名不能为空", "errorP");	//TODO
		$loginName.parent(".loginFormDiv").addClass("has-error");
		$loginName.focus();
		$("#loginBut").removeAttr("disabled");
	}else if($.trim($password.val()) == ""){
		prompt("密码不能为空", "errorP");
		$password.parent(".loginFormDiv").addClass("has-error");
		$password.focus();
		$("#loginBut").removeAttr("disabled");
	}else{
		$.post("administratorController/login.do",{LOGINNAME : $loginName.val(), PASSWORD: $password.val()},function(data){
			if(data == -1){
				prompt("账号错误", "errorP");
				$loginName.parent(".loginFormDiv").addClass("has-error");
				$password.parent(".loginFormDiv").addClass("has-error");
				$loginName.focus();
			}
			else if(data == 0){
				prompt("账号错误", "errorP");
				$loginName.focus();
			}
			else{
				window.location.href = "manage.html";
			}
			$("#loginBut").removeAttr("disabled");
		});
	}
}
function prompt(content, className){
	$("#error-info").html(content).removeClass().addClass(className);
}
