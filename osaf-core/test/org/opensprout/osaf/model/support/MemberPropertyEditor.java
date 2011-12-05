/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.model.support;

import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberDao;
import org.opensprout.osaf.propertyeditor.AbstractGenericPropertyEditor;
import org.springframework.context.ApplicationContext;

/**
 * Sample
 * @author Whiteship
 *
 */
public class MemberPropertyEditor extends AbstractGenericPropertyEditor<Member, MemberDao>{

	public MemberPropertyEditor(ApplicationContext applicationContext) {
		super(Member.class, MemberDao.class, applicationContext);
	}

}
