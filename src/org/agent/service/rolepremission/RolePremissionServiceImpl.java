package org.agent.service.rolepremission;

 
import java.util.List;

import org.agent.dao.rolepremission.RolePremissionMapper;
import org.agent.pojo.RolePremission;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("rolePremissionService")
public class RolePremissionServiceImpl implements RolePremissionService {
	@Autowired
	private RolePremissionMapper mapper;	
	
	 
	public void setMapper(RolePremissionMapper mapper) {
		this.mapper = mapper;
	}


	@Override
	public int modifyRolePremission(RolePremission rolePremission) {
		// TODO Auto-generated method stub
		return mapper.modifyRolePremission(rolePremission);
	}


	@Override
	public List<RolePremission> getList(RolePremission rolePremission) {
		// TODO Auto-generated method stub
		return mapper.getList(rolePremission);
	}


	@Override
	public int addRolePremission(RolePremission rolePremission) {
		// TODO Auto-generated method stub
		return mapper.addRolePremission(rolePremission);
	}


	@Override
	public int deleteRolePremission(RolePremission rolePremission) {
		// TODO Auto-generated method stub
		return mapper.deleteRolePremission(rolePremission);
	}


	@Override
	public void tx_delAddPermission(RolePremission pm, String checkList) {
		// TODO Auto-generated method stub
		String[] funcList=checkList.split(",");
		mapper.deleteRolePremission(pm);		
		if(null!=funcList&&!funcList.equals("")){
			for(int i=0;i<funcList.length;i++){
				pm.setFunctionId(Integer.valueOf(funcList[i]));
				mapper.addRolePremission(pm);
				
			}
		}
	}


}
