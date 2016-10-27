package org.agent.action;
import java.util.Date;
import java.util.List;

import org.agent.action.BaceAction;
import org.agent.pojo.Function;
import org.agent.pojo.Role;
import org.agent.pojo.RolePremission;
import org.agent.service.function.FunctionService;
 
import org.agent.service.role.RoleService;
import org.agent.service.rolepremission.RolePremissionService;

import com.opensymphony.xwork2.Action;
public class FunctionAction extends BaceAction {
	private List<Function> functionList;
	private RoleService roleService;
	private FunctionService functionService;
	private List<Role> roleList;
	private int roleId;
	private String checkList;
	private RolePremission rolePremission;
	private RolePremissionService rolePremissionService;
	public void saveRoleFunc(){
		RolePremission pm=new RolePremission();
		pm.setRoleId(roleId);
		pm.setCreatedBy(this.getCurrentUser().getUserCode());
		Date aDate=new Date();
		pm.setCreationTime(aDate);
		
		pm.setLastUpdateTime(aDate);
		pm.setIsStart(1);
		rolePremissionService.tx_delAddPermission(pm,this.getCheckList());
	
		
		
		this.getOut().print("success");
	}
	public String getCheckList() {
		return checkList;
	}



	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}



	public void updateRolePremission(){
	int a=	rolePremissionService.modifyRolePremission(rolePremission);
	if(a>0){
		this.getOut().print("sussce");
	}else {
		this.getOut().print("input");
	}
	}
	
	
	
	public RolePremission getRolePremission() {
		return rolePremission;
	}



	public void setRolePremission(RolePremission rolePremission) {
		this.rolePremission = rolePremission;
	}



	public RolePremissionService getRolePremissionService() {
		return rolePremissionService;
	}



	public void setRolePremissionService(RolePremissionService rolePremissionService) {
		this.rolePremissionService = rolePremissionService;
	}



	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}


	public String roleList() {
		this.roleList=this.roleService.getRoleIdAndNameList();
		
	return Action.SUCCESS;
}


 
	public String funcList() {
		this.functionList=this.functionService.getFunctionList();
		RolePremission remission=new RolePremission();
		remission.setRoleId(roleId);
		remission.setIsStart(1);
		List<RolePremission> pList= this.rolePremissionService.getList(remission);
	if(pList!=null){
		for(RolePremission p:pList){
			for( Function f:functionList){
				if(p.getFunctionId()==f.getId()){
					f.setCheck(true);
				}
			}
		}
	}
		
		
		
		return Action.SUCCESS;
}

	public List<Function> getFunctionList() {
		return functionList;
	}


	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
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


	public FunctionService getFunctionService() {
		return functionService;
	}
	
}
