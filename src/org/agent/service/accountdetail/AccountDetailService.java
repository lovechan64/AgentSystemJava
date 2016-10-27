package org.agent.service.accountdetail;

import java.util.List;

import org.agent.pojo.AccountDetail;
 

public interface AccountDetailService {
	public List<AccountDetail> getAccountDetailList(AccountDetail accountDetail);
	
	public int count(AccountDetail accountDetail);
	
	 public int addAccountDetail(AccountDetail accountDetail);
	public int modifyAccountDetail(AccountDetail accountDetail);
	public int deleteAccountDetail(AccountDetail accountDetail);
	
}
