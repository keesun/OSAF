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
import org.opensprout.osaf.propertyeditor.GenericFakePropertyEditor;

/**
 * Unit test GenericFakePropertyEditor class
 * @author Whiteship
 */
public class GenericFakePropertyEditorTest {

	GenericFakePropertyEditor<DomainObject> editor;
	
	@Before
	public void setUp(){
		editor = new GenericFakePropertyEditor<DomainObject>(DomainObject.class);
	}
	
	@Test
	public void create() throws Exception {
		assertNotNull(editor);
	}
	
	@Test
	public void getAsText() throws Exception {
		DomainObject object = new DomainObject();
		int id = 10;
		object.setId(id);
		
		editor.setValue(object);
		
		assertEquals(String.valueOf(id), editor.getAsText());
	}
	
	@Test
	public void setAsText() throws Exception {
		editor.setAsText("10");
		
		DomainObject object = (DomainObject) editor.getValue();
		assertEquals(10, object.getId());
	}
	
}
