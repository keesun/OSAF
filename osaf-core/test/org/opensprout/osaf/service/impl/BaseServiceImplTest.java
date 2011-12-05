/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberBaseServiceImpl;
import org.opensprout.osaf.model.MemberDao;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.service.impl.BaseServiceImpl;

/**
 * Unit test BaseServiceImpl class
 * @author Whiteship
 */
public class BaseServiceImplTest {

	private BaseServiceImpl<Member, MemberDao, MemberParams> service;
	private MemberDao mockDao;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		service = new MemberBaseServiceImpl();
		mockDao = mock(MemberDao.class); 
		service.dao = mockDao;
	}

	@Test
	public void create() {
		assertNotNull(service);
	}

	@Test
	public void getm() {
		int id = 1;
		Member member = new Member();
		member.setId(id);

		stub(mockDao.get(id)).toReturn(member);
		
		assertThat(service.get(id), sameInstance(member));
	}
	
	@Test
	public void delete() {
		Member member = new Member();
		service.delete(member);
		verify(mockDao).delete(member);
	}

	@Test
	public void deleteById() {
		int id = 1;
		service.deleteById(id);
		verify(mockDao).deleteById(id);
	}
	
	@Test
	public void getAll() {
		service.getAll();
		verify(mockDao).getAll();
	}

	@Test
	public void search() throws Exception {
		MemberParams params = new MemberParams();
		OrderPage orderPage = new OrderPage();
		service.search(params, orderPage);
		verify(mockDao).search(params, orderPage);
	}

}
