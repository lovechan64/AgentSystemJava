package org.agent.service.customs;

import java.util.List;

import org.agent.dao.Contacts.ContactsMapper;
import org.agent.dao.Customs.CustomsMapper;
 
import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("customsService")
public class CustomsServiceImpl implements CustomsService {
	@Autowired
	private CustomsMapper mapper;
	@Autowired
	private ContactsMapper contactsMapper;

	public boolean tx_addCustomContact(Customs customs, List<Contacts> contactList){
		try {
			mapper.addCustoms(customs);
			
			
			if(contactList!=null&&contactList.size()>0){
			for(Contacts contacts:contactList){
				contacts.setCustomId(customs.getId());
				
				if(contacts!=null)
				contactsMapper.addContacts(contacts);
			}
			}
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return false;
		}
		
		
		
		
	
	
	
	
	};
 
	public boolean tx_modifyCustomContact(Customs customs, List<Contacts> contactList){
		
		
 
			
		mapper.modifyCustoms(customs);
		
		Contacts cccContacts=new Contacts();
		cccContacts.setCustomId(customs.getId());
		contactsMapper.deleteContacts(cccContacts);
		if(contactList!=null&&contactList.size()>0){
		for(Contacts contacts:contactList){
			contacts.setCustomId(customs.getId());
			if(contacts!=null)
			contactsMapper.addContacts(contacts);
		}
		}
			return true;
			
	 
		
		
	
	
	};
 
	
	
	public void setContactsMapper(ContactsMapper contactsMapper) {
		this.contactsMapper = contactsMapper;
	}

	@Override
	public int isExitCustoms(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.isExitCustoms(customs);
	}

	@Override
	public List<Customs> getCustomsBySearch(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.getCustomsBySearch(customs);
	}

	@Override
	public Customs getCustomsById(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.getCustomsById(customs);
	}

	@Override
	public int addCustoms(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.addCustoms(customs);
	}

	@Override
	public int modifyCustoms(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.modifyCustoms(customs);
	}

	@Override
	public int count(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.count(customs);
	}

	@Override
	public int modifyCustomStatus(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.modifyCustomStatus(customs);
	}

	@Override
	public int deleteCustoms(Customs customs) {
		// TODO Auto-generated method stub
		return mapper.deleteCustoms(customs);
	}

	public void setMapper(CustomsMapper mapper) {
		this.mapper = mapper;
	}
 
}
