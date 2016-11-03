package com.cqut.service.permission;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.BeanUtil;

import com.cqut.dao.permission.PermissionDao;
import com.cqut.entity.permission.Permission;

@Service
public class PermissionService extends SearchService implements IPermissionService{
	
	@Resource(name="permissionDao")
	PermissionDao dao ;

	@Override
	public String getBaseEntityName() {
		return "permission";
	}

	@Override
	public String getBasePrimaryKey() {
		return "permission.ID";
	}
	
	@Override
	public List<Map<String, Object>> getPermissionWithPageByCondition(String condition, int rows, int page){
		return this.originalSearchWithpaging(new String[]{"*"}, getBaseEntityName(), null, null, condition, false, null, getBasePrimaryKey(), "ASC", rows, page);
	}
	
	@Override
	public int getPermissionCountByCondition(String condition){
		return dao.getCountByCondition(condition);
	}
	
	@Override
	public List<Permission> getPermissionByCondition(String condition){
		return dao.getByCondition(condition);
	}
	
	@Override
	public NodeList getPermissionTree() {
		List<Permission> allPermission = this.getPermissionByCondition("1=1");
		NodeList nodeTree = new NodeList();
		Node root = new Node("全部角色", "", true);
		nodeTree.addNode(root);
		for (Permission p : allPermission) {
			Node node = new Node(p.getNAME(), p.getID());
			node.addAttr("hasChild", 0);
			root.addChildren(node,true);
		}
		return nodeTree;
	}
	
	@Override
	public int savePermission(Permission p){
		p.setID(BeanUtil.createId());
		return dao.save(p);
	}
	
	@Override
	public int updataPermission(Permission p){
		return dao.updateByID(p, p.getID());
	}
	
	@Override
	public int deletePermission(String ID){
		return dao.deleteByID(ID);
	}
}
