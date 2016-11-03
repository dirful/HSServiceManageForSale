package com.cqut.controller.ProcessDescription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.CheckProcess.CheckProcess;
import com.cqut.entity.ProcessDescription.ProcessDescription;
import com.cqut.entity.QuotedPrice.QuotedPrice;
import com.cqut.entity.SaleLog.SaleLog;
import com.cqut.service.CheckProcess.ICheckProcessService;
import com.cqut.service.Process.IProcessService;
import com.cqut.service.ProcessDescription.IProcessDescriptionService;
import com.cqut.service.QuotedPrice.IQuotedPriceService;
import com.cqut.service.SaleLog.ISaleLogService;
import com.cqut.service.employee.IEmployeeService;
import com.cqut.tool.util.BeanUtil;

@Controller
@RequestMapping("/processDescriptionController")
public class ProcessDescriptionController{
	
	@Resource(name="processDescriptionService")
	IProcessDescriptionService service;
	
	@Resource(name = "quotedPriceService")  
	IQuotedPriceService quotedPriceService;
	
	@Resource(name = "checkProcessService")
	ICheckProcessService checkProcessservice;
	
	@Resource(name="processService")
	IProcessService processService;
	
	@Resource(name="employeeService")
	IEmployeeService employeeService;
	
	@Resource(name="saleLogService")
	ISaleLogService saleLogService;
	

	/** 
	 * 方法简述：通过ID获取报价详情
	 * @author 常景胜
	 * @param session
	 * @param quotedPriceID
	 * @param sort
	 * @return 
	 * 
	 */
	@RequestMapping("/originalSearchForeign")
	@ResponseBody
	public String originalSearchForeign(HttpSession session,String quotedPriceID,String sort){
		String userID = (String) session.getAttribute("ID");
		userID = "111";	
		String isMine = "0"; 
		QuotedPrice qp = quotedPriceService.getQuotedPriceByID(quotedPriceID);
		List<Map<String, Object>> checkProcessList = checkProcessservice
				.getCheckProcess(" p.processState='1' AND cp.processID = p.ID ");
		for (int i = 0; i < checkProcessList.size(); i++) {
			if (!checkProcessList.get(i).get("CHECKUSERID").toString()
					.contains(userID)) {
				checkProcessList.remove(i);
				i--;
			}
		}
		StringBuffer condition = new StringBuffer();
		StringBuffer pdCondition = new StringBuffer();
//		StringBuffer slCondition = new StringBuffer();
		pdCondition.append(" qp.state != '-1' ");
		for (int i = 0; i < checkProcessList.size(); i++) {
//			if (checkProcessList.size()-i != 0) {
//				pdCondition.append(" AND ");
//			}
			if (i == 0) {
				pdCondition.append(" AND ");
				condition.append(" (");
			}
			if (i != 0) {
				condition.append(" || ");
			}
			condition.append("( pd.processID='"
					+ checkProcessList.get(i).get("PROCESSID")
					+ "' && pd.orderNumber='"
					+ (Integer.parseInt(checkProcessList.get(i)
							.get("ORDERNUMBER").toString())) + "')");
			if (i == (checkProcessList.size() - 1)) {
				condition.append(") ");
			}
		}


		//判断当前表的内容是否是自己的
		if(userID.equals(qp.getOfferorsID())){
			isMine = "1";
			condition.replace(0, condition.length()-1, "pd.orderNumber = 1 " );
		}
		// 取出报价审批信息
		List<Map<String, Object>> quotedPriceList = quotedPriceService
				.getQuotedPriceByConditon(
						pdCondition.append(condition + "AND pd.submitAccountID = " + quotedPriceID).toString());
		com.cqut.entity.Process.Process p = processService.getprocessByID(qp.getProcessID());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isMine", isMine);
		map.put("userName",employeeService.getByID(qp.getOfferorsID()).getEmployeeName());
		map.put("p", p);
		map.put("qpl", quotedPriceList);
		map.put("qp",qp);
		map.put("remark", service.originalSearchForeign(quotedPriceID,sort));
		return JSONArray.fromObject(map).toString();
	}
	/** 
	 * 方法简述：通过ID获取报销详情
	 * @author 常景胜
	 * @param session
	 * @param quotedPriceID
	 * @param sort
	 * @return 
	 * 
	 */
	@RequestMapping("/theSaleLogOfOriginalSearchForeign")
	@ResponseBody
	public String theSaleLogOfOriginalSearchForeign(HttpSession session,String saleLogID,String sort){
		String userID = (String) session.getAttribute("ID");
		userID = "111";
		String isMine = "0";
		List<Map<String, Object>> checkProcessList = checkProcessservice
				.getCheckProcess(" p.processState='1' AND cp.processID = p.ID AND p.processType = '1'");
		for (int i = 0; i < checkProcessList.size(); i++) {
			if (!checkProcessList.get(i).get("CHECKUSERID").toString()
					.contains(userID)) {
				checkProcessList.remove(i);
				i--;
			}
		}
		StringBuffer condition = new StringBuffer();
		StringBuffer pdCondition = new StringBuffer();
//		StringBuffer slCondition = new StringBuffer();
		pdCondition.append(" sl.state != '-1' ");
		for (int i = 0; i < checkProcessList.size(); i++) {
//			if (checkProcessList.size()-i != 0) {
//				pdCondition.append(" AND ");
//			}
			if (i == 0) {
				pdCondition.append(" AND ");
				condition.append(" (");
			}
			if (i != 0) {
				condition.append(" || ");
			}
			condition.append("( pd.processID='"
					+ checkProcessList.get(i).get("PROCESSID")
					+ "' && pd.orderNumber='"
					+ (Integer.parseInt(checkProcessList.get(i)
							.get("ORDERNUMBER").toString())) + "')");
			if (i == (checkProcessList.size() - 1)) {
				condition.append(") ");
			}
		}
		SaleLog sl =  saleLogService.getState(saleLogID);
		// 取出报价审批信息
		if(userID.equals(sl.getOfferorsID())){
			isMine = "1";
			condition.replace(0, condition.length()-1, "pd.orderNumber = 1 " );
		}
		List<Map<String, Object>> saleLogList = quotedPriceService
				.getMySaleLogByConditon(
						pdCondition.append(condition + "AND pd.submitAccountID = " + saleLogID).toString());
		com.cqut.entity.Process.Process p = processService.getprocessByID(sl.getProcessID());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isMine", isMine);
		map.put("userName",employeeService.getByID(sl.getOfferorsID()).getEmployeeName());
		map.put("p", p);
		map.put("sll", saleLogList);
		map.put("sl",sl);
		map.put("remark", service.originalSearchForeign(saleLogID,sort));
		return JSONArray.fromObject(map).toString();
	}
	/*
	 * txk
	 */
	@RequestMapping("/savaProcessDescription")
	@ResponseBody
	public String savaProcessDescription(ProcessDescription data){
		data.setID(BeanUtil.createId());
		int list = service.saveProcessDescription(data);
		return String.valueOf(list);
	}
}
