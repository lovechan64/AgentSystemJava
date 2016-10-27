package org.agent.service.contacts;

import java.util.List;

 
import org.agent.dao.Contacts.ContactsMapper;
import org.agent.pojo.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
	@Autowired
	private ContactsMapper mapper;

	@Override
	public List<Contacts> getContactsList(Contacts contacts) {
		// TODO Auto-generated method stub
		return mapper.getContactsList(contacts);
	}

	@Override
	public int addContacts(Contacts contacts) {
		// TODO Auto-generated method stub
		return mapper.addContacts(contacts);
	}

	@Override
	public int modifyContacts(Contacts contacts) {
		// TODO Auto-generated method stub
		return mapper.modifyContacts(contacts);
	}

	@Override
	public int deleteContacts(Contacts contacts) {
		// TODO Auto-generated method stub
		return mapper.deleteContacts(contacts);
	}

	public void setMapper(ContactsMapper mapper) {
		this.mapper = mapper;
	}	
	 

}
