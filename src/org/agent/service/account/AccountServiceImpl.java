package org.agent.service.account;

import java.math.BigDecimal;
import java.util.List;

import org.agent.dao.account.AccountMapper;
import org.agent.dao.accountdetail.AccountDetailMapper;
import org.agent.dao.logs.LogsMapper;
 
import org.agent.pojo.Account;
import org.agent.pojo.AccountDetail;
import org.agent.pojo.Logs;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper mapper;
	@Autowired
	private LogsMapper logsMapper;
	
	@Autowired
	private AccountDetailMapper accountDetailMapper;
 
	
	public void setAccountDetailMapper(AccountDetailMapper accountDetailMapper) {
		this.accountDetailMapper = accountDetailMapper;
	}

	public void setLogsMapper(LogsMapper logsMapper) {
		this.logsMapper = logsMapper;
	}

	public void setMapper(AccountMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Account> getAccountList(Account account) {
		// TODO Auto-generated method stub
		return mapper.getAccountList(account);
	}

	@Override
	public Account getAccount(Account account) {
		// TODO Auto-generated method stub
		return mapper.getAccount(account);
	}

	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		return mapper.addAccount(account);
	}

	@Override
	public int modifyAccount(Account account) {
		// TODO Auto-generated method stub
		return mapper.modifyAccount(account);
	}

	@Override
	public int deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return mapper.deleteAccount(account);
	}

	@Override
	public boolean tx_operationAccount(Account oldAccount, Account newAccount,
			AccountDetail accountDetail, Logs logs) {
		// TODO Auto-generated method stub
		
		BigDecimal money=oldAccount.getMoney().add(newAccount.getMoney());
		oldAccount.setMoney(money);
		BigDecimal moneyBak=oldAccount.getMoneyBak().add(newAccount.getMoney());
		oldAccount.setMoneyBak(moneyBak);
		mapper.modifyAccount(oldAccount);
		
		accountDetailMapper.addAccountDetail(accountDetail);
		logsMapper.addLogs(logs);
		
		return false;
	}	
	 
}
