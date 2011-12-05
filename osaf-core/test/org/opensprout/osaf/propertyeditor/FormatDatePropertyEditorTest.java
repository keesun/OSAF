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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.propertyeditor.FormatDatePropertyEditor;
import org.opensprout.osaf.util.DateUtils;

/**
 * Unit test FormatDatePropertyEditor class
 * @author whiteship
 */
public class FormatDatePropertyEditorTest {

	private FormatDatePropertyEditor editor;

	@Before
	public void setUp() {
		editor = new FormatDatePropertyEditor();
	}

	@Test
	public void create() {
		assertNotNull(editor);
	}

	@Test
	public void getAsText() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		editor.setValue(date);

		assertEquals("2008/04/20", editor.getAsText());
	}

	@Test
	public void setAsText() {
		editor.setAsText("2008/04/20");

		Date date = (Date) editor.getValue();
		assertEquals(date, DateUtils.makeDate(2008, 4, 20));
	}

	@Test
	public void pattern() {
		String pattern = "yyyy/MM/dd";
		editor.setPattern(pattern);
		assertEquals(new SimpleDateFormat(pattern), editor.format);
	}

	@Test
	public void format() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		editor.setFormat(format);
		assertEquals(format, editor.format);
	}
}
