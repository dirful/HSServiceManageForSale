package com.cqut.controller.module;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.module.Module;
import com.cqut.service.module.IModuleService;
import com.cqut.tool.json.JsonTool;

@Controller
@RequestMapping("/moduleController")
public class ModuleController {

	@Resource(name = "moduleService")
	IModuleService service;

	@RequestMapping("/getModuleByPermission")
	@ResponseBody
	public String getModuleByPermission(HttpServletRequest request) {
		return JSONArray.fromObject(
				service.getModuleByPermission(request.getSession()
						.getAttribute("PERMISSIONID").toString())).toString();
	}

	@RequestMapping("/getModuleByCondition")
	@ResponseBody
	public String getModuleByCondition(String condition) {
		return JSONObject.fromObject(service.getModuleByCondition(condition)).toString();
	}

	@RequestMapping("/getModuleTree")
	@ResponseBody
	public String getModuleTree() {
		String result = JsonTool.toJsonList(service.getModuleTree()
				.getNodes());
		return result;
	}
	
	@RequestMapping("/getModuleWithPage")
	@ResponseBody
	public String getModuleWithPage(String condition ,int rows, int page){
		return JSONArray.fromObject(service.getModuleWithPage(condition, rows, page)).toString();
	}
	
	@RequestMapping("/saveModule")
	@ResponseBody
	public String saveModule(Module module) {
		return service.saveModule(module) == 1?"true":"false";
	}
	
	@RequestMapping("/updataModuleByID")
	@ResponseBody
	public String updataModuleByID(Module module) {
		return service.updataModuleByID(module) == 1?"true":"false";
	}
	
	@RequestMapping("/deleteModuleByID")
	@ResponseBody
	public String deleteModuleByID(String ID) {
		return service.deleteModuleByID(ID) == 1?"true":"false";
	}
}
