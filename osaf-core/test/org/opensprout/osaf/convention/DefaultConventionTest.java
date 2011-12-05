/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.convention;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.convention.DefaultConvention;
import org.opensprout.osaf.convention.exception.ConventionException;

/**
 * @author Whiteship
 */
public class DefaultConventionTest {

	private DefaultConvention convention;

	@Before
	public void setUp() {
		convention = new DefaultConvention();
	}

	@Test
	public void defaultProperties() {
		assertEquals("org.opensprout.osaf.model", convention.getDomainPackageName());
		assertEquals("", convention.getDaoPrefix());
		assertEquals("DaoImpl", convention.getDaoSuffix());
		assertEquals("", convention.getServicePrefix());
		assertEquals("ServiceImpl", convention.getServiceSuffix());
		assertEquals("", convention.getControllerPrefix());
		assertEquals("Controller", convention.getControllerSuffix());
	}

	@Test
	public void propertiesGetSet() {
		String domainPackageName = "osaf.domain";
		String daoPrefix = "DaoPrefix";
		String daoSuffix = "DaoSuffix";
		String servicePrefix = "ServicePrefix";
		String serviceSuffix = "ServiceSuffix";
		String controllerPrefix = "ControllerPrefix";
		String controllerSuffix = "ControllerSuffix";
		
		convention.setDomainPackageName(domainPackageName);
		convention.setDaoPrefix(daoPrefix);
		convention.setDaoSuffix(daoSuffix);
		convention.setServicePrefix(servicePrefix);
		convention.setServiceSuffix(serviceSuffix);
		convention.setControllerPrefix(controllerPrefix);
		convention.setControllerSuffix(controllerSuffix);
		
		assertEquals(domainPackageName, convention.getDomainPackageName());
		assertEquals(daoPrefix, convention.getDaoPrefix());
		assertEquals(daoSuffix, convention.getDaoSuffix());
		assertEquals(servicePrefix, convention.getServicePrefix());
		assertEquals(serviceSuffix, convention.getServiceSuffix());
		assertEquals(controllerPrefix, convention.getControllerPrefix());
		assertEquals(controllerSuffix, convention.getControllerSuffix());
	}
	
	// net.openseed.osaf.domain.Member exists.
	// default dao naming convention
	class MemberDaoImpl{}
	// wrong dao naming convention
	class MemberHibernateDao{}
	// default controller naming convention
	class MemberController{}

	@Test
	public void getDomainClassFromDao() {
		assertEquals(
			convention.getDomainClassFromDao(MemberDaoImpl.class), 
			org.opensprout.osaf.model.Member.class);
	}

	@Test
	public void getDomainClassFromController() {
		assertEquals(
				convention.getDomainClassFromController(MemberController.class), 
				org.opensprout.osaf.model.Member.class);
	}

	@Test(expected=ConventionException.class)
	public void getDomainClassFromWrongDao() {
		assertEquals(
			convention.getDomainClassFromDao(MemberHibernateDao.class), 
			org.opensprout.osaf.model.Member.class);
	}
	
	@Test
	public void isRightNamingConvention() throws Exception {
		assertThat(convention.isRightNamingConvention("MemberDaoImpl", "", "DaoImpl"), is(true));
		assertThat(convention.isRightNamingConvention("MemberController", "", "Controller"), is(true));
	}
	
}
