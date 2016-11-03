package com.cqut.entity.QuotedPriceDtaile;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class QuotedPriceDtaile{
	
	@ID
	private String  ID;
	private String QuotedPriceID;
	private String modelName;
	private double modelPrice;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getQuotedPriceID() {
		return QuotedPriceID;
	}	
	
	public void setQuotedPriceID(String QuotedPriceID) {
		this.QuotedPriceID = QuotedPriceID;
	}
	public String getModelName() {
		return modelName;
	}	
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getModelPrice() {
		return modelPrice;
	}	
	
	public void setModelPrice(double modelPrice) {
		this.modelPrice = modelPrice;
	}
	
	@Override
	public String toString() {
		return   ID  + "\t" +  QuotedPriceID  + "\t" +  modelName  + "\t" +  modelPrice  + "\t"  ;
	}
}
