package com.cqut.service.QuotedPriceType;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.QuotedPriceType.QuotedPriceTypeDao;
import  com.cqut.entity.QuotedPriceType.QuotedPriceType;

@Service
public class QuotedPriceTypeService extends SearchService implements IQuotedPriceTypeService{
	
	@Resource(name="quotedPriceTypeDao")
	QuotedPriceTypeDao dao ;

	@Override
	public String getBaseEntityName() {
		return "quotedPriceType";
	}

	@Override
	public String getBasePrimaryKey() {
		return "quotedPriceType.ID";
	}
	
}
