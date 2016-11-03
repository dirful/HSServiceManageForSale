package com.cqut.controller.ServiceMessageType;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.service.ServiceMessageType.IServiceMessageTypeService;

@Controller
@RequestMapping("/serviceMessageTypeController")
public class ServiceMessageTypeController{
	
	@Resource(name="serviceMessageTypeService")
	IServiceMessageTypeService service;
	
	// wxl显示所有的大类，小类
	@RequestMapping("/showAllType")
	@ResponseBody
	public String showAllType() {
		List<Map<String, Object>> list = service.showAllType();
		return JSONArray.fromObject(list).toString();
	}
//	// wxl显示所有的小类
//		@RequestMapping("/showAllSecondaryType")
//		@ResponseBody
//		public String showAllSecondaryType(String parentID) {
//			List<Map<String, Object>> list = service.showAllSecondaryType(parentID);
//			return JSONArray.fromObject(list).toString();
//		}
//		wxl显示对应的模板
		@RequestMapping("/showAllTemplate")
		@ResponseBody
		public String showAllTemplate(String type) {
			List<Map<String, Object>> list = service.showAllTemplate(type);
			return JSONArray.fromObject(list).toString();
		}
}
