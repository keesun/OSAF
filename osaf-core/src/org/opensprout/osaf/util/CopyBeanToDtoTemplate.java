/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

/**
 * callback interface used by WebServiceUtils.
 * @author Toby
 * @param <S> source type.
 * @param <T> dao type
 * @see org.opensprout.osaf.util.WebServiceUtils
 */
public interface CopyBeanToDtoTemplate<S,T> {
	public void copy(S source, T dto);
}
