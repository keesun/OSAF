/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web.session;

import org.opensprout.osaf.web.interceptor.SessionAttributeNameInterceptor;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * This class extends DefaultSessionAttributeStore 
 * to store session attribute with custom session attribute prefix.
 * The prefix comes from SessionAttributeNameInterceptor.
 * @author Whiteship
 * @see org.opensprout.osaf.web.interceptor.SessionAttributeNameInterceptor
 * @see http://whiteship.me/1644
 */
public class PrefixedSessionAttributeStore extends DefaultSessionAttributeStore {

	@Override
	public void storeAttribute(WebRequest request, String attributeName,
			Object attributeValue) {
		String prefix = (String)request.getAttribute(SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX, RequestAttributes.SCOPE_REQUEST);
		super.storeAttribute(request, prefix+attributeName, attributeValue);
	}
	
	@Override
	public Object retrieveAttribute(WebRequest request, String attributeName) {
		String prefix = (String)request.getAttribute(SessionAttributeNameInterceptor.SESSION_ATTR_PREFIX, RequestAttributes.SCOPE_REQUEST);
		return super.retrieveAttribute(request, prefix+attributeName);
	}
}
