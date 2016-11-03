package com.cqut.controller.administrator;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.administrator.Administrator;
import com.cqut.service.administrator.IAdministratorService;

@Controller
@RequestMapping("/administratorController")
public class AdministratorController {

	@Resource(name = "administratorService")
	IAdministratorService service;

	@RequestMapping("/login")
	@ResponseBody
	public String login(Administrator administrator, HttpServletRequest request) {
		return service.login(administrator, request);
	}

	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		service.logout(request);
		return "";
	}

	@RequestMapping("/getAdminWithPageByCondtion")
	@ResponseBody
	public String getAdminWithPageByCondtion(String condition, int rows,
			int page) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rows", service.getAdminWithPageByCondtion(condition, rows, page));
		m.put("total", service.getAdminCountWithPageBycondition(condition));
		return JSONObject.fromObject(m).toString();
	}

	@RequestMapping("/saveAdmin")
	@ResponseBody
	public String saveAdmin(Administrator a) {
		return service.saveAdmin(a) == 1 ? "true" : "false";
	}

	@RequestMapping("/updataAdmin")
	@ResponseBody
	public String updataAdmin(Administrator a) {
		return service.updataAdmin(a) == 1 ? "true" : "false";
	}

	@RequestMapping("/deleteAdmin")
	@ResponseBody
	public String deleteAdmin(String ID) {
		return service.deleteAdmin(ID) == 1 ? "true" : "false";
	}

	@RequestMapping("/getAdministratorByID")
	@ResponseBody
	public String getAdministratorByID(String ID) {
		return JSONObject.fromObject(service.getAdministratorByID(ID))
				.toString();
	}

	@RequestMapping("/changePassWord")
	@ResponseBody
	public String changePassWord(String ID, String passWord, HttpServletRequest request) {
		if(ID == null || ID.equals("")){
			ID = String.valueOf(request.getSession().getAttribute("ID"));
		}
		return service.changePassWord(ID, passWord) == 1 ? "true" : "false";
	}
}
