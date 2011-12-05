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
 * This is Generic Service interface that doesn't care context. 
 * @author Toby
 * @param <T> Entity class type
 * @param <D> GenericDao class type
 * @param <P> Searching Parameters class type(this is just a JavaBean style POJO not any API.)
 */
public interface GenericService<T,D extends GenericDao<T,P>,P> extends BaseService<T, D, P> {

	/**
	 * Add entity.
	 * @param entity entity that you want to add.
	 */
	void add(T entity);

	/**
	 * Update entity.
	 * @param entity entity that you want to update.
	 */
	void update(T entity);

}
