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
import org.opensprout.osaf.service.ContextGenericService;
import org.opensprout.osaf.web.support.CommonPages;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * This is ContextGenericController,
 * that handles add and update request depends on context.
 * @author Toby
 * @param <T> Entity class type
 * @param <S> ContextGenericService class type
 * @param <R> Rerefences class type
 * @param <V> Validator class type
 * @param <P> Searching Parameters class type
 * @param <C> Context class type
 */
public abstract class ContextGenericController<T,S extends ContextGenericService<T, ? extends GenericDao<T,P>, P, C>,
				R,V extends Validator, P, C> extends BaseController<T, S, R, V, P> {

	protected ContextGenericController(Class<T> entityClass,
			Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass) {
		super(entityClass, serviceClass, refClass, validatorClass);
	}
	
	protected ContextGenericController(Class<T> entityClass,
			Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass,
			String order) {
		super(entityClass, serviceClass, refClass, validatorClass, order);
	}
	

	/**
	 * This method handels ${urlbase}/add.do GET method request.
	 * @param model ModelMap
	 * @param context Context type(C) object.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public final void add(ModelMap model, C context) {
		T entity;
		try {
			entity = (T) domainClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		model.addAttribute("model", entity);
		model.addAttribute("context", context);
		model = addReference(model);
	}
	
	/**
	 * Thid method handles ${urlbase}/add.do POST method request.
	 * @param model entity object binded by spring from view.
	 * @param result BindingResult
	 * @param context Context type(C) object
	 * @param status SessionStatus
	 * @return view name that will close popup and refersh grid.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String add(@ModelAttribute("model") T model, BindingResult result, C context, SessionStatus status){
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/add";
		else{
			this.service.add(model, context);
			status.setComplete();
			return CommonPages.CLOSE_GRID_REFRESH;
		}
	}
	
	/**
	 * This method handles ${urlbase}/update.do GET method request.
	 * @param id Get an entity object by id, 
	 * and put it to modelMap name in "model" that used by @SessionAttribute.
	 * @param model ModelMap
	 * @param context Context type(C) object
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void update(int id, ModelMap model, C context){
		model.addAttribute("model", service.get(id));
		model.addAttribute("context", context);
		model = addReference(model);
	}
	
	/**
	 * This method handles ${urlbase}/update.do POST method request.
	 * @param model entity object binded by spring from view.
	 * @param result BindingResult
	 * @param context Context type(C) object
	 * @param status SessionStatus
	 * @return view name that will close popup and refresh grid.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String update(@ModelAttribute("model") T model, BindingResult result, C context, SessionStatus status){
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/update";
		else{
			this.service.update(model, context);
			status.setComplete();
			return CommonPages.CLOSE_GRID_REFRESH;
		}
	}
}
