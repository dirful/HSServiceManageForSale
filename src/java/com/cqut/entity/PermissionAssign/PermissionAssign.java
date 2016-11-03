package com.cqut.entity.PermissionAssign;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class PermissionAssign{
	
	@ID
	private String  ID;
	private String PERMISSIONID;
	private String MODULEID;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPERMISSIONID() {
		return PERMISSIONID;
	}	
	
	public void setPERMISSIONID(String PERMISSIONID) {
		this.PERMISSIONID = PERMISSIONID;
	}
	public String getMODULEID() {
		return MODULEID;
	}	
	
	public void setMODULEID(String MODULEID) {
		this.MODULEID = MODULEID;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  PERMISSIONID  + "\t" +  MODULEID  + "\t"  ;
	}
}
