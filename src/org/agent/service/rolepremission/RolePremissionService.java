package org.agent.service.rolepremission;

 

import java.util.List;

import org.agent.pojo.RolePremission;
 
public interface RolePremissionService {
	public int modifyRolePremission(RolePremission rolePremission);

	  
	public List<RolePremission> getList(RolePremission rolePremission);
	
	public int addRolePremission(RolePremission rolePremission);
	 
 
	public int deleteRolePremission(RolePremission rolePremission);


	public void tx_delAddPermission(RolePremission pm, String checkList);
	 
}
