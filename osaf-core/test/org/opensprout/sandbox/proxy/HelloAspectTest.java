package org.opensprout.sandbox.proxy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="springContext.xml")
public class HelloAspectTest {

	@Autowired
	Hello goodHelloImpl;
	
	@Test
	public void createProxy() throws Exception {
		assertNotNull(goodHelloImpl);
		StopWatch stopWatch = new StopWatch();
//		testProxiedMethod(10, stopWatch);
		System.out.println("total " + stopWatch.getTotalTimeMillis());
	}

	private void testProxiedMethod(int count, StopWatch stopWatch) {
		while(count > 0){
			stopWatch.start();
			for(int i = 0 ; i < 1000000 ; i++)
				goodHelloImpl.hi();
			stopWatch.stop();
			System.out.println(stopWatch.getLastTaskTimeMillis());
			count--;
		}
		
	}
}
