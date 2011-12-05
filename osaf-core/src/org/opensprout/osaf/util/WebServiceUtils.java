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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * WebService util class
 * @author Toby
 */
public class WebServiceUtils {
	public static <T, S> T[] copyToDto(List<S> list, Class<T> dtoclass, T[] blankArray, 
			CopyBeanToDtoTemplate<S, T> template) {
		List<T> dtos = new ArrayList<T>();
		for (S source : list) {
			T dto;
			try {
				dto = (T) dtoclass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			BeanUtils.copyProperties(source, dto);
			if (template != null) template.copy(source, dto);
			dtos.add(dto);
		}

		return dtos.toArray(blankArray);
	}
}
