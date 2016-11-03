package com.cqut.service.SaleLogType;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.SaleLogType.SaleLogTypeDao;
import  com.cqut.entity.SaleLogType.SaleLogType;

@Service
public class SaleLogTypeService extends SearchService implements ISaleLogTypeService{
	
	@Resource(name="saleLogTypeDao")
	SaleLogTypeDao dao ;

	@Override
	public String getBaseEntityName() {
		return "saleLogType";
	}

	@Override
	public List<SaleLogType> getSalelogByCondition(String condition) {
		// TODO Auto-generated method stub
		return dao.getByCondition(condition);
	}

	@Override
	public String getBasePrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
	List<SaleLogType> getByCondition(String condition){
		return dao.getByCondition(condition);
		
	}

}
