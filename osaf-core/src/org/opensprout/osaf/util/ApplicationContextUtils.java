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

import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

/**
 * Util class for ApplicationContext
 * 
 * @author Whiteship
 * @see org.springframework.context.ApplicationContext
 */
public class ApplicationContextUtils {

	public static <T> T getBeanByType(ApplicationContext applicationContext,
			Class<T> clazz) {
		Map beanMap = applicationContext.getBeansOfType(clazz);
		int size = beanMap.size();
		if (size == 0) {
			if (applicationContext.getParent() != null)
				return getBeanByType(applicationContext.getParent(), clazz);
			throw new NoSuchBeanDefinitionException(clazz.getSimpleName());
		}
		if (size > 1)
			throw new NoSuchBeanDefinitionException(
					"No unique bean definition type [" + clazz.getSimpleName() + "]");
		return (T) beanMap.values().iterator().next();
	}
}
