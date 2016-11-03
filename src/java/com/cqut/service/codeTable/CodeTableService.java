package com.cqut.service.codeTable;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;

import  com.cqut.dao.codeTable.CodeTableDao;

@Service
public class CodeTableService extends SearchService implements ICodeTableService{
	
	@Resource(name="codeTableDao")
	CodeTableDao dao ;

	@Override
	public String getBaseEntityName() {
		return "codeTable";
	}

	@Override
	public String getBasePrimaryKey() {
		return "codeTable.codeTableID";
	}

	
}
