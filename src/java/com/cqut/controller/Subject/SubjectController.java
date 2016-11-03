package com.cqut.controller.Subject;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.service.Subject.ISubjectService;

@Controller
@RequestMapping("/subjectController")
public class SubjectController{
	
	@Resource(name="subjectService")
	ISubjectService service;
}
