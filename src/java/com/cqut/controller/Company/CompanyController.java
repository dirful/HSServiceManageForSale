package com.cqut.controller.Company;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.service.Company.ICompanyService;

@Controller
@RequestMapping("/companyController")
public class CompanyController{
	
	@Resource(name="companyService")
	ICompanyService service;
}
