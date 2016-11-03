package com.cqut.service.QuotedPriceDtaile;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.QuotedPriceDtaile.QuotedPriceDtaileDao;
import  com.cqut.entity.QuotedPriceDtaile.QuotedPriceDtaile;

@Service
public class QuotedPriceDtaileService extends SearchService implements IQuotedPriceDtaileService{
	
	@Resource(name="quotedPriceDtaileDao")
	QuotedPriceDtaileDao dao ;

	@Override
	public String getBaseEntityName() {
		return "quotedPriceDtaile";
	}

	@Override
	public String getBasePrimaryKey() {
		return "quotedPriceDtaile.ID";
	}
	
}
