package com.cqut.entity.duties;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Duties{
	
	@ID
	private String  ID;
	private String duties;
	private String companyID;
	private String remarks;
	private Date createTime;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getDuties() {
		return duties;
	}	
	
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getCompanyID() {
		return companyID;
	}	
	
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getRemarks() {
		return remarks;
	}	
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  duties  + "\t" +  companyID  + "\t" +  remarks  + "\t" +  createTime  + "\t"  ;
	}
}
