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

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;


import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.hibernate.CriteriaUtils;
import org.opensprout.osaf.util.DateUtils;

/**
 * @author Whiteship
 */
public class CriteriaUtilsTest {

	Criteria c;
	
	@Before
	public void setup(){
		c = mock(Criteria.class);
	}

	@Test
	public void ilike() {
		CriteriaUtils.ilike(c, "name", "keesun", MatchMode.ANYWHERE);
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void ilikeWithNullValue() {
		CriteriaUtils.ilike(c, "name", null, MatchMode.ANYWHERE);
		verify(c, never()).add((Criterion) anyObject());
	}

	@Test
	public void conditionalEqCriteriaStringInt() {
		Criteria c = mock(Criteria.class);
		CriteriaUtils.conditionalEq(c, "id", 1);
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void conditionalEqCriteriaStringIntWithZero() {
		CriteriaUtils.conditionalEq(c, "id", 0);
		verify(c, never()).add((Criterion) anyObject());
	}

	@Test
	public void conditionalEqCriteriaStringDate() {
		CriteriaUtils.conditionalEq(c, "date", DateUtils.makeDate(2008, 8, 12));
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void conditionalEqCriteriaStringDateWithNull() {
		CriteriaUtils.conditionalEq(c, "date", null);
		verify(c, never()).add((Criterion) anyObject());
	}

	@Test
	public void mandatoryEq() {
		CriteriaUtils.mandatoryEq(c, "date", DateUtils.makeDate(2008, 8, 12));
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void mandatoryEqWithNull() {
		CriteriaUtils.mandatoryEq(c, "date", null);
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void conditionalBetweenTimes() {
		CriteriaUtils.conditionalBetweenTimes(c, "datetime", new Date(), new Date());
		verify(c).add((Criterion) anyObject());
	}

	@Test
	public void conditionalBetweenTimesWithNull() {
		CriteriaUtils.conditionalBetweenTimes(c, "datetime", null, new Date());
		verify(c, never()).add((Criterion) anyObject());
	}

}
