/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.enumeration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.opensprout.osaf.enumeration.AbstractType;
import org.opensprout.osaf.enumeration.Pair;

/**
 * Unit test AbstractType class
 * @author Whiteship
 */
public class AbstractTypeTest {

	@Test
	public void create() throws Exception {
		List<Pair> types = Arrays.asList(
			new Pair(10, "type1"), 
			new Pair(20, "type2")
		);
		AbstractType type = new AbstractType(types);
		
		assertNotNull(type);
		assertEquals(ArrayList.class, type.getClass().getSuperclass());
		assertEquals("type1", type.decode(10));
		assertEquals("type2", type.decode(20));
		assertEquals("UNKNOWN", type.decode(30));
		
		type = new AbstractType(types, true);
		try {
			type.decode(50);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unknown Value for AbstractType [50]", e.getMessage());
		}
	}
	
}
