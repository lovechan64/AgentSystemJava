package org.agent.action;
 
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.agent.action.BaceAction;
 
import org.agent.common.MD5;
import org.agent.common.SQLTools;
 
import org.agent.pojo.Logs;
import org.agent.pojo.Role;
import org.agent.pojo.User;
import org.agent.service.logs.LogsService;
import org.agent.service.role.RoleService;
import org.agent.service.user.UserService;
 
 
public class UserAction extends BaceAction {
	private Logs logs;
	private User user;
	private List<User> userList;
	private List<Logs> logsList;
	private LogsService logsService;
	private String type;
	private String uname;
	private RoleService roleService;
	private UserService userService;
	private List<Role> roleList;
	public String myLogs(){
		if(logs==null)
			logs=new Logs();
		logs.setUserId(this.getCurrentUser().getId());
		 
	  
		 
		this.getPager().setPageSize(3);
		logs.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
		logs.setPageSize(this.getPager().getPageSize());
		this.getPager().setTotalCount(this.logsService.count(logs));
this.logsList=this.logsService.getList(logs);
	

this.getPager().setItems(logsList);	
		
		return "success";
	}
	public String logList(){
		if(logs==null)
			logs=new Logs();
		logs.setUserId(user.getId());
		 
	 
		if(logs.getOperateDatetime()!=null){
			
			String odt=new SimpleDateFormat("yyyy-MM-dd").format(logs.getOperateDatetime());
			logs.setOdt(odt);
	 
		}
		//logs.setStarNum(0);
		this.getPager().setPageSize(3);
		logs.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
		logs.setPageSize(this.getPager().getPageSize());
		this.getPager().setTotalCount(this.logsService.count(logs));
this.logsList=this.logsService.getList(logs);
	

this.getPager().setItems(logsList);	
		
		return "success";
	}
	
	
	public Logs getLogs() {
		return logs;
	}


	public void setLogs(Logs logs) {
		this.logs = logs;
	}


	public List<Logs> getLogsList() {
		return logsList;
	}


	public void setLogsList(List<Logs> logsList) {
		this.logsList = logsList;
	}


	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}


	public void editUser(){
		 
		String flag="failed";
		if("add".equals(this.type)){
			if(user!=null&&user.getUserCode()!=null&&user.getUserPassword()!=null&&user.getUserName()!=null){
				if(this.userService.isExitLoginUser(user)>0){
				 
					flag="repeat";
				}else {
					user.setCreatedBy(this.getCurrentUser().getUserCode());
					Date aDate =new Date();
					user.setCreationTime(aDate);
					user.setLastUpdateTime(aDate);
					 user.setUserPassword(new MD5(user.getUserPassword()).compute());
					  userService.tx_AddUser(user);
 
					flag="success";
					 
				}
			} 
		}else if("modify".equals(this.type)){
			
			if(user!=null&&user.getUserCode()!=null&&user.getUserPassword()!=null&&user.getUserName()!=null){
		 
					 
					Date aDate =new Date();
					 
					user.setLastUpdateTime(aDate);
					 user.setUserPassword(new MD5(user.getUserPassword()).compute());
					 int aa=this.userService.modifyUser(user);
					if(aa>0){
					flag="success";
				 
				}
			} 
			
			
		}else if("delete".equals(this.type)){
			if(user!=null)
			this.userService.deleteUser(user);
			flag="success";
		}
		this.getOut().print(flag);
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String userList() {
	
		
		
		 if(user==null) 
			user=new User();  
		if(uname!=null)
		user.setUserName(SQLTools.transfer(uname));
		
		
		this.getPager().setPageSize(3);
		user.setStarNum((this.getPager().getPage()-1)*this.getPager().getPageSize());
		//user.setStarNum(0);
		user.setPageSize(this.getPager().getPageSize());
		this.getPager().setTotalCount(this.userService.count(user));
		this.userList=this.getUserService().getUserList(user);
	

this.getPager().setItems(userList);	
		
		
		
	
	 this.roleList=this.roleService.getRoleList();
		return "success";
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
 
}
