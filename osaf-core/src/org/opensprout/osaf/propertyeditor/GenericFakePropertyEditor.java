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
import java.lang.reflect.Field;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensprout.osaf.util.ReflectionUtils;

/**
 * This PropertyEditor maps Fake Entity to Entity's id and visa versa.
 * Fake Entity is Entity Object has only id.
 * @author Whiteship
 * @param <T> Entity class type
 */
public class GenericFakePropertyEditor<T> extends PropertyEditorSupport {

	protected Log logger = LogFactory.getLog(getClass());

	protected Class<T> entityClass;
	
	public GenericFakePropertyEditor(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/** Fake Entity -> Entity's id */
	@Override
	public String getAsText() {
		T entity = (T) getValue();
		logger.debug("entity = " + entity);
		if (entity == null)
			return "";
		else
			return String.valueOf(ReflectionUtils.callMethod(entityClass, entity, "getId"));
	}

	/** id -> Fake Entity */
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		logger.debug("text = " + id);
		if (id == null || id.trim().length() == 0 || id.equals("0"))
			setValue(null);
		else {
			T entity;
			try {
				entity = entityClass.newInstance();
				Field idFiled = ReflectionUtils.getField(entityClass, "id");
				idFiled.setAccessible(true);
				idFiled.set(entity, Integer.parseInt(id));
				setValue(entity);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
