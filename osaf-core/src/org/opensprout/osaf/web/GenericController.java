/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web;

import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.service.GenericService;
import org.opensprout.osaf.web.support.CommonPages;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * This is GenericController,
 * that handles add and update request independently.
 * @author Toby
 * @param <T> Entity class type
 * @param <S> GenericService class type
 * @param <R> References class type
 * @param <V> Validator class type
 * @param <P> Searching Parameters type
 */
public abstract class GenericController<T,S extends GenericService<T, ? extends GenericDao<T,P>, P>,
				R,V extends Validator,P> extends BaseController<T, S, R, V, P> {
	protected String addview = CommonPages.CLOSE_RESEARCH;
	protected String updateview = CommonPages.CLOSE_GRID_REFRESH;
	
	protected GenericController(Class<T> entityClass,
			Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass) {
		super(entityClass, serviceClass, refClass, validatorClass);
	}
	
	public GenericController(Class<T> entityClass,
			Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass,
			String order) {
		super(entityClass, serviceClass, refClass, validatorClass, order);
	}
	

	/**
	 * This method handels ${urlbase}/add.do GET method request.
	 * @param model ModelMap
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void add(ModelMap model) {
		T entity;
		try {
			entity = (T) domainClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		model.addAttribute("model", entity);
		model = addReference(model);
	}
	
	/**
	 * Thid method handles ${urlbase}/add.do POST method request.
	 * @param model entity object binded by spring from view.
	 * @param result BindingResult
	 * @param status SessionStatus
	 * @return if validation is fail, go to ${urlbase}/add.do. 
	 * if no validation error founded, close popup and refresh grid.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String add(@ModelAttribute("model") T model, BindingResult result, SessionStatus status){
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/add";
		else{
			this.service.add(model);
			status.setComplete();
			return addview(addview, model);
		}
	}
	
	/**
	 * Template method that can change result view, when no validation error founded.
	 * @param addview view name
	 * @param model entiry
	 * @return view name
	 */
	protected String addview(String addview, T model) {
		return addview;
	}

	/**
	 * This method handles ${urlbase}/update.do GET method request.
	 * @param Get an entity object by id, 
	 * and put it to modelMap name in "model" that used by @SessionAttribute.
	 * @param model ModelMap
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void update(int id, ModelMap model){
		model.addAttribute("model", service.get(id));
		model = addReference(model);
	}
	
	/**
	 * This method handles ${urlbase}/update.do POST method request.
	 * @param model entity object binded by spring from view.
	 * @param result BindingResult
	 * @param status SessionStatus
	 * @return view name that will close popup and refresh grid.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String update(@ModelAttribute("model") T model, BindingResult result, SessionStatus status){
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/update";
		else{
			this.service.update(model);
			status.setComplete();
			return updateView(CommonPages.CLOSE_GRID_REFRESH);
		}
	}

	/**
	 * Template method that can change result view, when no validation error founded.
	 * @param updateView view name
	 * @return view name
	 */
	protected String updateView(String updateView) {
		return updateView;
	}
}
