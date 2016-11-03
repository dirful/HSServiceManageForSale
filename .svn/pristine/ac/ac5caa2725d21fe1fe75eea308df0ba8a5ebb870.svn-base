package com.cqut.service.module;

import java.util.List;
import java.util.Map;

import com.cqut.entity.module.Module;
import com.cqut.tool.treeNode.NodeList;


public interface IModuleService {

	List<Map<String, Object>> getModuleByPermission(String permissionID);

	List<Module> getModuleByCondition(String condition);

	NodeList getModuleTree();

	List<Map<String, Object>> getModuleWithPage(String condition, int rows,
			int page);

	int saveModule(Module module);

	int updataModuleByID(Module module);

	int deleteModuleByID(String ID);
}
