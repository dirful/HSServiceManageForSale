package com.cqut.controller.SaleLog;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cqut.entity.SaleLog.SaleLog;
import com.cqut.service.SaleLog.ISaleLogService;
import com.cqut.tool.util.BeanUtil;

@Controller
@RequestMapping("/saleLogController")
public class SaleLogController{
	
	@Resource(name="saleLogService")
	ISaleLogService service;
	//谭小康的数据信息

	//后台获取数据
	@RequestMapping("/getsalelog")
	@ResponseBody
	public String getsalelog(int rows,int page,String order,String sort,String condition,String startime,String stoptime){
		List<Map<String, Object>> salelog=service.getsalelog(rows,page,order,sort,condition,startime,stoptime);
		int account=service.getSaleLog(condition);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", account);
		map.put("rows", salelog);
		return JSONObject.fromObject(map).toString();
	}
	//后台添加销售日志
	@RequestMapping("/savaSaleLogbehind")
	@ResponseBody
	public String savaSaleLogbehind(SaleLog data){
		data.setID(BeanUtil.createId());
		System.out.println("数据："+data);
		return service.savaSaleLogbehind(data)==1?"true":"false";
	}
	//后台改变状态
		@RequestMapping("/savastate")
		@ResponseBody
		public String savastate(String ID,int condition){
			SaleLog data=service.getState(ID);
			data.setState(condition);
			return service.updatastate(data)==1?"true":"false";
		}
	//后台修改销售日志
	@RequestMapping("/updataSaleLog")
	@ResponseBody
	public String updataSaleLog(SaleLog data){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("SaleLogName", data.getSaleLogName());
		map.put("SaleLogTypeCode", data.getSaleLogTypeCode());
		return service.updataSaleLog(map,data.getID())==1?"true":"false";
	}
	//后台删除日志
	@RequestMapping("/deleteSaleLog")
	@ResponseBody
	public String deleteSaleLog(String[] ids){
		try{
			return String.valueOf(service.deleteSaleLog(ids));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "-1";
	}
	//前台
	//销售数据信息
		@RequestMapping("/getSalelog")
		@ResponseBody
		public String getSalelog(HttpSession session){
			String ID=(String)session.getAttribute("ID");
			List<Map<String,Object>> list = service.getSalelog(ID);
			return JSONArray.fromObject(list).toString();
		}
		//销售详细信息
		@RequestMapping("/getdetail")
		@ResponseBody
		public String getdetail(String ID){
			List<Map<String,Object>> list = service.getdetail(ID);
			return JSONArray.fromObject(list).toString();
		}
		
	/*	
		//获取OfferorsID
		@RequestMapping("/getOfferorsID")
		@ResponseBody
		public String getOfferorsID(HttpSession session){
			String ID=(String)session.getAttribute("ID");
			List<Map<String,Object>> list = service.getOfferorsID(ID);
			return JSONArray.fromObject(list).toString();
		}*/
		
	//保存数据
	@RequestMapping("/savaSaleLog")
	@ResponseBody
	public String savaSaleLog(String saleLogName,int Assignments,String OfferorsID,String processID,int ContractVolume,String templetID,int Phone,int Email,int Visit,int Receivableamount,int List,String Contents,String CustomerName,String ContactID,String Purpose,String Results,long createTime){
		String salelogcode="";
		int x=0;
		Random input=new Random();
		String []code="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
		for(int i=0;i<2;i++){
		x=input.nextInt(26);
	    salelogcode+=code[x];
	    }
		salelogcode+=BeanUtil.createId();
		Date date = new Date();
		SaleLog data = new SaleLog();
		data.setSaleLogTypeCode(salelogcode);
		data.setAssignments(Assignments);
		data.setContractVolume(ContractVolume);
		data.setPhone(Phone);
		data.setEmail(Email);
		data.setVisit(Visit);
		data.setSaleLogName(saleLogName);
		data.setList(List);
		data.setCustomerName(CustomerName);
		data.setContactID(ContactID);
		data.setPurpose(Purpose);
		data.setResults(Results);
		date.setTime(createTime);
		data.setCreateTime(date);
		data.setContents(Contents);
		data.setReceivableamount(Receivableamount);
		data.setTempletID(templetID);
		data.setOfferorsID(OfferorsID);
		data.setProcessID(processID);
//      data.setSaleLogTypeID(saleLogTypeID);
//	    saveID.setID(ID);
		int backValue = service.savaSaleLog(data);
		return  String.valueOf(backValue);
	}
/*	//删除
	@RequestMapping("/delete")
	@ResponseBody
	public String deleget(String ID){
		 int list = this.service.delete(ID);
		return String.valueOf(list);
	}
*/
	
}
