/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.opensprout.osaf.util.DateUtils;

/**
 * Unit test DateUtil class
 * @author Whiteship
 */
public class DateUtilsTest {
	
	@Test
	public void makeDate() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertNotNull(date);
		assertEquals(new GregorianCalendar(2008, 4-1, 20).getTime(), date);
	}
	
	@Test
	public void makeDateTime() {
		Date date = DateUtils.makeDateTime(2008, 4, 20, 12, 30, 0);
		assertEquals(new GregorianCalendar(2008, 4-1, 20, 12, 30, 0).getTime(), date);
	}
	
	@Test
	public void makeYYYYMMDD() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals("2008/04/20", DateUtils.makeYYYYMMDD(date));
	}
	
	@Test
	public void makeYYYYMMDDWithoutDelim() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals("20080420", DateUtils.makeYYYYMMDDWithoutDelim(date));
	}
	
	@Test
	public void makeYYMMDDWithoutDelim() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals("080420", DateUtils.makeYYMMDDWithoutDelim(date));
	}
	
	@Test
	public void makeYYYYMMWithHypon() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals("2008-04", DateUtils.makeYYYYMMWithHypon(date));
	}
	
	@Test
	public void lastTimeOfTheDate() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals(DateUtils.makeDateTime(2008, 4, 20, 23, 59, 59), 
				DateUtils.getLastDateTimeOf(date));
	}
	
	@Test
	public void addDate() {
		Date date = DateUtils.makeDate(2008, 4, 20);
		assertEquals(new GregorianCalendar(2008, 4-1, 21).getTime(), 
				DateUtils.addDate(date, 1));
	}
	
	@Test
	public void parseYYYYMMDD() {
		String yyyymmdd = "20080420";
		Date date = DateUtils.parseYYYYMMDD(yyyymmdd);
		assertEquals(DateUtils.makeDate(2008, 4, 20), date);
	}
	
	@Test
	public void parseYYYYMMDDWithHypon() {
		String yyyymmdd = "2008-04-20";
		Date date = DateUtils.parseYYYYMMDDWithHypon(yyyymmdd);
		assertEquals(DateUtils.makeDate(2008, 4, 20), date);
	}
	
	@Test
	public void startTimeAndEndTime() {
		Date date = DateUtils.makeDate(2008, 6, 13);
		assertEquals("2008-06-13 00:00:00.0", DateUtils.getStartTimeStampOfDate(date).toString());
		assertEquals("2008-06-13 23:59:59.0", DateUtils.getEndTimeStampOfDate(date).toString());
	}
	
	@Test
	public void startDateAndEndDate() {
		String date = "2008-04-01";
		assertEquals(DateUtils.makeDate(2008, 4, 01), DateUtils.getStartDateOfMonth(date));
		assertEquals(DateUtils.makeDate(2008, 4, 30), DateUtils.getEndDateOfMonth(date));

		date = "2008-05-01";
		assertEquals(DateUtils.makeDate(2008, 5, 01), DateUtils.getStartDateOfMonth(date));
		assertEquals(DateUtils.makeDate(2008, 5, 31), DateUtils.getEndDateOfMonth(date));

		date = "2008-02-01";
		assertEquals(DateUtils.makeDate(2008, 2, 01), DateUtils.getStartDateOfMonth(date));
		assertEquals(DateUtils.makeDate(2008, 2, 29), DateUtils.getEndDateOfMonth(date));

		date = "2009-02-01";
		assertEquals(DateUtils.makeDate(2009, 2, 01), DateUtils.getStartDateOfMonth(date));
		assertEquals(DateUtils.makeDate(2009, 2, 28), DateUtils.getEndDateOfMonth(date));
	}
	
	@Test
	public void addMonth() {
		Date date = DateUtils.makeDate(2008, 4, 1);
		assertEquals(DateUtils.makeDate(2008, 5, 1), DateUtils.addMonth(date, 1));
	}
	
	@Test
	public void startDateOfMonthAndEndDateOfMonth() {
		Date date = DateUtils.makeDate(2008, 4, 10);
		assertEquals(DateUtils.makeDate(2008, 4, 01), DateUtils.getStartDateOfMonth(date));
		assertEquals(DateUtils.makeDate(2008, 4, 30), DateUtils.getEndDateOfMonth(date));
	}

}
