package org.opensprout.sandbox.proxy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensprout.sandbox.proxy.withfinal.FinalHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="springContext.xml")
public class FinalHelloAspectTest {

	@Autowired
	FinalHello finalHello;
	
	@Test
	public void di() throws Exception {
		assertNotNull(finalHello);
		finalHello.finalHi();
		finalHello.hi();
//		Advised advised = (Advised)finalHello;
	}
	
}
