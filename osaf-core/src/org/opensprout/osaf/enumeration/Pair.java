/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.enumeration;

/**
 * Make enum entity with this type.
 * @author Toby
 * @see @see net.openseed.osaf.model.enumeration.UserType
 */
public class Pair {
    int value;
    String descr;

    public Pair() {}
    
    public Pair(int value, String descr) {
		this.value = value;
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescr() {
        return this.descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
}
