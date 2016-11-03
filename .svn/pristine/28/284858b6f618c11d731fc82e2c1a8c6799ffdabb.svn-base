package com.cqut.service.Company;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.Company.CompanyDao;
import  com.cqut.entity.Company.Company;

@Service
public class CompanyService extends SearchService implements ICompanyService{
	
	@Resource(name="companyDao")
	CompanyDao dao ;

	@Override
	public String getBaseEntityName() {
		return "company";
	}

	@Override
	public String getBasePrimaryKey() {
		return "company.ID";
	}
	
}
