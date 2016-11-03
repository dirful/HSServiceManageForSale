package com.cqut.service.ProjectUser;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.ProjectUser.ProjectUserDao;
import  com.cqut.entity.ProjectUser.ProjectUser;

@Service
public class ProjectUserService extends SearchService implements IProjectUserService{
	
	@Resource(name="projectUserDao")
	ProjectUserDao dao ;

	@Override
	public String getBaseEntityName() {
		return "projectUser";
	}

	@Override
	public String getBasePrimaryKey() {
		return "projectUser.ID";
	}
	
}
