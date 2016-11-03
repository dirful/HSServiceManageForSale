package com.cqut.controller.SaleLogType;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.SaleLogType.SaleLogType;
import com.cqut.service.SaleLogType.ISaleLogTypeService;

@Controller
@RequestMapping("/saleLogTypeController")
public class SaleLogTypeController{
	
	@Resource(name="saleLogTypeService")
	ISaleLogTypeService service;
	
	@RequestMapping("/getSalelogByCondition")
	@ResponseBody
	public String getSalelogByCondition(String condition){
		List<SaleLogType> list = this.service.getSalelogByCondition(condition);
		return JSONArray.fromObject(list).toString();
	}
}
