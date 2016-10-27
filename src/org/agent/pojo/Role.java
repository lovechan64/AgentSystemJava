package org.agent.pojo;

import java.util.Date;

public class Role extends Base {

	
	private String  roleName;
	private Date creationTime;
	private String  createdBy;
	private Date lastUpdateTime;
	private int isStart;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getIsStart() {
		return isStart;
	}
	public void setIsStart(int isStart) {
		this.isStart = isStart;
	}
	
	
	
	
	
}
