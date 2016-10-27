package org.agent.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AccountDetail extends Base {
	private String userName;
	private int userId;
	private int detailType;
	private String detailTypeName;
	private BigDecimal money;
	private BigDecimal accountMoney;
	private String memo;
	private Date detailDateTime;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
 
	public int getDetailType() {
		return detailType;
	}
	public void setDetailType(int detailType) {
		this.detailType = detailType;
	}
	public String getDetailTypeName() {
		return detailTypeName;
	}
	public void setDetailTypeName(String detailTypeName) {
		this.detailTypeName = detailTypeName;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getDetailDateTime() {
		return detailDateTime;
	}
	public void setDetailDateTime(Date detailDateTime) {
		this.detailDateTime = detailDateTime;
	}
	
	
}
