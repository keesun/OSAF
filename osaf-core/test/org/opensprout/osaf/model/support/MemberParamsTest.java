/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.model.support;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample
 * @author Whiteship
 *
 */
public class MemberParamsTest {

	MemberParams params;

	@Before
	public void setUp(){
		params = new MemberParams();
	}
	
	@Test
	public void create()  {
		assertNotNull(params);
	}
	
	@Test
	public void properties() {
		String name = "whiteship";
		params.setName(name);
		assertEquals(name, params.getName());
	}
}
