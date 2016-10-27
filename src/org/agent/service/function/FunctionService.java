package org.agent.service.function;

import java.util.List;

import org.agent.pojo.Function;
 

public interface FunctionService {

	public List<Function> getFunctionList();
	public Function getFunctionById(Function function);
	public List<Function> getMenuFunctionList();
	public List<Function> getFunctionByParentId(int parentId);
	public List<Function> getFunctionByRoleId(int roleId);
}
