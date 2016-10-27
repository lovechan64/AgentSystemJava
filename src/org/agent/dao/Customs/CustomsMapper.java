package org.agent.dao.Customs;

import java.util.List;

import org.agent.pojo.Customs;

public interface CustomsMapper {
	public int isExitCustoms(Customs customs);
	public List<Customs> getCustomsBySearch(Customs customs);
	public Customs getCustomsById(Customs customs);
	public int addCustoms(Customs customs);
	public int modifyCustoms(Customs customs);
	public int count(Customs customs);
	
	
	public int modifyCustomStatus(Customs customs);
	
	
	public int deleteCustoms(Customs customs);
	
 
}
