/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web.support;

/**
 * GridColumn class 
 * @author Toby
 */
public class GridColumn {
	public enum Align { LEFT, CENTER, RIGHT }
	public enum Type { INTEGER, STRING, DATE, TIMESTAMP, DOUBLE }
	
	String header;
	String path;
	Type type;
	Align align;
	String format;

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Align getAlign() {
		return align;
	}
	public void setAlign(Align align) {
		this.align = align;
	}
	
	public static Type findColType(String type) {
		if (type == null || "string".equalsIgnoreCase(type)) return Type.STRING;
		if ("date".equalsIgnoreCase(type)) return Type.DATE;
		if ("timestamp".equalsIgnoreCase(type)) return Type.TIMESTAMP;
		if ("integer".equalsIgnoreCase(type)) return Type.INTEGER;
		if ("double".equalsIgnoreCase(type)) return Type.DOUBLE;
		
		throw new IllegalArgumentException("Cannot find the type : " + type);
	}
}
