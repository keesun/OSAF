package org.opensprout.osaf.web.interceptor;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.web.interceptor.SessionAttributeNameInterceptor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;


public class SessionAttributeNameInterceptorTest {

	SessionAttributeNameInterceptor interceptor;
	
	@Before
	public void setup(){
		interceptor = new SessionAttributeNameInterceptor();
	}
	
	@Test
	public void create() {
		assertNotNull(interceptor);
	}
	
	@Test
	public void preHandle() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		Object handler = new Object();
		ModelAndView modelAndView = new ModelAndView();
		
		assertThat(request.getAttribute(SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX), is(nullValue()));
		interceptor.preHandle(request, response, handler);
		assertThat(request.getAttribute(SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX), is(notNullValue()));
		
		// do handle request
		interceptor.postHandle(request, response, handler, modelAndView);
		
		assertThat(request.getAttribute(SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX), is(nullValue()));
	}
}
