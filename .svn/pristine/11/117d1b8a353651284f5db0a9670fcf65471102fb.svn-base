package com.cqut.service.Department;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.Department.DepartmentDao;
import  com.cqut.entity.Department.Department;

@Service
public class DepartmentService extends SearchService implements IDepartmentService{
	
	@Resource(name="departmentDao")
	DepartmentDao dao ;

	@Override
	public String getBaseEntityName() {
		return "department";
	}

	@Override
	public String getBasePrimaryKey() {
		return "department.ID";
	}
	
}
