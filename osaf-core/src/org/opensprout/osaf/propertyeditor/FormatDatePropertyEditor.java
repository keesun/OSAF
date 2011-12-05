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

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

/**
 * This PropertyEditor maps Date to String and visa versa.
 * @author Whiteship
 */
public class FormatDatePropertyEditor extends PropertyEditorSupport {
	DateFormat format;

	public FormatDatePropertyEditor() {
		format = new SimpleDateFormat("yyyy/MM/dd");
	}

	public FormatDatePropertyEditor(String format) {
		this.format = new SimpleDateFormat(format);
	}

	/** Date -> String */
	@Override
	public String getAsText() {
		if (getValue() == null)
			return "";
		return format.format(getValue());
	}

	/** String -> Date */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			try {
				setValue(format.parse(text));
			} catch (ParseException e) {
				throw new IllegalArgumentException("Invalid date string " + text, e);
			}
		}
	}

	public void setPattern(String pattern) {
		this.format = new SimpleDateFormat(pattern);
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}

}
