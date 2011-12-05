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

import java.io.Serializable;
import java.util.List;

import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.data.support.OrderPage;


/**
 * This is Generic Service interface has generic methods, except add() and update().
 * @author Toby
 * @param <T> Entity class type
 * @param <D> GenericDao class type
 * @param <P> Searching Parameters class type(this is just a JavaBean style POJO not any API.)
 * @see org.opensprout.osaf.service.GenericService
 * @see org.opensprout.osaf.service.ContextGenericService
 */
public interface BaseService<T, D extends GenericDao<T,P>, P> {

	/**
	 * Return unique entity by id.
	 * @param id entity's field that represents primary key.
	 * @return the corresponding Domain object.
	 * @see org.hibernate.Session
	 */
	T get(Serializable id);
	
	/**
	 * Delete entity
	 * @param entity that you want to delete
	 */
	void delete(T entity);

	/**
	 * Delete table's row by Domain object's id.
	 * @param id entity's field that represents primary key.
	 * @see org.hibernate.Session
	 */
	void deleteById(Serializable id);

	/**
	 * Return all entities in table.
	 * @return all entities.
	 */
	List<T> getAll();

	/**
	 * Search entities that corresponding to searching parameters.
	 * After then apply ordering and paging with OrderPage.  
	 * @param params searching parameters.
	 * @param orderPage used by ordering and paging. 
	 * @return corresponding entities.
	 * @see org.opensprout.osaf.data.support.OrderPage
	 */
	List<T> search(P params, OrderPage orderPage);
}
