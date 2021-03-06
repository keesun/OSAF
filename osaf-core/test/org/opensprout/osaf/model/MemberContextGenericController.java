/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.model;

import org.opensprout.osaf.model.support.MemberContext;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.model.support.MemberRef;
import org.opensprout.osaf.model.support.MemberValidator;
import org.opensprout.osaf.web.ContextGenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample
 * @author Whiteship
 */
@Controller
@RequestMapping("/osaf/member/*.do")
public class MemberContextGenericController extends ContextGenericController<Member, MemberContextGenericService, MemberRef, MemberValidator, MemberParams, MemberContext> {

	public MemberContextGenericController() {
		super(Member.class, MemberContextGenericService.class, MemberRef.class, MemberValidator.class);
	}

}
