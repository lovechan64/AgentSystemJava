package org.agent.service.contacts;

import java.util.List;

import org.agent.pojo.Contacts;

public interface ContactsService {
	public List<Contacts> getContactsList(Contacts contacts);
	 
	public int addContacts(Contacts contacts);
	public int modifyContacts(Contacts contacts);
	public int deleteContacts(Contacts contacts);
	 
}
