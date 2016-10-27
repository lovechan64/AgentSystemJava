import static org.junit.Assert.*;

import org.agent.action.BaceAction;
import org.agent.common.MD5;
import org.agent.dao.function.FunctionMapper;
import org.agent.pojo.Function;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class bizTest{

	@Test
	public void test() {
	
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
	for(String beanName:ctx.getBeanDefinitionNames()){
		System.out.println(beanName);
	//System.out.println(md5.MD5Encode("12345"));	;
		
/*	FunctionMapper mapper=(FunctionMapper) ctx.getBean("functionMapper");
	for(Function function:mapper.getFunctionList()){
		System.out.println(function.getFunctionName());
	}*/
		
	}
	}
		
	

}
