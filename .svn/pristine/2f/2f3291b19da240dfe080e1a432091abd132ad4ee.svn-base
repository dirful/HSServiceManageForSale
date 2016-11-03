package com.cqut.controller.employee;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cqut.service.employee.IEmployeeService;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {

	@Resource(name = "employeeService")
	IEmployeeService service;
	
	
	/**
	 * txk
	 */
	@RequestMapping("/getEmployee")
	@ResponseBody
	public String getEmployee() {
		List<Map<String, Object>> list = service.getEmployee();
		System.out.println(list);
			return JSONArray.fromObject(list).toString();
		
	}
	
	// wxl 根据ID 查询用户信息并显示
	@RequestMapping("/getEmployeeByID")
	@ResponseBody
	public String getEmployeeByID(HttpSession httpSession) {
		Object EmployeeID = httpSession.getAttribute("ID");
		List<Map<String, Object>> list = service.getEmployeeByID((String) EmployeeID);
		if (list.size() == 0) {
			return "false";
		} else {
			return JSONArray.fromObject(list).toString();
		}
	}

	// wxl 根据ID 更新用户姓名
	@RequestMapping("/updateEmployeenameByID")
	@ResponseBody
	public String updateEmployeenameByID(String ID, String employeename) {
		return service.updateEmployeenameByID(ID, employeename) == 1 ? "true"
				: "false";

	}

	// wxl 根据ID 更新用户微信
	@RequestMapping("/updateWeChatByID")
	@ResponseBody
	public String updateWeChatByID(String ID, String wechat) {
		return service.updateWeChatByID(ID, wechat) == 1 ? "true" : "false";
	}

	// wxl 根据ID 更新用户地址
	@RequestMapping("/updateAddressByID")
	@ResponseBody
	public String updateAddressByID(String ID, String address) {
		return service.updateAddressByID(ID, address) == 1 ? "true" : "false";
	}

	// wxl 在用户的个人中心修改用户的头像并实时显示出来
	@RequestMapping("/editUserPicByID")
	@ResponseBody
	public String editUserPicByID(String ID,String PICID) {
		return service.updatePropByID(ID, PICID) == 1 ? "true" : "false";
	}
	
	/**
	 * 胡定鹏
	 * 判断是否登录
	 * @param url 身份验证成功后跳转的网址
	 * @param session
	 * @return
	 */
	@RequestMapping("/determineLogin")
	public String determineLogin(String url,HttpSession session,HttpServletResponse response){
		System.out.println("ID:"+session.getAttribute("ID"));
		if(session.getAttribute("ID") != null && session.getAttribute("ID") != ""){
			return "true";
		}
		return  "redirect:"+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/weChatAccess/oAuth.do"+"?url="+url;
	}
}