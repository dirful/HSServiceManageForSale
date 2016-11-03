package com.cqut.service.Subject;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.Subject.SubjectDao;
import  com.cqut.entity.Subject.Subject;

@Service
public class SubjectService extends SearchService implements ISubjectService{
	
	@Resource(name="subjectDao")
	SubjectDao dao ;

	@Override
	public String getBaseEntityName() {
		return "subject";
	}

	@Override
	public String getBasePrimaryKey() {
		return "subject.ID";
	}
	
}
