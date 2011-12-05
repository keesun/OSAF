package org.opensprout.osaf.web.session;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.web.interceptor.SessionAttributeNameInterceptor;
import org.opensprout.osaf.web.session.PrefixedSessionAttributeStore;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * Unit test PrefixedSessionAttributeStore class
 * @author Whiteship
 */
public class PrefixedSessionAttributeStoreTest {

	PrefixedSessionAttributeStore sessionAttributeStore;
	
	@Before
	public void setup(){
		sessionAttributeStore = new PrefixedSessionAttributeStore();
	}
	
	@Test
	public void storeAttribute() throws Exception {
		WebRequest request = mock(WebRequest.class);
		Object attributeValue = new Object();
		String attributeName = "model";
		String prefix = "prefix";
		
		stub(request.getAttribute(
				SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX, 
				RequestAttributes.SCOPE_REQUEST)).toReturn(prefix);
		
		sessionAttributeStore.storeAttribute(request, attributeName, attributeValue);
		verify(request).setAttribute(prefix+attributeName, attributeValue, WebRequest.SCOPE_SESSION);
	}
	
	@Test
	public void retrieveAttribute() throws Exception {
		WebRequest request = mock(WebRequest.class);
		String attributeName = "model";
		String prefix = "prefix";
		
		stub(request.getAttribute(
				SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX, 
				RequestAttributes.SCOPE_REQUEST)).toReturn(prefix);
		
		sessionAttributeStore.retrieveAttribute(request, attributeName);
		
		verify(request).getAttribute(prefix+attributeName, WebRequest.SCOPE_SESSION);
	}
}
