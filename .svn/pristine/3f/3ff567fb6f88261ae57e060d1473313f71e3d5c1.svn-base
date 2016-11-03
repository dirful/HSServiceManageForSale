package com.cqut.service.Project;

import java.util.List;
import java.util.Map;

import com.cqut.entity.Project.Project;
import com.cqut.entity.Templet.Templet;

public interface IProjectService {
	public List<Map<String,Object>> getProjectsInfo();
	public int deleteProjectInfo(String ID);
	public List<Map<String,Object>> searchProjectDetailInfo(String ID);
	public List<Map<String,Object>> getPicFilePath(String ID);
	public List<Map<String,Object>> getBigClassName();
	public List<Map<String,Object>> getSubclassName(String parentID);
	public List<Map<String,Object>> getTempletName(String subclassID);
	public List<Map<String,Object>> getDepartment();
	public List<Map<String,Object>> getEmployee(String departmentID);
	public int saveProjectInfo(Project project);
	/*********************后台*********************************/
	public Map<String, Object> getProjectListWithPaging(int rows, int page, String orderFiled, String sortMode, String condition);
	public int deleteProjects(String[] IDs);
	public int update(Project project , String ID);
	
	
}
