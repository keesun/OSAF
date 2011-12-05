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
import org.opensprout.osaf.service.impl.ContextGenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Sample
 * @author Whiteship
 */
@Service
@Transactional
public class MemberContextGenericServiceImpl
		extends
		ContextGenericServiceImpl<Member, MemberDao, MemberParams, MemberContext>
		implements MemberContextGenericService {

	public MemberContextGenericServiceImpl() {
		super(MemberDao.class);
	}

}
