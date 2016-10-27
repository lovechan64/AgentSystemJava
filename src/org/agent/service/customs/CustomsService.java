package org.agent.service.customs;

import java.util.List;

import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
 
public interface CustomsService {
	public int isExitCustoms(Customs customs);
	public List<Customs> getCustomsBySearch(Customs customs);
	public Customs getCustomsById(Customs customs);
	public int addCustoms(Customs customs);
	public int modifyCustoms(Customs customs);
	public int count(Customs customs);
	
	
	public int modifyCustomStatus(Customs customs);
	
	
	public int deleteCustoms(Customs customs);
	
	public boolean tx_addCustomContact(Customs customs, List<Contacts> contactList);
 
	public boolean tx_modifyCustomContact(Customs customs, List<Contacts> contactList);
	 
}
