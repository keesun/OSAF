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
 * check if the upload file is excel file that has right header and data.
 * @author Whiteship
 */
public class ExcelUploadException extends OSAFException {

	public ExcelUploadException(Exception e) {
		super(e);
	}

	public ExcelUploadException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
