package com.cqut.service.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.PropertiesTool;

import  com.cqut.dao.Project.ProjectDao;
import  com.cqut.entity.Project.Project;

@Service
public class ProjectService extends SearchService implements IProjectService{
	
	@Resource(name="projectDao")
	ProjectDao dao ;

	@Override
	public String getBaseEntityName() {
		return "project";
	}

	@Override
	public String getBasePrimaryKey() {
		return "project.ID";
	}

	/**
	 * chenyubo
	 * 得到项目信息
	 */
	@Override
	public List<Map<String,Object>> getProjectsInfo(){
		
		String[] properties={"project.ID",
				"project.projectCode",
				"project.projectName",
				"father.NAME as bigClassName",
				"child.NAME as subclassName",
				"project.createTime"};
		String baseEntity="project";
		String joinEntity="LEFT JOIN type as child ON child.ID = project.typeID "+
							"LEFT JOIN type as father ON father.ID = child.PARENTID";
		String condition="";
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	
	}
	
	/**
	 * chenyubo
	 * 删除项目信息
	 */
	@Override
	public int deleteProjectInfo(String ID){
		return dao.deleteByID(ID);
	}
	
	/**
	 * chenyubo
	 *  查询项目详细信息
	 */
	@Override
	public List<Map<String,Object>> searchProjectDetailInfo(String ID){
		String[] properties={"project.projectCode",
				"project.projectName",
				"father.type as bigClassName",
				"child.type as subclassName",
				"project.remarks",
				"project.leaderID",
				"project.consumerWorkPlace",
				"project.contactsName",
				"project.progress",
				"templet.templetName",
		};
		String baseEntity="project";
		String joinEntity="LEFT JOIN type as child ON child.ID = project.typeID "+
							"LEFT JOIN type as father ON father.ID = child.PARENTID "+
							"LEFT JOIN templet ON templet.ID = project.templetID";

							
		String condition="project.ID="+ID;
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**得到图片地址*/
	@Override
	public List<Map<String,Object>> getPicFilePath(String ID){
		
		//得到图片ID数组
		String[] properties1={"picID"};
		
		Map<String,Object> picIDMap=dao.findByID(properties1, ID);
		String[] picIDs=picIDMap.get("picID").toString().split(",");
		System.out.println(picIDs.toString());
		
		//根据图片ID获得每张图片的地址
		String[] properties={"systemFile.fileName"};
		String condition="";
		String baseEntity="project";
		String joinEntity;
		
		String fileName;
		String filePath;
		String imgRoute = PropertiesTool.getSystemPram("imgRoute");
		List<Map<String, Object>> list=new LinkedList<Map<String,Object>>();
		Map<String, Object> Map;
		
		for(int i =0;i<picIDs.length;i++){
			Map=new HashMap<String, Object>();
			joinEntity="LEFT JOIN systemFile ON systemFile.fileID="+picIDs[i];
			fileName=(String) this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false).get(0).get("fileName");
			filePath=imgRoute+fileName;
			String v=(String) Map.put("filePath", filePath);
			list.add(Map);
		}
		return list;
	}
	
	/**
	 * chenyubo
	 * 得到大类
	 */
	@Override
	public List<Map<String,Object>> getBigClassName(){
		String[] properties={"type.NAME","type.ID"};
		String baseEntity="";
		String joinEntity="type";
		String condition="type.LEVEL=1 and type.STATE=1 and type.TYPE=4";
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**
	 * chenyubo
	 * 得到小类
	 */
	@Override
	public List<Map<String,Object>> getSubclassName(String parentID){
		String[] properties={"type.NAME","type.ID"};
		String baseEntity="";
		String joinEntity="type";
		String condition="type.PARENTID="+parentID+" and type.STATE=1 and type.TYPE=4";
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**
	 * chenyubo
	 * 得到模板
	 */
	@Override
	public List<Map<String,Object>> getTempletName(String subclassID){
		String[] properties={"templet.templetName","templet.ID"};
		String baseEntity="";
		String joinEntity="templet";
		String condition="templet.str0="+subclassID+" AND templet.type=4";
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**
	 * chenyubo
	 * 得到部门
	 */
	@Override
	public List<Map<String,Object>> getDepartment(){
		String[] properties={"department.departmentName","department.ID"};
		String baseEntity="";
		String joinEntity="department";
		String condition="1=1";
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**
	 * chenyubo
	 * 得到员工
	 */
	@Override
	public List<Map<String,Object>> getEmployee(String departmentID){
		String[] properties={"employee.employeeName","employee.ID"};
		String baseEntity="";
		String joinEntity="employee";
		String condition="employee.departmentID="+departmentID;
		
		return this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);
	}
	
	/**
	 * chenyubo
	 * 保存项目信息
	 */
	@Override
	public int saveProjectInfo(Project project){
		return dao.save(project);
	}
	
/******************************************后台*************************************************/
	/**
	 * chenyubo
	 *  得到项目信息
	 */
	@Override
	public Map<String, Object> getProjectListWithPaging(int rows, int page, String orderFiled, String sortMode, String condition){
		if(condition==null){
			 condition  = " 1=1 ";
		}
		String []properties=new String[]{
				"project.ID",
				"project.projectCode",
				"project.projectName",
				"project.consumerWorkPlace",
				"project.contactsName",
				"project.progress",
				"employee.employeeName AS leaderName",
		};
		
		String baseEntity="project";
		String joinEntity="LEFT JOIN employee ON project.leaderID=employee.ID";
				      
		List<Map<String, Object>> list = this.originalSearchWithpaging(properties, baseEntity, joinEntity, null, condition, false, null, orderFiled, sortMode, rows, page);
		int count = this.getForeignCount(null, condition, false);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		
		return map;	
	}
	
	/**
	 * chenyubo
	 * 删除项目信息
	 */
	@Override
	public int deleteProjects(String[] IDs){
		return dao.deleteEntities(IDs);
	}
	
//**************************项目信息采集模板**************************************************
	
	/**
	 * chenyubo
	 * 修改项目信息
	 */
	@Override
	public int update(Project project , String ID){
		return dao.updateByID(project, ID);
	}
	
//	/**
//	 * chenyubo
//	 * 删除项目信息
//	 */
//	@Override
//	public int deleteProjectInfoTemplet(String[] IDs){
//		return or
//	}
	

}
