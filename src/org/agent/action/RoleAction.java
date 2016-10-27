package org.agent.action;

import java.util.Date;
import java.util.List;

import org.agent.common.Constants;
import org.agent.pojo.Role;
import org.agent.pojo.SystemConfig;
import org.agent.service.role.RoleService;
import org.agent.service.systemconfig.SystemConfigService;
import org.apache.log4j.Logger;


public class RoleAction extends BaceAction{
	private Logger logger=Logger.getLogger(RoleAction.class);
	private RoleService roleService;
	private String configTypeName;
	private String type;
	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public String getConfigTypeName() {
		return configTypeName;
	}
	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}
 
	private int configType;
	private SystemConfig systemConfig;
	private Role role;
	private List<Role> roleList;
	private List<SystemConfig> systemConfigList;
	private List<SystemConfig> systemConfigListIsStart;
	
	
	
	
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
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
	//this.systemConfigList=	systemConfigService.getSystemConfigs(_systemConfig);
	this.configTypeName=configTypeName;
	_systemConfig.setIsStart(1);
	//this.systemConfigListIsStart=systemConfigService.getSystemConfigsIsStart(_systemConfig);
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
	
	
	
	public String roleList (){
		//loadConfig(2,"服务类型", "查看服务类型配置信息");
		roleList=roleService.getRoleList();
		return "success";
	}
	public void editRole (){
		//loadConfig(7,"优惠类型", "查看优惠类型配置信息");
		
		if(type.equals("add")){
			
		

			if(this.roleService.isPeatRole(role)>0){
				this.getOut().print("peat");
			}else{
			Date	lastUpdateTime=new Date();
				role.setCreationTime(lastUpdateTime);
				
				
				
				role.setLastUpdateTime(lastUpdateTime);
				
			String usercode=this.getCurrentUser().getUserCode()	;
			 
			role.setCreatedBy(usercode);
				this.roleService.addRole(role);
				 
				
			}
			
			
			
		}else if(type.equals("modify")){
			Date	lastUpdateTime=new Date();
			 
			
			
			
			role.setLastUpdateTime(lastUpdateTime);
			
			this.roleService.modifyRole(role);
		 
			
		}
		
	
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
	/*public void addConfig (){
	//	System.out.println("==========================================================="+this.systemConfigService.isPeatConfig(this.systemConfig));
	//	if(this.systemConfigService.isPeatConfig(this.systemConfig)>0){
			this.getOut().print("peat");
	//	}else{
	//		int configTypeValue=this.systemConfigService.maxTypeValue(this.systemConfig.getConfigType());
			systemConfig.setConfigTypeValue(configTypeValue+1);
//	this.systemConfigService.addSystemConfig(systemConfig);
		this.getOut().print("sussce");
		}
	}*/
	public void deleteRole (){
	//	this.systemConfigService.deleteSystemConfig(systemConfig);
		this.roleService.deleteRole(role);
		this.getOut().print("sussce");
		
		
	}
	/*public void modifyConfig (){
	
		
		 
			
	this.systemConfigService.modifySystemConfig(systemConfig);
		this.getOut().print("sussce");
		 
	}*/
	
}
