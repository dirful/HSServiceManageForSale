package com.cqut.entity.Project;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Project{
	
	@ID
	private String  ID;
	private String projectCode;
	private String projectName;
	private String companyID;
	private String consumerWorkPlace;
	private String contactsName;
	private Date createTime;
	private Date startTime;
	private Date endTime;
	private String leaderID;
	private String templetID;
	private String webSite;
	private String projectType;
	private String trade;
	private String progress;
	private String remarks;
	private String typeID;
	private String picID;
	private String offerID;
	private String ReceiverID;
	
	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getProjectCode() {
		return projectCode;
	}	
	
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}	
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCompanyID() {
		return companyID;
	}	
	
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getConsumerWorkPlace() {
		return consumerWorkPlace;
	}	
	
	public void setConsumerWorkPlace(String consumerWorkPlace) {
		this.consumerWorkPlace = consumerWorkPlace;
	}
	public String getContactsName() {
		return contactsName;
	}	
	
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}	
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}	
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLeaderID() {
		return leaderID;
	}	
	
	public void setLeaderID(String leaderID) {
		this.leaderID = leaderID;
	}
	public String getTempletID() {
		return templetID;
	}	
	
	public void setTempletID(String templetID) {
		this.templetID = templetID;
	}
	public String getWebSite() {
		return webSite;
	}	
	
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getProjectType() {
		return projectType;
	}	
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getTrade() {
		return trade;
	}	
	
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getProgress() {
		return progress;
	}	
	
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getRemarks() {
		return remarks;
	}	
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getPicID() {
		return picID;
	}

	public void setPicID(String picID) {
		this.picID = picID;
	}

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getReceiverID() {
		return ReceiverID;
	}

	public void setReceiverID(String receiverID) {
		ReceiverID = receiverID;
	}

	@Override
	public String toString() {
		return "Project [ID=" + ID + ", projectCode=" + projectCode
				+ ", projectName=" + projectName + ", companyID=" + companyID
				+ ", consumerWorkPlace=" + consumerWorkPlace
				+ ", contactsName=" + contactsName + ", createTime="
				+ createTime + ", startTime=" + startTime + ", endTime="
				+ endTime + ", leaderID=" + leaderID + ", templetID="
				+ templetID + ", webSite=" + webSite + ", projectType="
				+ projectType + ", trade=" + trade + ", progress=" + progress
				+ ", remarks=" + remarks + ", typeID=" + typeID + ", picID="
				+ picID + ", offerID=" + offerID + ", ReceiverID=" + ReceiverID
				+ "]";
	}
}
