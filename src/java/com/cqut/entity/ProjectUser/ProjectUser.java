package com.cqut.entity.ProjectUser;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class ProjectUser{
	
	@ID
	private String  ID;
	private String projectID;
	private String projectUserID;
	private String roleID;
	private Date joinTime;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getProjectID() {
		return projectID;
	}	
	
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getProjectUserID() {
		return projectUserID;
	}	
	
	public void setProjectUserID(String projectUserID) {
		this.projectUserID = projectUserID;
	}
	public String getRoleID() {
		return roleID;
	}	
	
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public Date getJoinTime() {
		return joinTime;
	}	
	
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  projectID  + "\t" +  projectUserID  + "\t" +  roleID  + "\t" +  joinTime  + "\t"  ;
	}
}
