package com.cqut.service.role;

import java.util.List;

import com.cqut.entity.role.Role;
import com.cqut.tool.treeNode.NodeList;


public interface IRoleService {

	List<Role> getRoleByCondition(String condition);

	NodeList getRoleTree();
	
}
