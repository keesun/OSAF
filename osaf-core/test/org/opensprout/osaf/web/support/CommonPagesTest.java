package org.opensprout.osaf.web.support;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.web.support.CommonPages;

public class CommonPagesTest {

	@Test
	public void testname() throws Exception {
		assertEquals("common/close", CommonPages.CLOSE_POPUP);
		assertEquals("common/closeresearch", CommonPages.CLOSE_RESEARCH);
		assertEquals("common/closegridrefresh", CommonPages.CLOSE_GRID_REFRESH);
	}
}
