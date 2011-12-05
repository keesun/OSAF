package org.opensprout.sandbox.resource;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="applicationContext.xml")
public class ResourceTest {

	@Autowired
	@Qualifier("dog")
	Animal dog;
	
	@Resource
	Animal cat;
	
	@Test
	public void notNull() throws Exception {
		assertNotNull(dog);
		assertNotNull(cat);
	}
	
}
