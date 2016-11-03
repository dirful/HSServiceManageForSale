package com.cqut.controller.Session;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.employee.Employee;
import com.cqut.service.employee.IEmployeeService;
import com.cqut.tool.util.PropertiesTool;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/sessionController")
public class SessionController {
	
	@Resource(name = "employeeService")
	IEmployeeService employeeService;
	
	/**
	 * liyang
	 * 获取Session中的值
	 * 需要获取指定的session值时，需要向keys数组传递参数
	 * 当keys数组中没有参数时，返回所有的session值
	 * */
	@RequestMapping("/get")
	@ResponseBody
	public String get(String[] keys,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, String> smap = new HashMap<String, String>();
			if(keys == null || keys[0] == null){/** 返回指定的session中所有key的值*/
				Enumeration<String> all = request.getSession().getAttributeNames();
				while( all.hasMoreElements())   {   
				    String sessionName=(String)all.nextElement();
				    try{
				    smap.put(sessionName, request.getSession().getAttribute(sessionName).toString());
				    }catch (NullPointerException e) {
						continue;
					}
				}
				
			}else{ /** 返回指定的session的指定的key数组的值*/
				for(String key : keys){
					try{
					smap.put(key, request.getSession().getAttribute(key).toString());
					}catch (NullPointerException e) {
							continue;
					}
				}
			}
			map.put("session", smap);
			map.put("resultCode", 1);
			return JSONObject.fromObject(map).toString(); /** 返回指定的session的值*/
		}catch (Exception e) {
			map.put("resultCode", 0);
		}
		return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * liyang
	 * 用户注销
	 * */
	@RequestMapping("/loginout")  
	@ResponseBody
	public void clearSession(HttpServletRequest request){
		request.getSession().invalidate();
		HttpSession session = request.getSession();
	}
	
	/**
	 * 初始化session
	 * @param request
	 * @param employeeid
	 */
	public static void initSession(Employee employee,HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println(employee);
		session.setAttribute("ID", employee.getID());
		session.setAttribute("employeeName", employee.getEmployeeName());
		session.setAttribute("accounts", employee.getAccounts());
		session.setAttribute("sex", employee.getSex());
		session.setAttribute("companyID", employee.getCompanyID());
		session.setAttribute("departmentID", employee.getDepartmentID());
		session.setAttribute("headPhoto", employee.getHeadPhoto());
		session.setAttribute("dutiesID", employee.getDutiesID());
		session.setAttribute("IDcard", employee.getIDcard());
		session.setAttribute("joinTime", employee.getJoinTime());
		session.setAttribute("createTime", employee.getCreateTime());
		session.setAttribute("phoneNumber", employee.getPhoneNumber());
		session.setAttribute("address", employee.getAddress());
		session.setAttribute("wechat", employee.getWechat());
		session.setAttribute("eMail", employee.getEMail());
		session.setAttribute("attentionState", employee.getAttentionState());
		session.setAttribute("remarks", employee.getRemarks());
	}
	@RequestMapping("/getIp")
	@ResponseBody
	public String getIp(HttpServletRequest request){
		return PropertiesTool.getSystemPram("imgRoute");
	}
	
	/**
	 * 验证是否登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/verifyLogin")
	@ResponseBody
	public String verifyLogin(HttpServletRequest request){
		HttpSession session=request.getSession();
		Map<String, String> map=new HashMap<String, String>();
		String en=(String) session.getAttribute("NAME");
		System.out.println("name:"+session.getAttribute("NAME"));
		if(en == null){
			map.put("verify", "0");
		}else{
			map.put("verify", "1");
			map.put("name", en);
		}
		return JSONObject.fromObject(map).toString();
	}
}
