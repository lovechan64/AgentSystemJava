package org.agent.dao.account;

import java.util.List;

import org.agent.pojo.Account;

public interface AccountMapper {
 
	public List<Account> getAccountList(Account account);
	
	
	
	public Account getAccount(Account account);
	public int addAccount(Account account);
	public int modifyAccount(Account account);
	public int deleteAccount(Account account);
	 
}
