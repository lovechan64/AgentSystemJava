package org.agent.action;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.agent.action.BaceAction;
import org.agent.common.Constants;
import org.agent.common.PageSupport;
import org.agent.common.SQLTools;
import org.agent.pojo.Account;
import org.agent.pojo.AccountDetail;
import org.agent.pojo.Customs;
import org.agent.pojo.Logs;
import org.agent.pojo.SystemConfig;
import org.agent.pojo.User;
import org.agent.service.account.AccountService;
import org.agent.service.accountdetail.AccountDetailService;
import org.agent.service.customs.CustomsService;
import org.agent.service.systemconfig.SystemConfigService;
import org.agent.service.user.UserService;

import com.opensymphony.xwork2.Action;
 
 
public class AccountAction extends BaceAction {
	 private User user;
	 private List<SystemConfig> accountConfigList;
	 private List<User> userList;
	 private List<Customs> customList;
	 private CustomsService customsService;
	 private Customs customs;
	 private  SystemConfigService systemConfigService;
	private Account account;
	private AccountDetail accountDetail;
	 private AccountService accountService;
	 private AccountDetailService accountDetailService;
	 private  String customsname;
	 private UserService userService;
	 

	 public String userYfk(){
		 if(accountDetail!=null){
			 user=new User();
			 user.setId(accountDetail.getUserId());
			 user= this.userService.getUser(user); 
			accountDetail.setUserName(user.getUserCode());      
			 if(null!=accountDetail.getEndTime()){
				 DateFormat df=DateFormat.getDateInstance();
				 String dfString=df.format(accountDetail.getEndTime())+" 23:59:59";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				accountDetail.setEndTime(sdf.parse(dfString));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		 }else {
			 accountDetail=new AccountDetail();
		}
		 
		 
		 
		 SystemConfig systemConfig=new SystemConfig();
		 systemConfig.setConfigType(1);
		
		 this.accountConfigList=systemConfigService.getSystemConfigs(systemConfig) ;
		 
		
		 
		 
		
			
			 
			 
			 accountDetail.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
			 accountDetail.setPageSize(this.getPager().getPageSize());
			 
			 if(this.getPager()==null)
				 this.setPager(new PageSupport());
			 int totalCount=this.getAccountDetailService().count(accountDetail);
			this.getPager().setTotalCount(totalCount);
			 this.getPager().setItems(	this.getAccountDetailService().getAccountDetailList(accountDetail));
			 
			 
		 
		 return Action.SUCCESS;
	 }
	 public String yfk(){
		 if(accountDetail!=null){
			 if(null!=accountDetail.getEndTime()){
				 DateFormat df=DateFormat.getDateInstance();
				 String dfString=df.format(accountDetail.getEndTime())+" 23:59:59";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				accountDetail.setEndTime(sdf.parse(dfString));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		 }else {
			 accountDetail=new AccountDetail();
		}
		 
		 
		 
		 SystemConfig systemConfig=new SystemConfig();
		 systemConfig.setConfigType(1);
		
		 this.accountConfigList=systemConfigService.getSystemConfigs(systemConfig) ;
		 
		
		 
		 
		
			 accountDetail.setUserId(this.getCurrentUser().getId());
			 
			 
			 accountDetail.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
			 accountDetail.setPageSize(this.getPager().getPageSize());
			 
			 if(this.getPager()==null)
				 this.setPager(new PageSupport());
			 int totalCount=this.getAccountDetailService().count(accountDetail);
			this.getPager().setTotalCount(totalCount);
			 this.getPager().setItems(	this.getAccountDetailService().getAccountDetailList(accountDetail));
			 
			 
		 
		 return Action.SUCCESS;
	 }
	 
	 public void getCurrentUserAccount(){
		 String result="failed";
		 this.account=new Account();
		 account.setUserId(this.getCurrentUser().getId());
		 account= this.accountService.getAccount(account);
		 if(account!=null)
		 result=account.getMoney().toString();
		 
		 this.getOut().print(result);
	 }
	 
	 
	public String customList(){
		if(customs==null)
			customs=new Customs();
		
		;
		
		
		 if(customsname!=null)
		customs.setCustomName(SQLTools.transfer(customsname));
		 
		 
		 
		 
		 customs.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
		 customs.setPageSize(this.getPager().getPageSize());
		 
		 if(this.getPager()==null)
			 this.setPager(new PageSupport());
		 int totalCount=this.getCustomsService().count(customs);
		this.getPager().setTotalCount(totalCount);
		 this.getPager().setItems(	customList=this.getCustomsService().getCustomsBySearch(customs));
		 
		
		
		return Action.SUCCESS;
		
	} 
	 
	 
	 
	 public String accountDetailByUserId(){
		if(accountDetail==null)
			accountDetail=new AccountDetail();
		 accountDetail.setUserId(this.getCurrentUser().getId());
		 
		 
		 accountDetail.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
		 accountDetail.setPageSize(this.getPager().getPageSize());
		 
		 if(this.getPager()==null)
			 this.setPager(new PageSupport());
		 int totalCount=this.getAccountDetailService().count(accountDetail);
		this.getPager().setTotalCount(totalCount);
		 this.getPager().setItems(	this.getAccountDetailService().getAccountDetailList(accountDetail));
		 
		 
		 return Action.SUCCESS;
		 
	 }
	 
	 
	 
	 public void operateAccount(){
		 
		 try {
		
		 
		 
		 
		 Account dbAccount=accountService.getAccount(account);
		 if(dbAccount!=null){
			 Account oldAccount=dbAccount;
			 Account newAccount=account;
			
			accountDetail.setAccountMoney(oldAccount.getMoney().add(newAccount.getMoney()));
			accountDetail.setMoney(newAccount.getMoney());
			accountDetail.setUserId(newAccount.getUserId());
			accountDetail.setDetailDateTime(new Date());
			if(accountDetail.getMemo()==null){
				accountDetail.setMemo("");
			}
			
			Logs logs=new Logs();
			logs.setUserId(this.getCurrentUser().getId());
			logs.setUserName(this.getCurrentUser().getUserCode());
			logs.setOperateInfo(logs.getUserName()+"对"+newAccount.getUserName()+"进行"+accountDetail.getDetailTypeName()+"操作,流水金额:"+newAccount.getMoney());
			logs.setOperateDatetime(new Date());
			this.accountService.tx_operationAccount(oldAccount, newAccount, accountDetail, logs);
			this.getOut().print("success");
		 }
			
			} catch (Exception e) {
			
				// TODO: handle exception
			
				this.getOut().print("failed");
			}
	 }
	 public String caiwu(){
		
		 SystemConfig systemConfig=new SystemConfig();
		 systemConfig.setConfigType(1);
		
		 this.accountConfigList=systemConfigService.getSystemConfigs(systemConfig) ;
		 
		
		return Action.SUCCESS;
	}
	public void searchUser(){
		if(user==null)
			user=new User();
		user.setIsStart(1);
		this.userList=	this.getUserService().getUserList(user);
if(userList==null){
	userList=new ArrayList<User>();
}
String jsonString=JSONArray.fromObject(userList).toString();

this.getOut().print(jsonString);

	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<SystemConfig> getAccountConfigList() {
		return accountConfigList;
	}
	public void setAccountConfigList(List<SystemConfig> accountConfigList) {
		this.accountConfigList = accountConfigList;
	}
	public void setSystemConfigService(SystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountDetail getAccountDetail() {
		return accountDetail;
	}
	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public void setAccountDetailService(AccountDetailService accountDetailService) {
		this.accountDetailService = accountDetailService;
	}



	public String getCustomsname() {
		return customsname;
	}



	public void setCustomsname(String customsname) {
		this.customsname = customsname;
	}



	public SystemConfigService getSystemConfigService() {
		return systemConfigService;
	}



	public AccountService getAccountService() {
		return accountService;
	}



	public AccountDetailService getAccountDetailService() {
		return accountDetailService;
	}



	public List<Customs> getCustomList() {
		return customList;
	}



	public void setCustomList(List<Customs> customList) {
		this.customList = customList;
	}



	public CustomsService getCustomsService() {
		return customsService;
	}



	public void setCustomsService(CustomsService customsService) {
		this.customsService = customsService;
	}



	public Customs getCustoms() {
		return customs;
	}



	public void setCustoms(Customs customs) {
		this.customs = customs;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
