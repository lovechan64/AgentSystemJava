package org.agent.dao.user;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.agent.common.Constants;
import org.agent.common.SQLTools;
import org.agent.pojo.Area;
import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
import org.agent.pojo.Keywords;
import org.agent.pojo.Logs;
import org.agent.pojo.SystemConfig;
import org.agent.pojo.User;
import org.agent.service.contacts.ContactsService;
import org.agent.service.customs.CustomsService;
import org.agent.service.keywords.KeywordsService;
import org.agent.service.provinceandcity.ProvinceAndCitysService;
import org.agent.service.systemconfig.SystemConfigService;
import org.agent.service.user.UserService;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class UserMapperTest {

 public static void main(String[] args) {
	 
	/* ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
	 SystemConfigService userService=ctx.getBean("systemConfigService",SystemConfigService.class);
		
		 SystemConfig systemConfig=new SystemConfig();
		 systemConfig.setConfigType(1);
		List<SystemConfig> accountConfigList=userService.getSystemConfigs(systemConfig) ;
		User user=new User();
		 
	 //	List<User>  userList=	 userService.getUserList(user);
	 	
	 	for(SystemConfig user2:accountConfigList){
	 		System.out.println(user2.getConfigTypeName()+"\t");
	 	}
	 	
	 	*/
	 	
/*		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
		CustomsService userService=ctx.getBean("customsService",CustomsService.class);
		
		Customs user=new Customs();
		 user.setRegDatetime(new Date());
user.setAgentId(1);
user.setAgentCode("asdasd");

List<Contacts> contactList=new ArrayList<Contacts>();
Contacts contacts=new Contacts();
contacts.setContactEmail("ss");
contacts.setCustomId(1);
contactList.add(contacts);
userService.addCustoms(user);
	*/	
	/*
ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
CustomsService userService=ctx.getBean("customsService",CustomsService.class);
ContactsService contactsService=ctx.getBean("contactsService",ContactsService.class);
	
ProvinceAndCitysService provinceAndCitysService=ctx.getBean("provinceAndCitysService",ProvinceAndCitysService.class);



 


Contacts	contactss=new Contacts();
Customs custom=new 	Customs();
	custom.setId(1);
contactss.setCustomId(custom.getId());
List<Contacts>	contactsList=contactsService.getContactsList(contactss);

custom= userService.getCustomsById(custom);



boolean flag= userService.tx_modifyCustomContact(custom, contactsList);

System.out.println(flag+"======================getContactName"+custom.getAgentName());*/
/*for (Contacts ccc:contactsList ) {
System.out.println(flag+"======================getContactName"+custom.getAgentName());
}*/

/*}*/

/*
Area area=new Area();
area.setAreaId(custom.getArea());
Logs logs=provinceAndCitysService.getShengShiXian(area );

System.out.println(logs.getOperateInfo()+logs.getOdt()+logs.getUserName());*/
/*
Customs user=new Customs();
user.setRegDatetime(new Date());
user.setAgentId(1);
user.setAgentCode("asdasd");

List<Contacts> contactList=new ArrayList<Contacts>();
Contacts contacts=new Contacts();
contacts.setContactEmail("ss");
contacts.setCustomId(1);
contactList.add(contacts);
userService.tx_addCustomContact(user, contactList);

*/

 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
 CustomsService userService=ctx.getBean("customsService",CustomsService.class);
 KeywordsService keywordsService=ctx.getBean("keywordsService",KeywordsService.class);

 
 
 
 Keywords keywords=new Keywords();
 keywords.setAgentId(2);
 keywords.setKeywords("a");
 if(keywords.getKeywords()!=null){
	 keywords.setSeachStr("%"+SQLTools.transfer(keywords.getKeywords())+"%");
 }
 int totalCount=keywordsService.count(keywords);
List<Keywords> keywords2= keywordsService.getList(keywords);
/*Keywords a=keywords2.get(0);
a.setIsUse(0);
keywordsService.modifyKeywords(a);
 */
for (Keywords ccc:keywords2 ) {
	System.out.println(ccc.getAgentName()+"======================getContactName"+totalCount);
}
	 
}
  
}

