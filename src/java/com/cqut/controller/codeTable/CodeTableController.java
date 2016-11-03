package com.cqut.controller.codeTable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.service.codeTable.ICodeTableService;

@Controller
@RequestMapping("/codeTableController")
public class CodeTableController{
	
	@Resource(name="codeTableService")
	ICodeTableService service;
	
}
