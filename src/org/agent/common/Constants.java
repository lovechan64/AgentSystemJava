package org.agent.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.agent.pojo.RoleFunctions;
import org.agent.pojo.SystemConfig;
import org.agent.service.systemconfig.SystemConfigService;
import org.agent.service.systemconfig.SystemConfigServiceImpl;
import org.springframework.web.context.WebApplicationContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Constants {
	public static  final String OPERATE_INFO_USER_LOGIN_SUCCESS="用户进行登录操作成功";
	
	public static  final String OPERATE_INFO_USER_LOGIN_FAILD="用户进行登录操作失败";
	
	
	public static  final String OPERATE_INFO_USER_LOGOUT_SUCCESS="用户进行注销操作成功";
	public static  final String OPERATE_INFO_USER_MODIFY_PASSWORD="用户进行操作修改密码成功";
	
	
	public static HashMap<Integer, ArrayList<RoleFunctions>> MENU=new HashMap<Integer, ArrayList<RoleFunctions>>();
	
 
	
	
	
	
	
	
	public static final String SESSION_USER="userSession";
	 public static WebApplicationContext ctx;
	public static List<SystemConfig> systemConfigList;
	public static List<SystemConfig> accountConfigList=new ArrayList<SystemConfig>();
	public static List<SystemConfig> serviceConfigList=new ArrayList<SystemConfig>();
	public static SystemConfig maxServiceYearSystemConfig ;
	public static SystemConfig appMakerUrlcConfig ;
	public static List<SystemConfig> customConfigList=new ArrayList<SystemConfig>();
	public static List<SystemConfig> cardTypeConfigList=new ArrayList<SystemConfig>();
	public static List<SystemConfig> youhuiConfigList=new ArrayList<SystemConfig>();
	
	
	public static void configSystemData(){
	/*	SystemConfigService systemConfigService=new SystemConfigServiceImpl();
		SystemConfig  systemConfig=new SystemConfig();
		systemConfig.setIsStart(1);
		systemConfigList=systemConfigService.getSystemConfigs(systemConfig) ;*/
		accountConfigList.clear();
		serviceConfigList.clear();
		customConfigList.clear();
		cardTypeConfigList.clear();
		youhuiConfigList.clear();
		for(SystemConfig config:systemConfigList){
			switch(config.getConfigType()){
			case 1:
				accountConfigList.add(config);
				
				break;
			case 2:
				serviceConfigList.add(config);
				break;
			case 3:
				maxServiceYearSystemConfig=config;
				break;
			case 4:
				appMakerUrlcConfig=config;
				break;
			case 5:
				customConfigList.add(config);
				break;
			case 6:
				cardTypeConfigList.add(config);
				break;
			case 7:
				youhuiConfigList.add(config);
				break;
			
			
			
			
			
			
			
			}
			
			
			
		}
		
		
	}
	
}
