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
 * check if the class's member variable or methods exists.
 * @author Whiteship
 */
public class ReflectionException extends OSAFException {

	private static final long serialVersionUID = 1L;

	public ReflectionException(Exception e) {
		super(e);
	}

}
