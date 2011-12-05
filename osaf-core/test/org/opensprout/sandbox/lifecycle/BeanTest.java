package org.opensprout.sandbox.lifecycle;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations="springContext.xml")
public class BeanTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	Bean bean;
	
	@Test
	public void lifecycle() {
		assertNotNull(bean.beanFactory);
		assertNotNull(bean.applicationContext);
		assertNotNull(bean.messageSource);
		assertNotNull(bean.applicationEventPublisher);
		assertNotNull(bean.resourceLoader);
	}
	
}
