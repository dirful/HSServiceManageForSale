package com.cqut.service.Process;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.Process.ProcessDao;
import  com.cqut.entity.Process.Process;
import com.cqut.entity.ProcessDescription.ProcessDescription;
import com.cqut.entity.SaleLog.SaleLog;

@Service
public class ProcessService extends SearchService implements IProcessService{
	
	@Resource(name="processDao")
	ProcessDao dao ;

	@Override
	public String getBaseEntityName() {
		return "process";
	}

	@Override
	public String getBasePrimaryKey() {
		return "process.ID";
	}
	//获取流程ID
	@Override
	public List<Map<String, Object>> getprocessID(String ID){
//	String condition =" process.ID = = '"+ID+"' ";
		String condition =" process.processType=1&&process.type=0 ";
		String [] properties ={
				" process.ID as processID ",
				" employee.ID "
};
		String baseEntity = " process,employee ";
		String joinEntity="";
		List<Map<String, Object>> list = this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
		return list;
	}
	public int savaprocess(Process process) {	
		return dao.save(process);
	}
	
	@Override
	public Process getprocessByID(String ID){
		return dao.getByID(ID);
	}
}
