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

import java.io.Serializable;
import java.util.List;


import org.opensprout.osaf.convention.DefaultConvention;
import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.service.BaseService;
import org.opensprout.osaf.util.ApplicationContextUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is BaseService interface implemenation.
 * This class uses GenericDao to operate and daoClass type to type-casting.
 * @author Toby, Whiteship
 * @param <T> Entity clas type
 * @param <D> GenericDao class type
 * @param <P> Searching Parameters class type(this is just a JavaBean style POJO not any API.)
 */
@Transactional
public abstract class BaseServiceImpl<T,D extends GenericDao<T,P>,P> 
	implements BaseService<T,D,P>, ApplicationContextAware, InitializingBean {

	/** daoClass required to load GenericDao by type. */
	protected Class<D> daoClass;
	
	/** automatically look up when afterpropertiesset by daoClass type */
	protected D dao;

	/** applicationContext required to get daoClass type bean. */
	private ApplicationContext applicationContext;
	
	/**
	 * If net.openseed.osaf.convention.Convention type is null, 
	 * you must set domain class by constructor BaseServiceImpl(Class<D> clazz)
	 * @see org.opensprout.osaf.convention.DefaultConvention
	 */
	@Autowired(required = false)
	protected DefaultConvention convention;

	/**
	 * You can use this constructor when you want to use convention.
	 * ${domainClassName}ServiceImpl -> ${domainClassName}Dao
	 */
	public BaseServiceImpl() {
	}
	
	/**
	 * This class required to get dao class by this type.
	 * @param daoClass Entity class type
	 */
	protected BaseServiceImpl(Class<D> daoClass) {
		this.daoClass = daoClass;
	}

	// BaseService interface implementation.
	
	public T get(Serializable id) {
		return dao.get(id);
	}

	public void delete(T entity) {
		dao.delete(entity);
	}

	public void deleteById(Serializable id) {
		dao.deleteById(id);
	}

	/**
	 * execute in read-only transaction.
	 */
	@Transactional(readOnly = true)
	public List<T> getAll() {
		return dao.getAll();
	}

	/**
	 * execute in read-only transaction.
	 */
	@Transactional(readOnly = true)
	public List<T> search(P params, OrderPage orderPage) {
		return dao.search(params, orderPage);
	}
	
	/*
	 * ApplicationContextAware interface implementation.
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	/*
	 * InitializingBean interface implementation.
	 * Autowiring GenericDao by type.
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if(daoClass == null && convention != null)
			daoClass = (Class<D>)convention.getDaoClassFromService(this.getClass());
		if(dao == null)
			dao = (D) ApplicationContextUtils.getBeanByType(applicationContext, daoClass);
	}
	
	/**
	 * Update Audit information when adding entity.
	 * @param entity
	 * @see org.opensprout.osaf.model.Audit
	 */
	protected void updateAuditWhenAdd(T entity) {
	}

	/**
	 * Update Audit information when updating entity.
	 * @param entity
	 * @see org.opensprout.osaf.model.Audit
	 */
	protected void updateAuditWhenUpdate(T entity) {
	}
}
