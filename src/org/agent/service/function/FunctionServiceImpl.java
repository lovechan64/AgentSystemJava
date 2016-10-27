package org.agent.service.function;

import java.util.List;

 
import org.agent.pojo.Function;
 
import org.agent.dao.function.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionMapper mapper;	
	 
	public void setMapper(FunctionMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Function> getFunctionList() {
		// TODO Auto-generated method stub
		return mapper.getFunctionList();
	}

	@Override
	public Function getFunctionById(Function function) {
		// TODO Auto-generated method stub
		return mapper.getFunctionById(function);
	}

	@Override
	public List<Function> getMenuFunctionList() {
		// TODO Auto-generated method stub
		return mapper.getMenuFunction();
	}

	@Override
	public List<Function> getFunctionByParentId(int parentId) {
		// TODO Auto-generated method stub
		return mapper.getFunctionByParentId(parentId);
	}

	@Override
	public List<Function> getFunctionByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return mapper.getFunctionByRoleId(roleId);
	}
 
}
