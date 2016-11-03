package com.cqut.controller.Templet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.Project.Project;
import com.cqut.entity.Templet.Templet;
import com.cqut.service.Templet.ITempletService;
import com.cqut.tool.json.JsonTool;

@Controller
@RequestMapping("/templetController")
public class TempletController{
	
	@Resource(name="templetService")
	ITempletService service;
	//获得str0
	@RequestMapping("/getstr")
	@ResponseBody
	public String getstr(String conditions){	
		List<Map<String,Object>> back =service.getstr(conditions);
		return  JSONArray.fromObject(back).toString();
	}
//	wxl 查询服务消息模板
	@RequestMapping("/getServiceMessageTemplet")
	@ResponseBody
	public String getServiceMessageTemplet(int rows, int page, String order, String sort, String condition){
		List<Map<String, Object>> list = service.getServiceMessageTemplet(rows, page, order, sort, condition);
		return JSONArray.fromObject(list).toString();
	}
//wxl 删除服务消息模板	
	@RequestMapping("/deleteServiceTemplet")
	@ResponseBody
	public String deleteServiceTemplet(String ID){
		return String.valueOf(service.deleteServiceTemplet(ID));
	}
	
/**************************后台************************************************************/
	
	/**
	 * cyb	*
	 * 获取项目信息模板采集模板 *
	 */
	@RequestMapping("/getProjectInfoTempletListWithPaging")
	@ResponseBody
	public String getProjectInfoTempletListWithPaging(int rows, int page, String orderFiled,
			String sortMode, String condition) {
		return JsonTool.toJson(service.getProjectInfoTempletListWithPaging(rows, page, orderFiled, sortMode, condition));
	}
	
	/**
	 * cyb
	 * 删除项目信息采集模板*
	 */
	@RequestMapping("/deleteTemplets")
	@ResponseBody
	public String deleteTemplets(String[] IDs){
		return service.deleteTemplets(IDs)==1?"true":"false";
	}
	
//	/**修改项目信息采集模板
//	 * @throws ParseException */
//	@RequestMapping("/updatePropTempletByID")
//	@ResponseBody
//	public String updatePropTempletByID(Templet templet,String ID) throws ParseException{
////		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////		System.out.println(CREATETIME);
////		Date createTime=dateFormat.parse(CREATETIME);
////		System.out.println(createTime);
////		templet.setCreateTime(createTime);
//		
//		return service.updatePropTempletByID(templet,ID)==1?"true":"false";
//	}
//	
	
}
