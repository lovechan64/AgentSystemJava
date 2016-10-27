package org.agent.dao.rolepremission;

 


import java.util.List;

import org.agent.pojo.RolePremission;
 

public interface RolePremissionMapper{
 
	public int modifyRolePremission(RolePremission rolePremission);
	 
	public List<RolePremission> getList(RolePremission rolePremission);
	
	public int addRolePremission(RolePremission rolePremission);
	 
 
	public int deleteRolePremission(RolePremission rolePremission);
	 
	 
	 
}
