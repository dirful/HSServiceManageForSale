package com.cqut.entity.administrator;

import java.util.Date;
import com.cqut.service.tableCreator.ID;

public class Administrator{
	
	@ID
	private String  ID;
	private String NAME;
	private String LOGINNAME;
	private String PASSWORD;
	private String STATE;
	private Date CREATTIME;
	private String ICON;
	private String PERMISSIONID;
	
	
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
	public String getLOGINNAME() {
		return LOGINNAME;
	}	
	
	public void setLOGINNAME(String LOGINNAME) {
		this.LOGINNAME = LOGINNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}	
	
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	public String getSTATE() {
		return STATE;
	}	
	
	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}
	public Date getCREATTIME() {
		return CREATTIME;
	}	
	
	public void setCREATTIME(Date CREATTIME) {
		this.CREATTIME = CREATTIME;
	}
	public String getICON() {
		return ICON;
	}	
	
	public void setICON(String ICON) {
		this.ICON = ICON;
	}

	public String getPERMISSIONID() {
		return PERMISSIONID;
	}

	public void setPERMISSIONID(String pERMISSIONID) {
		PERMISSIONID = pERMISSIONID;
	}

	@Override
	public String toString() {
		return "Administrator [ID=" + ID + ", NAME=" + NAME + ", LOGINNAME="
				+ LOGINNAME + ", PASSWORD=" + PASSWORD + ", STATE=" + STATE
				+ ", CREATTIME=" + CREATTIME + ", ICON=" + ICON
				+ ", PERMISSIONID=" + PERMISSIONID + "]";
	}
}
