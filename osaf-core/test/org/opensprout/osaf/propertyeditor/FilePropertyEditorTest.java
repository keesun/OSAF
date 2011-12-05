/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.propertyeditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.propertyeditor.FilePropertyEditor;

/**
 * @author Whiteship
 */
public class FilePropertyEditorTest {

	FilePropertyEditor editor;
	
	@Before
	public void setup(){
		String uploadDirectory = "/target/upload";
		editor = new FilePropertyEditor(uploadDirectory);
	}
	
	@Test
	public void create() {
		assertNotNull(editor);
	}
	
	//TODO test
}
