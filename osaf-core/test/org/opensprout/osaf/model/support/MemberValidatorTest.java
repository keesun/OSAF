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

import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.springframework.validation.BindException;

/**
 * Sample
 * @author Whiteship
 */
public class MemberValidatorTest {

	@Test
	public void validate() throws Exception {
		MemberValidator validator = new MemberValidator();
		Member member = new Member();
		
		BindException errors = new BindException(member, "model");
		validator.validate(member, errors);
		
		assertNotNull(errors.getAllErrors());
	}
}
