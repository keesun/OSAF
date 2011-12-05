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


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.util.ApplicationContextUtils;
import org.opensprout.osaf.util.ReflectionUtils;
import org.springframework.context.ApplicationContext;

/**
 * Generic PropertyEditor uses dao to load entity by id.
 * @author Whiteship
 * @param <T> Entity class type
 * @param <D> GenericDao type
 */
public abstract class AbstractGenericPropertyEditor<T, D extends GenericDao<T, ?>>
		extends PropertyEditorSupport {

	Log logger = LogFactory.getLog(getClass());

	protected Class<T> entityClass;
	protected Class<D> daoClass;
	protected D dao;
	
	public AbstractGenericPropertyEditor(Class<T> entityClass,
			Class<D> daoClass, ApplicationContext applicationContext) {
		this.entityClass = entityClass;
		this.daoClass = daoClass;
		dao = (D) ApplicationContextUtils.getBeanByType(
				applicationContext, daoClass);
	}
	
	/** Entity object -> Entity's id. */
	@SuppressWarnings("unchecked")
	public String getAsText() {
		T entity = (T) this.getValue();
		logger.debug("entity = " + entity);
		if (entity == null)
			return "";
		else
			return String.valueOf(ReflectionUtils.callMethod(entityClass, entity, "getId"));
	}

	/** Entity's id -> Entity object by dao. */
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		logger.debug("text = " + id);
		if (id == null || id.trim().length() == 0)
			setValue(null);
		else
			setValue(dao.get(Integer.parseInt(id)));
	}

}