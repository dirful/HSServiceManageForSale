package com.cqut.service.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.BeanUtil;

import com.cqut.dao.module.ModuleDao;
import com.cqut.entity.module.Module;

@Service
public class ModuleService extends SearchService implements IModuleService {

	@Resource(name = "moduleDao")
	ModuleDao dao;

	@Override
	public String getBaseEntityName() {
		return "module";
	}

	@Override
	public String getBasePrimaryKey() {
		return "module.moduleID";
	}

	@Override
	public List<Map<String, Object>> getModuleByPermission(String permissionID) {
		String condition = " pa.MODULEID = m.moduleID AND pa.PERMISSIONID = '"
				+ permissionID + "' AND m.SHOWMENUPAGE = '1' ";
		return this.originalSearchForeign(new String[] {
				"m.moduleName AS MODULENAME", "m.url AS URL" },
				" module AS m, ", " permissionassign AS pa ", null, condition,
				false);
	}

	@Override
	public List<Module> getModuleByCondition(String condition) {
		return dao.getByCondition(condition);
	}

	@Override
	public NodeList getModuleTree() {
		List<Module> allModule = this
				.getModuleByCondition(" SHOWMENUPAGE = '1' ORDER BY parent, moduleID ");
		NodeList nodeTree = new NodeList();
		Map<String, Node> parentNodeCache = new HashMap<String, Node>();
		List<Module> noHandleSort = new ArrayList<Module>();
		Node root = new Node("全部模块", "root", true);
		nodeTree.addNode(root);
		for (Module m : allModule) {
			if (m.getPARENT() == null || m.getPARENT().equals("")
					|| m.getPARENT().equals("NaN")) {
				Node node = new Node(m.getMODULENAME(), m.getMODULEID());
				node.addAttr("hasChild", m.getHASCHILD());
				node.addAttr("LEVEL0", m.getLEVEL0());
				parentNodeCache.put(m.getMODULEID(), node);
				root.addChildren(node, true);
			} else {
				Node parentNode = parentNodeCache.get(m.getPARENT());
				if (parentNode != null) {
					Node node = new Node(m.getMODULENAME(), m.getMODULEID());
					node.addAttr("hasChild", m.getHASCHILD());
					node.addAttr("LEVEL0", m.getLEVEL0());
					parentNodeCache.put(m.getMODULEID(), node);
					parentNode.addChildren(node, true);
				} else {
					System.out.println("parentNode 为空");
					noHandleSort.add(m);
				}
			}
		}
		return nodeTree;
	}
	
	@Override
	public List<Map<String,Object>> getModuleWithPage(String condition,int rows,int page){
		String[] p={"m.moduleID AS MODULEID","m.moduleName AS MODULENAME","m.hasChild AS HASCHILD","m.URL AS URL","m.showMenuPage AS SHOWMENUPAGE","m.parent AS PARENT","m.level0 AS LEVEL0"};
		return this.originalSearchWithpaging(p, "module AS m", null, null, condition, false, null, "m.moduleID", "DESC", rows, page);
	}
	
	@Override
	public int saveModule(Module module){
		module.setMODULEID(BeanUtil.createId());
		return dao.save(module);
	}
	
	@Override
	public int updataModuleByID(Module module){
		return dao.updateByID(module, module.getMODULEID());
	}
	
	@Override
	public int deleteModuleByID(String ID){
		return dao.deleteByID(ID);
	}
}
