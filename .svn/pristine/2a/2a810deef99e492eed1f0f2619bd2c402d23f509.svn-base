package com.cqut.service.duties;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.duties.DutiesDao;
import  com.cqut.entity.duties.Duties;

@Service
public class DutiesService extends SearchService implements IDutiesService{
	
	@Resource(name="dutiesDao")
	DutiesDao dao ;

	@Override
	public String getBaseEntityName() {
		return "duties";
	}

	@Override
	public String getBasePrimaryKey() {
		return "duties.ID";
	}
	
}
