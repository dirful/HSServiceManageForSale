package com.cqut.entity.SaleLogType;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class SaleLogType{
	
	@ID
	private String  ID;
	private String saleLogTypeCode;
	private String saleLogTypeName;
	private String description;
	private int level;
	private String parentID;
	private int state;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getSaleLogTypeCode() {
		return saleLogTypeCode;
	}	
	
	public void setSaleLogTypeCode(String saleLogTypeCode) {
		this.saleLogTypeCode = saleLogTypeCode;
	}
	public String getSaleLogTypeName() {
		return saleLogTypeName;
	}	
	
	public void setSaleLogTypeName(String saleLogTypeName) {
		this.saleLogTypeName = saleLogTypeName;
	}
	public String getDescription() {
		return description;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLevel() {
		return level;
	}	
	
	public void setLevel(int level) {
		this.level = level;
	}
	public String getParentID() {
		return parentID;
	}	
	
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  saleLogTypeCode  + "\t" +  saleLogTypeName  + "\t" +  description  + "\t" +  level  + "\t" +  parentID  + "\t" +  state  + "\t"  ;
	}
}
