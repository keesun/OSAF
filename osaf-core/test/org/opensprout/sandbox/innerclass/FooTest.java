package org.opensprout.sandbox.innerclass;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.sandbox.innerclass.Foo.Bar;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations="applicationContext.xml")
public class FooTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void getBar() throws Exception {
		Foo.Bar bar = (Bar) applicationContext.getBean("bar");
		assertThat(bar.say(), is("Bar-Bar-Bar"));
	}
	
}
