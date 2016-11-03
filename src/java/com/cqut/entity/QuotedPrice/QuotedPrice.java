package com.cqut.entity.QuotedPrice;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class QuotedPrice{
	
	@ID
	private String  ID;
	private String name;
	private String OfferorsID;
	private Date joinTime;
	private String ProjectID;
	private String QuotedPriceDtaileID;
	private String processID;
	private int progress;
	private String TempletID;
	private double price;
	private int state;
	private String quotedPriceCode;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getOfferorsID() {
		return OfferorsID;
	}	
	
	public void setOfferorsID(String OfferorsID) {
		this.OfferorsID = OfferorsID;
	}
	public Date getJoinTime() {
		return joinTime;
	}	
	
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getProjectID() {
		return ProjectID;
	}	
	
	public void setProjectID(String ProjectID) {
		this.ProjectID = ProjectID;
	}
	public String getQuotedPriceDtaileID() {
		return QuotedPriceDtaileID;
	}	
	
	public void setQuotedPriceDtaileID(String QuotedPriceDtaileID) {
		this.QuotedPriceDtaileID = QuotedPriceDtaileID;
	}
	public String getProcessID() {
		return processID;
	}	
	
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public int getProgress() {
		return progress;
	}	
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getTempletID() {
		return TempletID;
	}

	public void setTempletID(String templetID) {
		TempletID = templetID;
	}

	public double getPrice() {
		return price;
	}	
	
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public String getQuotedPriceCode() {
		return quotedPriceCode;
	}	
	
	public void setQuotedPriceCode(String quotedPriceCode) {
		this.quotedPriceCode = quotedPriceCode;
	}

	@Override
	public String toString() {
		return "QuotedPrice [ID=" + ID + ", name=" + name + ", OfferorsID="
				+ OfferorsID + ", joinTime=" + joinTime + ", ProjectID="
				+ ProjectID + ", QuotedPriceDtaileID=" + QuotedPriceDtaileID
				+ ", processID=" + processID + ", progress=" + progress
				+ ", TempletID=" + TempletID + ", price=" + price + ", state="
				+ state + ", quotedPriceCode=" + quotedPriceCode + "]";
	}
	
}
