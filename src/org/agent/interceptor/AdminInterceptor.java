package org.agent.interceptor;

import java.util.List;

import org.agent.common.Constants;
import org.agent.pojo.Function;
import org.agent.pojo.RoleFunctions;
import org.agent.pojo.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
	 User user=	(User) arg0.getInvocationContext().getSession().get(Constants.SESSION_USER);
	/* boolean flag=false;
	String actionName  =arg0.getProxy().getActionName();
	List<RoleFunctions> roleFunctions;
	 if(user!=null){
		 roleFunctions=Constants.MENU.get(user.getRoleId());
	 
	
		
		for(RoleFunctions rf:roleFunctions){
			
			for(Function f:rf.getSubFunctions()){
				 
				if(actionName.equals(f.getFuncUrl().replaceAll("/", "").replaceAll(".action", ""))){
					flag=true;
					break;
				}
			
			}
			
		}
	 }
	*/	
	 
		if(user!=null&&user.getUserCode()!=null&&user.getUserPassword()!=null&&user.getIsStart()==1/*&&flag==true*/){
			return arg0.invoke();
		}else {
			return Action.LOGIN;
		}
		
	}

}
