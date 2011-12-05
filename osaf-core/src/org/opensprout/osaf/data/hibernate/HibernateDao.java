/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.data.hibernate;

import org.opensprout.osaf.data.GenericDao;

/**
 * This is a Hibernate Dao interface that contains hibernate specific methods. 
 * @author Whiteship
 * @param <T> Entity class type
 * @param <P> is Search parameter class type.
 */
public interface HibernateDao<T, P> extends GenericDao<T, P> {

	/** Synchronize Hibernate session with database
	 *	@see org.hibernate.Session#flush()
	 */
	void flush();

	/** Clear Hibernate session 
	 *	@see org.hibernate.Session#clear() 
	 */
	void clear();

	/** Synchronize Hibernate session with database and clear Hibernate session. */
	void flushAndClear();

	/**
	 * Hibernate session's update is actually reattaching.
	 * @see org.hibernate.Session#update(Object)
	 */
	void reattach(T entity);

	/**
	 * Evict entity form Hibernate's Session Context
	 * @param entity the corresponding Domain object.
	 * @see org.hibernate.Session#evict(Object)
	 */
	void evict(T entity);
}
