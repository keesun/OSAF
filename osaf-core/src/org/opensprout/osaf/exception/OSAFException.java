/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.exception;

/**
 * base class of all OSAF exception classes.
 * @author Whiteship
 */
public class OSAFException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OSAFException(Exception e) {
		super(e);
	}

	public OSAFException(String message) {
		super(message);
	}

}
