package com.cqut.entity.Process;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Process{
	
	@ID
	private String  ID;
	private String processCode;
	private String processName;
	private Date createTime;
	private int processType;
	private int processState;
	private String subjectID;
	private int level;
	private int type;
	
	
	public String getID() {
		return ID;
	}	
	
	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	public String getProcessCode() {
		return processCode;
	}	
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}
	public String getProcessName() {
		return processName;
	}	
	
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getProcessType() {
		return processType;
	}	
	
	public void setProcessType(int processType) {
		this.processType = processType;
	}
	public int getProcessState() {
		return processState;
	}	
	
	public void setProcessState(int processState) {
		this.processState = processState;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Process [ID=" + ID + ", processCode=" + processCode
				+ ", processName=" + processName + ", createTime=" + createTime
				+ ", processType=" + processType + ", processState="
				+ processState + ", subjectID=" + subjectID + ", level="
				+ level + ", type=" + type + "]";
	}
}
