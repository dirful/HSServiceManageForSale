
var G = {session:{}};
G.basePath = function () {
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPaht = curWwwPath.substring(0, pos);
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return localhostPaht + projectName + "/";
}();
G.getPicPath = function(ID){
	if(!G.imgPath){
		$.ajax({
			async:false,
			url:G.basePath+"sessionController/getIp.do",
			success:function(data){
				G.imgPath = data;
			}
		})
	}
	return G.imgPath + ID +".jpg";
}

/*loadExtentFile("webapp/module/Frame/css/index.css","css");
loadExtentFile("frame/easyui/jquery.min.js","js");
loadExtentFile("webapp/module/Frame/js/index.js","js");*/

function loadFile(){
	loadExtentFile
}
function loadExtentFile(filePath, fileType) {
	filePath = G.basepath + filePath;
	if (fileType == "js") {
		var oJs = document.createElement('script');
		oJs.setAttribute("type", "text/javascript");
		oJs.setAttribute("src", filePath);//文件的地址 ,可为绝对及相对路径
		document.getElementsByTagName("head")[0].appendChild(oJs);//绑定
	} else if (fileType == "css") {
		var oCss = document.createElement("link");
		oCss.setAttribute("rel", "stylesheet");
		oCss.setAttribute("type", "text/css");
		oCss.setAttribute("href", filePath);
		document.getElementsByTagName("head")[0].appendChild(oCss);//绑定
	}
}