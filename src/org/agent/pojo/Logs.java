package org.agent.pojo;

import java.util.Date;

public class Logs extends Base {
	private int userId;
	private String userName;
	private String operateInfo;
	private Date operateDatetime;
	private String odt;
	
	public String getOdt() {
		return odt;
	}
	public void setOdt(String odt) {
		this.odt = odt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOperateInfo() {
		return operateInfo;
	}
	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}
	public Date getOperateDatetime() {
		return operateDatetime;
	}
	public void setOperateDatetime(Date operateDatetime) {
		this.operateDatetime = operateDatetime;
	}
	
}
