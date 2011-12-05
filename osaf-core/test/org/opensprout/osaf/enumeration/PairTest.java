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

import org.junit.Test;
import org.opensprout.osaf.enumeration.Pair;

/**
 * Unit test Pair class
 * @author Whiteship
 *
 */
public class PairTest {
	
	@Test
	public void property() throws Exception {
		Pair pair = new Pair();
		
		String description = "desc";
		int value = 20;

		pair.setDescr(description);
		pair.setValue(value);
		
		assertEquals(description, pair.getDescr());
		assertEquals(value, pair.getValue());
	}
}
