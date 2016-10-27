package org.agent.systeminit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.agent.common.Constants;
import org.agent.pojo.Function;
import org.agent.pojo.Role;
import org.agent.pojo.RoleFunctions;
import org.agent.pojo.RolePremission;
import org.agent.pojo.SystemConfig;
import org.agent.service.function.FunctionService;
 
import org.agent.service.role.RoleService;
import org.agent.service.rolepremission.RolePremissionService;
import org.agent.service.systemconfig.SystemConfigService;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class systemInit implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	Constants.ctx=	WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		if(null!=Constants.ctx){
	
 SystemConfigService systemConfigService=	(SystemConfigService) Constants.ctx.getBean("systemConfigService");
 SystemConfig systemConfig=new SystemConfig();
 systemConfig.setIsStart(1);
Constants.systemConfigList= systemConfigService.getSystemConfigsIsStart(systemConfig);
		Constants.configSystemData();
		RoleService roleService=Constants.ctx.getBean("roleService",RoleService.class);
		FunctionService functionService=Constants.ctx.getBean("functionService",FunctionService.class);
		RolePremissionService premissionService=Constants.ctx.getBean("rolePremissionService",RolePremissionService.class);
		List<Role> roleList=roleService.getRoleIdAndNameList();
		List<Function> funcList;
		List<Function> menuFunctionList=functionService.getMenuFunctionList();
		
		ArrayList<RoleFunctions> roleFunctionList;
		for(Role role:roleList){
			roleFunctionList=new ArrayList<RoleFunctions>();
			funcList=new ArrayList<Function>();
			RolePremission permission=new RolePremission();
			permission.setRoleId(role.getId());
			permission.setIsStart(1);
			List<RolePremission> premissionList= premissionService.getList(permission);
		
		for(RolePremission p:premissionList){
			Function function=new Function();
			function.setId(p.getFunctionId());
			function=	functionService.getFunctionById(function);
			funcList.add(function);
		}
		List<Function> subFunction;
		for (Function mf:menuFunctionList) {
			RoleFunctions roleFunctions=new RoleFunctions();
			roleFunctions.setMainFunction(mf);
			subFunction=new ArrayList<Function>();
		if(funcList!=null&&funcList.size()>0){
			for(Function f:funcList){
				if(f.getParentId()==mf.getId()){
					subFunction.add(f);
				}
				
				
			}
		}
		roleFunctions.setSubFunctions(subFunction);
		roleFunctionList.add(roleFunctions);
		}
		
		Constants.MENU.put(role.getId(), roleFunctionList);
		
		
		}
		
		}
	}

	 
}
