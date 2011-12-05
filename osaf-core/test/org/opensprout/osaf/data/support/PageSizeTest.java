/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.data.support;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.support.PageSize;

/**
 * @author Whiteship
 */
public class PageSizeTest {

	private PageSize pageSize;

	@Before
	public void setUp(){
		pageSize = PageSize.getInstance();
	}
	
	@Test
	public void create() {
		assertNotNull(pageSize);
	}
	
	@Test
	public void properties() {
		assertEquals("5", pageSize.decode(5));
		assertEquals("10", pageSize.decode(10));
		assertEquals("20", pageSize.decode(20));
		assertEquals("30", pageSize.decode(30));
		assertEquals("50", pageSize.decode(50));
		assertEquals("100", pageSize.decode(100));
	}

}
