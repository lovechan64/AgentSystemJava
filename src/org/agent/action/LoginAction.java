package org.agent.action;



import java.util.Date;

import org.agent.common.Constants;
import org.agent.common.MD5;
import org.agent.pojo.Account;
import org.agent.pojo.User;
import org.agent.service.account.AccountService;


public class LoginAction extends BaceAction {
private Account account;
private AccountService accountService;
	private User user;
	
	private  String flag;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String login(){
	String result="input";
	if(user!=null){	
			
		user.setUserPassword(new MD5(user.getUserPassword()).compute());
		
	
	User _user=	this.getUserService().getLoginser(user);
			
	if(_user!=null){
		
		this.getRequest().getSession().setAttribute(Constants.SESSION_USER, _user);
		_user.setLastLoginTime(new Date());
		this.getUserService().modifyUser(_user);
		this.setLog(_user, Constants.OPERATE_INFO_USER_LOGIN_SUCCESS);
		result= "success";
	}else {
		this.setLog(_user, Constants.OPERATE_INFO_USER_LOGIN_FAILD);
		
		result= "input";
	}
	
	
	}
 return	result;
	}
	public String checkUser(){
	System.out.println("======================checkUser===============================");
		/*
		 * 
		 * 		if("noexitusercode"==data){
					alert("对不起，账号不存在");
				}else if("errorpwd"==data){
					alert("对不起，密码错误");
					
				}else if("failed"==data){
					alert("对不起，系统错误");
					
				}else if("success"==data){
					 flag=true;
					
				}
		 */
		flag="faild";
		if(user!=null&&user.getUserCode()!=""){
			user.setUserPassword(new MD5(user.getUserPassword()).compute());
			
			int n=this.getUserService().isExitLoginUser(user);
			if(n==0){
				flag="noexitusercode";
			}else if(this.getUserService().getLoginser(user)==null){
					flag="errorpwd";
			}else {
				flag="success";
			}
		}
		this.getOut().write(flag);
		return  null;
	}
	public String main(){
		
		account=new Account();
		
		
		 
account.setUserId(this.getCurrentUser().getId());
		
		account=accountService.getAccount(account);
		
		
		
		return "success";
	}
	public void modifyPwd(){
	User _user= (User) this.getRequest().getSession().getAttribute(Constants.SESSION_USER);
	if(new MD5(user.getUserName()).compute().equals(_user.getUserPassword()))
		//_user.setUserPassword(user.getUserPassword());
	
	_user.setUserPassword(new MD5(user.getUserPassword()).compute());
	
	
	if(this.getUserService().modifyUser(_user)>0){
	//注意ln 换行 用长度
		this.setLog(this.getCurrentUser(), Constants.OPERATE_INFO_USER_MODIFY_PASSWORD);
		
		this.getOut().print("success");
		this.getOut().flush();
		this.getOut().close();
	}
	
	}
	public String exit(){
		this.setLog(this.getCurrentUser(), Constants.OPERATE_INFO_USER_LOGOUT_SUCCESS);
		
		this.getRequest().getSession().invalidate();
		
		this.getRequest().getSession().removeAttribute(Constants.SESSION_USER);
		
		return "success";
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
}
