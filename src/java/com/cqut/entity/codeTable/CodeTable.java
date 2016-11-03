package com.cqut.entity.codeTable;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class CodeTable{
	
	@ID
	private String  codeTableID;
	private int time;
	private String codeTableName;
	private String codeType;
	private String description;
	private String field0;
	private String field1;
	
	
	public String getCodeTableID() {
		return codeTableID;
	}	
	
	public void setCodeTableID(String codeTableID) {
		this.codeTableID = codeTableID;
	}
	public int getTime() {
		return time;
	}	
	
	public void setTime(int time) {
		this.time = time;
	}
	public String getCodeTableName() {
		return codeTableName;
	}	
	
	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
	}
	public String getCodeType() {
		return codeType;
	}	
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getDescription() {
		return description;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getField0() {
		return field0;
	}	
	
	public void setField0(String field0) {
		this.field0 = field0;
	}
	public String getField1() {
		return field1;
	}	
	
	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	@Override
	public String toString() {
		return   codeTableID  + "\t" +  time  + "\t" +  codeTableName  + "\t" +  codeType  + "\t" +  description  + "\t" +  field0  + "\t" +  field1  + "\t"  ;
	}
}
