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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberContextGenericServiceImpl;
import org.opensprout.osaf.model.MemberDao;
import org.opensprout.osaf.model.support.MemberContext;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.service.impl.ContextGenericServiceImpl;

/**
 * Unit test ContextGenericServiceImpl class
 * @author Whiteship
 *
 */
public class ContextGenericServiceImplTest {

	private ContextGenericServiceImpl<Member, MemberDao, MemberParams, MemberContext> service;
	private MemberDao mockDao;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		service = new MemberContextGenericServiceImpl();
		mockDao = mock(MemberDao.class);
		service.dao = mockDao;
	}

	@Test
	public void create() {
		assertNotNull(service);
	}

	@Test
	public void add() {
		//TODO test Audit type object
		Member member = new Member();
		MemberContext context = new MemberContext();
		service.add(member, context);
		verify(mockDao).add(member);
	}
	
	@Test
	public void update() {
		//TODO test Audit type object
		Member member = new Member();
		MemberContext context = new MemberContext();
		service.update(member, context);
		verify(mockDao).update(member);
	}
}

