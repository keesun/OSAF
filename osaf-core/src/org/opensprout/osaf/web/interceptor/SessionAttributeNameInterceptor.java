/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * OSAF controller uses @SessionAttribute name "model" to indicate various models. 
 * So we need to distinct them with this inteceptor that add prefix to session attribute name.
 * This class add session attribute prefix to request and remove after handle thar request.
 * @author Whiteship
 * @see org.opensprout.osaf.web.session.PrefixedSessionAttributeStore
 * @see http://whiteship.me/1644
 */
public class SessionAttributeNameInterceptor extends HandlerInterceptorAdapter {

	public static final String SESSION_ATTR_PREFIX = "sessionAttrPrefix";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute(SESSION_ATTR_PREFIX, request.getRequestURI());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//release
		request.removeAttribute(SESSION_ATTR_PREFIX);
		super.postHandle(request, response, handler, modelAndView);
	}

}
