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
 * ConventionException hierarchy's base class.
 * @author Whiteship
 */
public class ConventionException extends OSAFException {

	private static final long serialVersionUID = -2257786212652868655L;

	public ConventionException(String message) {
		super(message);
	}

	public ConventionException(ClassNotFoundException e) {
		super(e);
	}

}
