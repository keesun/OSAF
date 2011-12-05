/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.data.hibernate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;
import org.opensprout.osaf.convention.DefaultConvention;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberDaoImpl;
import org.opensprout.osaf.model.MemberDaoImplWithDefaultConstructor;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.test.ApplicationContextTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit test class for HibernateGenericDao, 
 * using JUnit 4.4 assertThat() 
 * @author Toby
 * @author Whiteship
 * @see org.opensprout.osaf.data.GenericDao
 * @see org.opensprout.osaf.convention.DefaultConvention
 * @see org.springframework.beans.factory.InitializingBean
 */
@Transactional
public class HibernateGenericDaoTest extends ApplicationContextTestBase {

	@Autowired
	private MemberDaoImpl dao;

	@Test
	public void di() {
		assertThat(dao, is(notNullValue()));
	}

	@Test
	public void crud(){
		assertThat(dao.getAll().size(), is(0));
		
		Member member = new Member();
		dao.add(member);
		dao.flush(); // insert to db
		
		assertThat(member.getId(), is(notNullValue()));
		assertThat(dao.getAll().size(), is(1));
		
		member.setName("keesun");
		dao.flushAndClear(); // implicit update and clear session context
		
		member = dao.get(member.getId());
		assertThat(member.getName(), is("keesun"));
		
		dao.delete(member);
		assertThat(dao.get(member.getId()), is(nullValue()));
		assertThat(dao.getAll().size(), is(0));
	}
	
	@Test //TODO 테스트 어떻게 해야 할까요.
	public void search() {
		List<Member> members = dao.search(new MemberParams(), new OrderPage());
		assertThat(members, is(dao.getAll()));
	}

	public static class FakeConvention extends DefaultConvention {

		public FakeConvention() {
			this.domainPackageName = "org.opensprout.osaf.model";
			this.daoPrefix = "";
			this.daoSuffix = "DaoImplWithDefaultConstructor";
		}
	}
	
	@Test
	public void persistentClassSettingConvention() throws Exception {
		MemberDaoImplWithDefaultConstructor defaultDao = new MemberDaoImplWithDefaultConstructor();
		defaultDao.convention = new FakeConvention();
		defaultDao.afterPropertiesSet(); // set persistentClass filed by convention

		assertThat(defaultDao.domainClass, is(notNullValue()));
	}

}
