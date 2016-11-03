package com.cqut.service.role;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

import com.cqut.dao.role.RoleDao;
import com.cqut.entity.role.Role;

@Service
public class RoleService extends SearchService implements IRoleService {

	@Resource(name = "roleDao")
	RoleDao dao;

	@Override
	public String getBaseEntityName() {
		return "role";
	}

	@Override
	public String getBasePrimaryKey() {
		return "role.ID";
	}

	@Override
	public List<Role> getRoleByCondition(String condition) {
		return dao.getByCondition(condition);
	}

	@Override
	public NodeList getRoleTree() {
		List<Role> allRole = this.getRoleByCondition("1=1");
		NodeList nodeTree = new NodeList();
		Node root = new Node("全部角色", "", true);
		nodeTree.addNode(root);
		for (Role r : allRole) {
			Node node = new Node(r.getRoleName(), r.getID());
			node.addAttr("hasChild", 0);
			root.addChildren(node, true);
		}
		return nodeTree;
	}
}
