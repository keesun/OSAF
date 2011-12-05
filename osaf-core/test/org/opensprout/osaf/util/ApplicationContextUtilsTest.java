/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.util.ApplicationContextUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author Whiteship
 */
@ContextConfiguration(locations = { "applicationContextUtilTest-context.xml" })
public class ApplicationContextUtilsTest extends AbstractJUnit4SpringContextTests {

	//Dog, Cat extends Animal
	
	@Test
	public void getByType() throws Exception {
		Dog dog = ApplicationContextUtils.getBeanByType(applicationContext, Dog.class);
		assertThat(dog, is(notNullValue()));
	}

	@Test(expected=NoSuchBeanDefinitionException.class)
	public void getByTypeOnManyTypes() throws Exception {
		ApplicationContextUtils.getBeanByType(this.applicationContext, Animal.class);
	}
	
	@Test(expected=NoSuchBeanDefinitionException.class)
	public void getByTypeOnNoSuchType() throws Exception {
		ApplicationContextUtils.getBeanByType(this.applicationContext, A.class);
	}
	
	class A{}
}
