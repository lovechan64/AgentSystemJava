package org.agent.pojo;

import java.util.Date;

public class Base {
	private int id;
	private int starNum;
	private int pageSize;
	private Date startTime;
	private Date endTime;
	private String searchStr ;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStarNum() {
		return starNum;
	}
	public void setStarNum(int starNum) {
		this.starNum = starNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

}
