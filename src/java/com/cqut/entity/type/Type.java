package com.cqut.entity.type;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Type{
	
	@ID
	private String  ID;
	private String CODE;
	private String NAME;
	private String DESCRIPTION;
	private int LEVEL;
	private String PARENTID;
	private int STATE;
	private int TYPE;
	
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getCODE() {
		return CODE;
	}	
	
	public void setCODE(String CODE) {
		this.CODE = CODE;
	}
	public String getNAME() {
		return NAME;
	}	
	
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}	
	
	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}
	public int getLEVEL() {
		return LEVEL;
	}	
	
	public void setLEVEL(int LEVEL) {
		this.LEVEL = LEVEL;
	}
	public String getPARENTID() {
		return PARENTID;
	}	
	
	public void setPARENTID(String PARENTID) {
		this.PARENTID = PARENTID;
	}
	public int getSTATE() {
		return STATE;
	}	
	
	public void setSTATE(int STATE) {
		this.STATE = STATE;
	}

	public int getType() {
		return TYPE;
	}

	public void setType(int type) {
		this.TYPE = type;
	}

	@Override
	public String toString() {
		return "Type [ID=" + ID + ", CODE=" + CODE + ", NAME=" + NAME
				+ ", DESCRIPTION=" + DESCRIPTION + ", LEVEL=" + LEVEL
				+ ", PARENTID=" + PARENTID + ", STATE=" + STATE + ", type="
				+ TYPE + "]";
	}
}
