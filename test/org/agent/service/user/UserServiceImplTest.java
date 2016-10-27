package org.agent.service.user;

import static org.junit.Assert.*;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

import org.agent.common.SQLTools;
import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
import org.agent.pojo.Keywords;
import org.agent.pojo.User;
import org.agent.service.contacts.ContactsService;
import org.agent.service.customs.CustomsService;
import org.agent.service.keywords.KeywordsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
public class UserServiceImplTest {

	@Test
	public void test() {
		File reportFile =new File("D:\\yufukuan.jasper");
		if(reportFile!=null&&reportFile.exists()){
			try {
				FileOutputStream fos=new FileOutputStream("D:\\b.pdf");
				Connection conn=null;
				ApplicationContext atx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
				DataSource dataSource=atx.getBean("dataSource",DataSource.class);
				 
					conn=dataSource.getConnection();
				ResultSet rs=conn.prepareStatement("SELECT a.*,u.`userName` FROM as_accountdetail a  ,as_user u WHERE  a.`detailType`='9999' AND a.`userId`=u.`id`").executeQuery();
				 
				
				 
					byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getAbsolutePath(), null,new JRResultSetDataSource(rs));
			 
				fos.write(bytes);
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
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
		 
		 
		for (Keywords ccc:keywords2 ) {
			System.out.println(ccc.getAgentName()+"======================getContactName"+totalCount);
		}
*/
		 
/*		
		 Contacts	contactss=new Contacts();
		 Customs custom=new 	Customs();
			custom.setId(1);
		contactss.setCustomId(custom.getId());
	List<Contacts>	contactsList=contactsService.getContactsList(contactss);
	
	 custom= userService.getCustomsById(custom);
		
		
		
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
		
		

for (Contacts ccc:contactsList ) {
	System.out.println(ccc.getContactName()+"======================getContactName"+custom.getAgentName());
}

	}
*/
}

}
