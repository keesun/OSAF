/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.data;

import java.io.Serializable;
import java.util.List;

import org.opensprout.osaf.data.support.OrderPage;

/**
 * Generic DAO interface.
 * @author Toby, Whiteship
 * @param <T> is Dommain class type. 
 * @param <P> is Search parameter class type.
 */
public interface GenericDao<T,P> {
	
	/** Create new data, matching to entity 
	 * @param entity 
	 */
	void add(T entity);

	/** Get an entity by entity's id from data.
	 * @param id entity's identifier.
	 * @return the corresponding Domain object.
	 * @see org.hibernate.Session
	 */
	T get(Serializable id);

	void update(T entity);
	
	/** Delete existing data, matching to entity. 
	 *	@param entity 
	 */
	void delete(T entity);

	
	/**
	 * Delete table's row by Domain object's id.
	 * @param id entity's field that represents primary key.
	 * @see org.hibernate.Session
	 */
	void deleteById(Serializable id);
	
	/**
	 * Return all data.
	 * @return all entities.
	 */
	List<T> getAll();

	/**
	 * If data matches to entity is not exist, create new data.
	 * Else if data matches to entity is exist, update data by entity.
	 * @param entity Entity that you want to add or update.
	 */
	void save(T entity);
	
	/**
	 * Search entities that corresponding to searching parameters.
	 * After then apply ordering and paging with OrderPage.  
	 * @param params searching parameters.
	 * @param orderPage used by ordering and paging. 
	 * @return corresponding entities.
	 * @see org.opensprout.osaf.data.support.OrderPage
	 */
	public List<T> search(P params, OrderPage orderPage);
	
}