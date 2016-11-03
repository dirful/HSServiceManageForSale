package com.cqut.service.PermissionAssign;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.PermissionAssign.PermissionAssignDao;
import  com.cqut.entity.PermissionAssign.PermissionAssign;

@Service
public class PermissionAssignService extends SearchService implements IPermissionAssignService{
	
	@Resource(name="permissionAssignDao")
	PermissionAssignDao dao ;

	@Override
	public String getBaseEntityName() {
		return "permissionAssign";
	}

	@Override
	public String getBasePrimaryKey() {
		return "permissionAssign.ID";
	}
	
	@Override
	public List<PermissionAssign> getPermissionAssignByCondition(String condition){
		return dao.getByCondition(condition);
	}
	
	@Override
	public int checkPermissionAssign(boolean checked,String roleID,String moduleID){
		String condition = " permissionassign.PERMISSIONID = \'"+roleID+"\' AND permissionassign.MODULEID = \'"+moduleID+"\' ";
		if(checked){
			//节点被取消选中
			return dao.deleteByCondition(condition);
		}else{
			//节点被选中
			PermissionAssign p = new PermissionAssign();
			p.setID(BeanUtil.createId());
			p.setMODULEID(moduleID);
			p.setPERMISSIONID(roleID);
			return dao.save(p);
		}
	}
}
