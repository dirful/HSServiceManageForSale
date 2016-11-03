package com.cqut.entity.permission;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Permission{
	
	@ID
	private String  ID;
	private String NAME;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getNAME() {
		return NAME;
	}	
	
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  NAME  + "\t"  ;
	}
}
