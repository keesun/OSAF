package org.opensprout.sandbox.generic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoxTest {

	@Test
	public void create() throws Exception {
		Box<String> box = Box.make();
		assertNotNull(box);
		box.print("hi");
	}
	
}
