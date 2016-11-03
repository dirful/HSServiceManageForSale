package com.cqut.service.ProcessDescription;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.ProcessDescription.ProcessDescriptionDao;
import com.cqut.entity.CheckProcess.CheckProcess;
import  com.cqut.entity.ProcessDescription.ProcessDescription;

@Service
public class ProcessDescriptionService extends SearchService implements IProcessDescriptionService{
	
	@Resource(name="processDescriptionDao")
	ProcessDescriptionDao dao ;

	@Override
	public String getBaseEntityName() {
		return "processDescription";
	}

	@Override
	public String getBasePrimaryKey() {
		return "processDescription.ID";
	}
	
	/**
	 * 胡定鹏
	 * 保存流程描述信息
	 * @param processDescription
	 * @return
	 */
	//保存流程信息
	@Override
	public int saveProcessDescription(ProcessDescription processDescription){
		return dao.save(processDescription);
	}
	
	/**
	 * 修改流程描述信息
	 */
	@Override
	public int updateProcessDescription(ProcessDescription processDescription){
		return dao.updateByID(processDescription, processDescription.getID());
	}
	
	/**
	 * 胡定鹏
	 * 传入条件，获取流程描述信息
	 */
	@Override
	public List<ProcessDescription> getProcessDescriptionByCondition(String condition){
		return dao.getByCondition(condition);
	}
	
	/**
	 * 胡定鹏
	 * 传入报销ID、排序方式，关联了员工表
	 */
	@Override
	public List<Map<String,Object>> originalSearchForeign(String quotedPriceID,String sort){
		String condition=" e.ID=pd.checkUserID AND pd.submitAccountID='"+quotedPriceID+"' order by pd.orderNumber "+sort+" ";
		return this.originalSearchForeign(new String[]{"pd.*","e.employeeName"}, "processdescription AS pd,", "employee AS e", null, condition , false);
	}

	public int savaProcessDescription(ProcessDescription data) {
		String ID=BeanUtil.createId();
		data.setID(ID);
		return dao.save(data);
		
	}
}
