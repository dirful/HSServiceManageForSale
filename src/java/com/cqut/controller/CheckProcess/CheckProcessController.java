package com.cqut.controller.CheckProcess;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.CheckProcess.CheckProcess;
import com.cqut.entity.ProcessDescription.ProcessDescription;
import com.cqut.service.CheckProcess.ICheckProcessService;
import com.cqut.tool.util.BeanUtil;

@Controller
@RequestMapping("/checkProcessController")
public class CheckProcessController{
	
	@Resource(name="checkProcessService")
	ICheckProcessService service;

    @RequestMapping("/savacheckProcess")
    @ResponseBody
    public String savacheckProcess(String processID,int orderNumber,String checkName,String checkUserID){
    	CheckProcess data=new CheckProcess();
    	data.setCheckName(checkName);
    	String ID=BeanUtil.createId();
		data.setID(ID);
    	data.setCheckUserID(checkUserID);
    	data.setOrderNumber(orderNumber);
    	data.setProcessID(processID);
    	int backValue = service.savacheckProcess(data);
        return  String.valueOf(backValue);
		}
	
}

