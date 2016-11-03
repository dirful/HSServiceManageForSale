package com.cqut.controller.Department;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.service.Department.IDepartmentService;

@Controller
@RequestMapping("/departmentController")
public class DepartmentController{
	
	@Resource(name="departmentService")
	IDepartmentService service;
}
