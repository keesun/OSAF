/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.service.impl;

import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

/**
 * GenericService interface implementation.
 * @author Toby, Whiteship
 * @param <T> Entity class type
 * @param <D> GenericDao class type
 * @param <P> Searching Parameters class type(this is just a JavaBean style POJO not any API.)
 */
@Transactional
public class GenericServiceImpl<T,D extends GenericDao<T,P>,P> 
 	extends BaseServiceImpl<T,D,P> implements GenericService<T,D,P> {

	/**
	 * This class needs daoClass when type-casting on generic methods.
	 * @param persistentClass Entity class type
	 */
	protected GenericServiceImpl(Class<D> persistentClass) {
		super(persistentClass);
	}

	/*
	 * Update audit information when adding
	 * @see net.openseed.osaf.service.GenericService#add(java.lang.Object)
	 * @see net.openseed.osaf.model.Audit
	 */
	public void add(T entity) {
		dao.add(entity);
		updateAuditWhenAdd(entity);
	}

	/*
	 * Update audit information when updating
	 * @see net.openseed.osaf.service.GenericService#update(java.lang.Object)
	 * @see net.openseed.osaf.model.Audit
	 */
	public void update(T entity) {
		dao.update(entity);
		updateAuditWhenUpdate(entity);
	}
}
