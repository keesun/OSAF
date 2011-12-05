/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.test.ApplicationContextTestBase;

/**
 * 
 * @author Whiteship
 *
 */
public class ApplicationContextTestBaseTest {

	public static class SampleApplicationContextTestBase extends
			ApplicationContextTestBase {
	}

	private ApplicationContextTestBase testBase;
	
	@Test
	public void create(){
		testBase = new SampleApplicationContextTestBase();
		assertNotNull(testBase);
	}
	
}
