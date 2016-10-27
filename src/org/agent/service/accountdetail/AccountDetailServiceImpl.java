package org.agent.service.accountdetail;

import java.util.List;

import org.agent.dao.accountdetail.AccountDetailMapper;
 
import org.agent.pojo.AccountDetail;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("accountDetailService")
public class AccountDetailServiceImpl implements AccountDetailService {
	@Autowired
	private AccountDetailMapper mapper;

	public void setMapper(AccountDetailMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<AccountDetail> getAccountDetailList(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return mapper.getAccountDetailList(accountDetail);
	}

	@Override
	public int count(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return mapper.count(accountDetail);
	}

	@Override
	public int addAccountDetail(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return mapper.addAccountDetail(accountDetail);
	}

	@Override
	public int modifyAccountDetail(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return mapper.modifyAccountDetail(accountDetail);
	}

	@Override
	public int deleteAccountDetail(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return mapper.deleteAccountDetail(accountDetail);
	}	
	 

}
