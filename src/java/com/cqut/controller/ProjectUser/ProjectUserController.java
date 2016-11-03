package com.cqut.controller.ProjectUser;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.service.ProjectUser.IProjectUserService;

@Controller
@RequestMapping("/projectUserController")
public class ProjectUserController{
	
	@Resource(name="projectUserService")
	IProjectUserService service;
}
