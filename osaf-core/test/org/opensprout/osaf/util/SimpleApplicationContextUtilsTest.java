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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.util.ApplicationContextUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author Whiteship
 */
@ContextConfiguration(locations={"test-context.xml"})
public class SimpleApplicationContextUtilsTest extends
		AbstractJUnit4SpringContextTests {

	private BeanA beanA;
	
	@Before
	public void setUp(){
		beanA = new BeanA();
	}

	@Test
	public void nullProperty() {
		assertNull(beanA.beanB);
	}

	@Test
	public void getBeanByType() {
		beanA.beanB = ApplicationContextUtils.getBeanByType(
				applicationContext, BeanB.class);
		assertNotNull(beanA.beanB);
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getBeanByTypeNotExist() {
		beanA.beanC = ApplicationContextUtils.getBeanByType(
				applicationContext, BeanC.class);

	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getBeanByTypeMoreThenOne() {
		beanA.beanD = ApplicationContextUtils.getBeanByType(
				applicationContext, BeanD.class);

	}
}
