/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.service;

import org.opensprout.osaf.data.GenericDao;

/**
 * This is aa Generic Service interface that depends on some context.
 * @author Toby
 * @param <T> Entity class type
 * @param <D> GenericDao class type
 * @param <P> Searching Parameters class type(this is just a JavaBean style POJO not any API.)
 * @param <C> Context class type
 * @see org.opensprout.osaf.service.BaseService
 */
public interface ContextGenericService<T,D extends GenericDao<T,P>,P,C> extends BaseService<T,D,P>{
	
	/**
	 * Add entity with context.
	 * @param entity entity that you want to add
	 * @param context entity's context.
	 */
	void add(T entity, C context);

	/**
	 * Update entity with context.
	 * @param entity entity that you want to update
	 * @param context entity's context
	 */
	void update(T entity, C context);
}
