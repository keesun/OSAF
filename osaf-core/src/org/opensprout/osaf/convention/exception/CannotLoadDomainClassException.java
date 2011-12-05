/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.convention.exception;

import org.opensprout.osaf.exception.OSAFException;

/**
 * occurs when can't find domain class by convention.
 * @author Whiteship
 */
@SuppressWarnings("serial")
public class CannotLoadDomainClassException extends OSAFException {

	public CannotLoadDomainClassException() {
		super("I can't find domain class");
	}

	public CannotLoadDomainClassException(Exception e) {
		super(e);
	}


}
