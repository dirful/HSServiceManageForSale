package com.cqut.controller.PermissionAssign;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.service.PermissionAssign.IPermissionAssignService;

@Controller
@RequestMapping("/permissionAssignController")
public class PermissionAssignController{
	
	@Resource(name="permissionAssignService")
	IPermissionAssignService service;
	
	@RequestMapping("/getPermissionAssignsByPermissionID")
	@ResponseBody
	public String getPermissionAssignsByPermissionID(String ID){
		return JSONArray.fromObject(service.getPermissionAssignByCondition(" permissionassign.PERMISSIONID = '"+ID+"' ")).toString();
	}
	
	/**
	 * 权限修改
	 * 胡定鹏
	 * @param checked	选中、取消选中节点
	 * @param roleID	权限ID
	 * @param moduleID	模块ID
	 * @return
	 */
	@RequestMapping("/checkPermissionAssign")
	@ResponseBody
	public String checkPermissionAssign(boolean checked,String roleID,String moduleID){
		return service.checkPermissionAssign(checked, roleID, moduleID) == 1?"true":"false";
	}
}
