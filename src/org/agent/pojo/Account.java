package org.agent.pojo;

import java.math.BigDecimal;

public class Account extends Base {
private int userId;


private BigDecimal  money;
private BigDecimal  moneyBak;
private String userName;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public BigDecimal getMoney() {
	return money;
}
public void setMoney(BigDecimal money) {
	this.money = money;
}
public BigDecimal getMoneyBak() {
	return moneyBak;
}
public void setMoneyBak(BigDecimal moneyBak) {
	this.moneyBak = moneyBak;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

}
