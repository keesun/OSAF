/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.convention;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensprout.osaf.convention.exception.CannotLoadDomainClassException;
import org.opensprout.osaf.convention.exception.ConventionException;

/**
 * Default implementation of Convention.
 * @author Whiteship
 * @see org.opensprout.osaf.convention.Convention
 */
public class DefaultConvention implements Convention {
	
	public static Log logger = LogFactory.getLog(DefaultConvention.class);

	protected String domainPackageName = "org.opensprout.osaf.model";
	protected String daoPrefix = "";
	protected String daoSuffix = "DaoImpl";
	protected String controllerPrefix = "";
	protected String controllerSuffix = "Controller";
	protected String servicePrefix = "";
	protected String serviceSuffix = "ServiceImpl";
	
	public String getDomainPackageName() {
		return domainPackageName;
	}
	public void setDomainPackageName(String domainPackageName) {
		this.domainPackageName = domainPackageName;
	}
	public String getDaoPrefix() {
		return daoPrefix;
	}
	public void setDaoPrefix(String daoPrefix) {
		this.daoPrefix = daoPrefix;
	}
	public String getDaoSuffix() {
		return daoSuffix;
	}
	public void setDaoSuffix(String daoSuffix) {
		this.daoSuffix = daoSuffix;
	}
	public String getControllerPrefix() {
		return controllerPrefix;
	}
	public void setControllerPrefix(String controllerPrefix) {
		this.controllerPrefix = controllerPrefix;
	}
	public String getControllerSuffix() {
		return controllerSuffix;
	}
	public void setControllerSuffix(String controllerSuffix) {
		this.controllerSuffix = controllerSuffix;
	}
	public String getServicePrefix() {
		return servicePrefix;
	}
	public void setServicePrefix(String servicePrefix) {
		this.servicePrefix = servicePrefix;
	}
	public String getServiceSuffix() {
		return serviceSuffix;
	}
	public void setServiceSuffix(String serviceSuffix) {
		this.serviceSuffix = serviceSuffix;
	}
	
	@SuppressWarnings("unchecked")
	public Class getDomainClassFromDao(Class daoClass) {
		String className = daoClass.getSimpleName();
		isRightNamingConvention(className, daoPrefix, daoSuffix);
		return getClass(domainPackageName + "." + 
				takeOffPrefixAndSuffix(className, daoPrefix, daoSuffix));
	}
	
	@SuppressWarnings("unchecked")
	public Class getDomainClassFromController(Class controllerClass) {
		String className = controllerClass.getSimpleName();
		isRightNamingConvention(className, controllerPrefix, controllerSuffix);
		return getClass(domainPackageName + "." + 
				takeOffPrefixAndSuffix(className, controllerPrefix, controllerSuffix));
	}

	@SuppressWarnings("unchecked")
	public Class getDaoClassFromService(Class clazz) {
		String serviceClassName = clazz.getSimpleName();
		isRightNamingConvention(serviceClassName, servicePrefix, serviceSuffix);
		//TODO convention for service to dao
		throw new UnsupportedOperationException();
	}

	private String takeOffPrefixAndSuffix(String className, String prefix,
			String suffix) {
		return className.replace(prefix, "").replace(suffix, "");
	}
	
	public boolean isRightNamingConvention(String className,
			String prefix, String suffix) {
		if (!className.contains(prefix))
			throw new ConventionException("Wrong Dao Prefix [" + prefix
					+ "]. Check project's convention.");
		if (!className.contains(suffix))
			throw new ConventionException("Wrong Dao Suffix [" + suffix
					+ "]. Check project's convention.");
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Class getClass(String className) {
		logger.debug("Try class loading by name [" + className + "]");
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.debug("Failed class loading by name [" + className + "]");
			throw new CannotLoadDomainClassException(e);
		}
	}
}
