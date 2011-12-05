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

import java.util.Date;


import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.opensprout.osaf.util.DateUtils;
import org.springframework.util.StringUtils;

/**
 * Util class for Hibernate Criteria.
 * @author Toby
 * @author Whiteship
 * @see org.hibernate.Criteria
 */
public class CriteriaUtils {

	public static void ilike(Criteria c, String propertyName, String value, MatchMode matchMode) {
		if (StringUtils.hasText(value)) {
			c.add(Restrictions.ilike(propertyName, value, matchMode));
		}
	}
	
	public static void conditionalEq(Criteria c, String propertyName, int value) {
		if (value > 0) {
			c.add(Restrictions.eq(propertyName, value));
		}
	}

	public static void conditionalEq(Criteria c, String propertyName, Date value) {
		if (value != null) {
			c.add(Restrictions.eq(propertyName, value));
		}
	}

	public static void mandatoryEq(Criteria c, String propertyName, Date value) {
		if (value == null) {
			value = DateUtils.makeDate(2000, 1, 1);
			c.add(Restrictions.eq(propertyName, value));
		} else
			c.add(Restrictions.eq(propertyName, value));
	}
	
    public static void conditionalBetweenTimes(Criteria c, String propertyName, Date from, Date to) {
    	if (from != null && to != null)
    		c.add(Expression.between(propertyName,  
        		new java.sql.Date(from.getTime()), new java.sql.Date(DateUtils.getLastDateTimeOf(to).getTime())));
    }

}
