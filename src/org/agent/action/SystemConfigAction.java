package org.agent.action;

import java.util.List;

import org.agent.common.Constants;
import org.agent.pojo.SystemConfig;
import org.agent.service.systemconfig.SystemConfigService;
import org.apache.log4j.Logger;


public class SystemConfigAction extends BaceAction{
	private Logger logger=Logger.getLogger(SystemConfigAction.class);
	private SystemConfigService systemConfigService;
	private String configTypeName;
	

	public String getConfigTypeName() {
		return configTypeName;
	}
	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}
	public void setSystemConfigService(SystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}
	private int configType;
	private SystemConfig systemConfig;
	private List<SystemConfig> systemConfigList;
	private List<SystemConfig> systemConfigListIsStart;
	
	
	
	
	public int getConfigType() {
		return configType;
	}
	public void setConfigType(int configType) {
		this.configType = configType;
	}
	public SystemConfig getSystemConfig() {
		return systemConfig;
	}
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}
	public List<SystemConfig> getSystemConfigList() {
		return systemConfigList;
	}
	public void setSystemConfigList(List<SystemConfig> systemConfigList) {
		this.systemConfigList = systemConfigList;
	}

	
	
	private void loadConfig(int configtype,String configTypeName,String info){
		logger.info(info);
		SystemConfig _systemConfig=new SystemConfig();
		_systemConfig.setConfigType(configtype);
	this.systemConfigList=	systemConfigService.getSystemConfigs(_systemConfig);
	this.configTypeName=configTypeName;
	_systemConfig.setIsStart(1);
	this.systemConfigListIsStart=systemConfigService.getSystemConfigsIsStart(_systemConfig);
	this.configType=configtype;
	if(this.systemConfigList!=null&&this.systemConfigList.size()==1){
		this.systemConfig=this.systemConfigList.get(0);
	}
	Constants.configSystemData();
	}
	
	
	
	public String caiwuType (){
		
		loadConfig(1,"财务类型", "查看财务类型配置信息");
		return "success";
	}
	
	
	
	public String serviceType (){
		loadConfig(2,"服务类型", "查看服务类型配置信息");
		
		return "success";
	}
	public String youhuiType (){
		loadConfig(7,"优惠类型", "查看优惠类型配置信息");
		
		return "success";
	}
	public String cardType (){
		loadConfig(6,"证件类型", "查看证件类型配置信息");
		
		return "success";
	}
	public String customType (){
		loadConfig(5,"客户类型", "查看客户类型配置信息");
		
		return "success";
	}
	public String appUrl (){
		loadConfig(4,"APP类型", "查看APP类型配置信息");
		
		return "success";
	}
	public String serviceYears (){
		loadConfig(3,"服务年限类型", "查看服务年限类型配置信息");
		
		return "success";
	}
	public void addConfig (){
		System.out.println("==========================================================="+this.systemConfigService.isPeatConfig(this.systemConfig));
		if(this.systemConfigService.isPeatConfig(this.systemConfig)>0){
			this.getOut().print("peat");
		}else{
			int configTypeValue=this.systemConfigService.maxTypeValue(this.systemConfig.getConfigType());
			systemConfig.setConfigTypeValue(configTypeValue+1);
	this.systemConfigService.addSystemConfig(systemConfig);
		this.getOut().print("sussce");
		}
	}
	public void deleteConfig (){
		this.systemConfigService.deleteSystemConfig(systemConfig);
		this.getOut().print("sussce");
		
		
	}
	public void modifyConfig (){
	
		
		 
			
	this.systemConfigService.modifySystemConfig(systemConfig);
		this.getOut().print("sussce");
		 
	}
	
}
