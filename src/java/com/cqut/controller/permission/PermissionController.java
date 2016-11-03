package com.cqut.controller.permission;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.permission.Permission;
import com.cqut.service.permission.IPermissionService;
import com.cqut.tool.json.JsonTool;

@Controller
@RequestMapping("/permissionController")
public class PermissionController {

	@Resource(name = "permissionService")
	IPermissionService service;

	@RequestMapping("/getPermissionTree")
	@ResponseBody
	public String getPermissionTree() {
		String result = JsonTool.toJsonList(service.getPermissionTree()
				.getNodes());
		return result;
	}

	@RequestMapping("/getPermissionByCondition")
	@ResponseBody
	public String getPermissionByCondition(String condition){
		return JSONArray.fromObject(service.getPermissionByCondition(condition)).toString();
	}
	
	@RequestMapping("/getPermissionWithPageByCondition")
	@ResponseBody
	public String getPermissionWithPageByCondition(String condition, int rows, int page) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", service.getPermissionCountByCondition(condition));
		map.put("rows", service.getPermissionWithPageByCondition(condition, rows, page));
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping("savePermission")
	@ResponseBody
	public String savePermission(Permission p) {
		return service.savePermission(p) == 1 ? "true" : "false";
	}

	@RequestMapping("updataPermission")
	@ResponseBody
	public String updataPermission(Permission p) {
		return service.updataPermission(p) == 1 ? "true" : "false";
	}

	@RequestMapping("deletePermission")
	@ResponseBody
	public String deletePermission(String ID) {
		return service.deletePermission(ID) == 1 ? "true" : "false";
	}
}
