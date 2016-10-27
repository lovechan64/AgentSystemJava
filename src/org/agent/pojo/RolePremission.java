package org.agent.pojo;

import java.util.Date;

public class RolePremission extends Base {

	
	private int roleId;
	private int functionId;
	  
	  
 
	
	 
	private Date creationTime;
	private String  createdBy;
	private Date lastUpdateTime;
	private int isStart;
	 
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
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
