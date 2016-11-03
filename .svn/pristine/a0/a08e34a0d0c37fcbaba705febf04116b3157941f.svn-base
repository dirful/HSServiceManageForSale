package com.cqut.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.service.role.IRoleService;
import com.cqut.tool.json.JsonTool;

@Controller
@RequestMapping("/roleController")
public class RoleController{
	
	@Resource(name="roleService")
	IRoleService service;
	
	@RequestMapping("/getRoleTree")
	@ResponseBody
	public String getRoleTree() {
		String result = JsonTool.toJsonList(service.getRoleTree().getNodes());
		return result;
	}
}
