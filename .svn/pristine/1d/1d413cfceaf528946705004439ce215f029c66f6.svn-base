package com.cqut.controller.Process;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.service.Process.IProcessService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.entity.Process.Process;
@Controller
@RequestMapping("/processController")
public class ProcessController{
	
	@Resource(name="processService")
	IProcessService service;
	//销售processID
	@RequestMapping("/getprocessID")
	@ResponseBody
	public String getprocessID(String ID){
		List<Map<String,Object>> list = service.getprocessID(ID);
		return JSONArray.fromObject(list).toString();
	}
	@RequestMapping("/savaprocess")
	@ResponseBody
	public String savaprocess(String processCode,String processName,long createTime,int processType,int processState,int type){
//		String id =EntityIDFactory.createId();
		String id=BeanUtil.createId();
		Process process=new Process();
		Date date = new Date();
		date.setTime(createTime);
		process.setCreateTime(date);
		process.setID(id);
		process.setProcessName(processName);
		process.setProcessState(processState);
		process.setProcessType(processType);
		process.setType(type);
		int backValue = service.savaprocess(process);
		return  String.valueOf(backValue);
	}		
			
}
