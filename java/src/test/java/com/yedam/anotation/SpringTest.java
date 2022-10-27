package com.yedam.anotation;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	
//	@Autowired
//	TV tv;
	
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void beanTest() {
		TV tv=ctx.getBean(SamsungTV.class);
		assertNotNull(tv);
	}
}
