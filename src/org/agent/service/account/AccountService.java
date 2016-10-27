package org.agent.service.account;

import java.util.List;

import org.agent.pojo.Account;
import org.agent.pojo.AccountDetail;
import org.agent.pojo.Logs;
 

public interface AccountService {

	public List<Account> getAccountList(Account account);
	
	
	
	public Account getAccount(Account account);
	public int addAccount(Account account);
	public int modifyAccount(Account account);
	public int deleteAccount(Account account);
public boolean tx_operationAccount(Account oldAccount,Account newAccount,AccountDetail accountDetail,Logs logs);
}
