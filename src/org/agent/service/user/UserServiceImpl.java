package org.agent.service.user;

import java.math.BigDecimal;
import java.util.List;

import org.agent.dao.account.AccountMapper;
import org.agent.dao.user.UserMapper;
import org.agent.pojo.Account;
import org.agent.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	@Autowired
	private AccountMapper accountMapper;
	
	
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public UserMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return mapper.getUserList(user);
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return mapper.getUser(user);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return mapper.addUser(user);
	}

	@Override
	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		return mapper.modifyUser(user);
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return mapper.deleteUser(user);
	}

	@Override
	public int count(User user) {
		// TODO Auto-generated method stub
		return mapper.count(user);
	}

	@Override
	public int isExitLoginUser(User user) {
		// TODO Auto-generated method stub
		return mapper.isExitLoginUser(user);
	}

	@Override
	public User getLoginser(User user) {
		// TODO Auto-generated method stub
		return mapper.getLoginser(user);
	}
 
	@Override
	public void tx_AddUser(User user) {
		// TODO Auto-generated method stub
	
		mapper.addUser(user);
			 
		Account account=new Account();
		account.setUserId(user.getId());
		account.setMoney(new BigDecimal(0));
		account.setMoneyBak(new BigDecimal(0));
		accountMapper.addAccount(account);
	}

}
