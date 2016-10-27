package org.agent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agent.common.Constants;
import org.agent.common.PageSupport;
import org.agent.pojo.Logs;
import org.agent.pojo.RoleFunctions;
import org.agent.pojo.User;
import org.agent.service.logs.LogsService;
import org.agent.service.user.UserService;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.opensymphony.xwork2.ActionSupport;

public class BaceAction extends ActionSupport {
	private LogsService logsService;
	private List<RoleFunctions> roleFunctions;
	private UserService userService;
	private User currentUser;
	private PageSupport pager;
	private String actionMessage;
	private PrintWriter out;
	
	public List<RoleFunctions> getRoleFunctions() {
		return roleFunctions;
	}
	public void setRoleFunctions(List<RoleFunctions> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
	public PageSupport getPager() {
		return pager;
	}
	public void setPager(PageSupport pager) {
		this.pager = pager;
	}
	public void setLog(User user,String operateInfo){
		Logs logs=new Logs();
		logs.setUserId(user.getId());
		logs.setUserName(user.getUserCode());
		logs.setOperateDatetime(new Date());
		logs.setOperateInfo(operateInfo);
		this.logsService.addLogs(logs);
	}
	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}
	public PrintWriter getOut() {
		
		try {
			if(out==null){
			this.out=this.getResponse().getWriter();
			return out;
			}else{
				return out;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
	}
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public BaceAction() {
		this.setCurrentUser((User) this.getRequest().getSession().getAttribute(Constants.SESSION_USER));
		 
			this.getResponse().setCharacterEncoding("UTF-8");
		 
		
		
		if(this.pager==null)
			this.pager=new PageSupport();
		
		if(this.getCurrentUser()!=null)
		roleFunctions=Constants.MENU.get(this.getCurrentUser().getRoleId());
	}
	public HttpServletRequest getRequest() {
		// TODO Auto-generated method stub
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}



}
