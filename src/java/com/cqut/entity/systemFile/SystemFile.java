package com.cqut.entity.systemFile;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class SystemFile{
	
	@ID
	private String  fileID;
	private Date createdTime;
	private Date modifiedTime;
	private double fileSize;
	private String fileName;
	private String fileType;
	private String creator;
	private String filePath;
	private String remarks;
	
	
	public String getFileID() {
		return fileID;
	}	
	
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public Date getCreatedTime() {
		return createdTime;
	}	
	
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}	
	
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public double getFileSize() {
		return fileSize;
	}	
	
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}	
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}	
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getCreator() {
		return creator;
	}	
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getFilePath() {
		return filePath;
	}	
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getRemarks() {
		return remarks;
	}	
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return   fileID  + "\t" +  createdTime  + "\t" +  modifiedTime  + "\t" +  fileSize  + "\t" +  fileName  + "\t" +  fileType  + "\t" +  creator  + "\t" +  filePath  + "\t" +  remarks  + "\t"  ;
	}
}
