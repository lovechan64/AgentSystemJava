package org.agent.dao.function;

import java.util.List;

import org.agent.pojo.Function;
 
public interface FunctionMapper   {
 
	
	public List<Function> getFunctionList();
	public Function getFunctionById(Function function);
	public List<Function> getMenuFunction();
	public List<Function> getFunctionByParentId(int parentId);
	public List<Function> getFunctionByRoleId(int roleId);
}
