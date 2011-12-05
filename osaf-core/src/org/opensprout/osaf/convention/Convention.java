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

/**
 * convention interface to find other classes by naming convention.
 * @author Whiteship
 */
public interface Convention {

	/**
	 * find domain class from DAO class.
	 * @param DAO Class
	 * @return domain class
	 */
	public Class getDomainClassFromDao(Class daoClass);
	
	/**
	 * find domain class from controller.
	 * @param controllerClass
	 * @return domain class
	 */
	public Class getDomainClassFromController(Class controllerClass);
	
	/**
	 * check if the class keeps naming convention.
	 * @param className checking target className.
	 * @param prefix prefix that sould be existed front of the className.
	 * @param suffix suffix that sould be existed end of the className.
	 * @return return true if the className keeps naming convention, or return false.
	 */
	public boolean isRightNamingConvention(String className, String prefix, String suffix);

	//TODO find domain form service, dao from service, dao from controller, service from controller.  
}
