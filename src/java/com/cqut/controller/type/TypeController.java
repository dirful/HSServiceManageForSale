package com.cqut.controller.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.SaleLog.SaleLog;
import com.cqut.entity.type.Type;
import com.cqut.service.type.ITypeService;

@Controller
@RequestMapping("/typeController")
public class TypeController{
	
	@Resource(name="typeService")
	ITypeService service;
	
//选择类型
	@RequestMapping("/getSalelogByCondition")
	@ResponseBody
	public String getSalelogByCondition(String condition){
		List<Type> list = service.getSalelogByCondition(condition);
		return JSONArray.fromObject(list).toString();
	}
//销售数据信息
	@RequestMapping("/getType")
	@ResponseBody
	public String getType(String ID){
		List<Map<String,Object>> list = service.getType(ID);
		return JSONArray.fromObject(list).toString();
	}
	
//换级
	@RequestMapping("/getnext")
	@ResponseBody
	public String getnext(int rows,int page,String order,String sort,String condition,String PARENTID){
		List<Map<String, Object>> type=service.getnext(rows,page,order,sort,condition);
		if(condition!=null)
		{
		
			if(PARENTID==null)
			   condition=" PARENTID='"+condition+"' ";
			else condition=null;
			List<Map<String, Object>> typee=service.getnext(rows,page,order,sort,condition);
				type=typee;
		}
		int account=service.gettype(condition);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", account);
		map.put("rows", type);
		return JSONObject.fromObject(map).toString();
}
//改变状态
	@RequestMapping("/savastate")
	@ResponseBody
	public String savastate(String ID,int condition){
		Type data=service.getState(ID);
		data.setSTATE(condition);
		return service.updatastate(data)==1?"true":"false";
	}
//修改分类
	@RequestMapping("/updataType")
	@ResponseBody
	public String updataType(Type data){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("DESCRIPTION", data.getDESCRIPTION());
		map.put("CODE", data.getCODE());
		map.put("NAME", data.getNAME());
		map.put("STATE", data.getSTATE());
		return service.updataType(map,data.getID())==1?"true":"false";
	}
//删除类型
	@RequestMapping("/deleteType")
	@ResponseBody
	public String deleteType(String[] ids){
		try{
			return String.valueOf(service.deleteType(ids));
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return "-1";
	}
}
