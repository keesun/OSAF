/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.data.support;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.support.OrderPage;

/**
 * @author Whiteship
 */
public class OrderPageTest {

	private OrderPage orderPage;

	@Before
	public void setUp() {
		orderPage = new OrderPage();
	}

	@Test
	public void create() {
		assertNotNull(orderPage);
		assertEquals(null, orderPage.getOrder());
		assertEquals(30, orderPage.getPagesize());
		assertEquals(1, orderPage.getPage());
		assertEquals(0, orderPage.getRowcount());
		assertEquals(0, orderPage.getStartRowno());
	}

	@Test
	public void startRowNum() {
		orderPage.setRowcount(100);
		assertEquals(100, orderPage.getRowcount());

		orderPage.setPage(1);
		orderPage.setPagesize(5);
		assertEquals(1, orderPage.getStartRowno());
		assertEquals(5, orderPage.getPagesize());

		orderPage.setPage(2);
		assertEquals(6, orderPage.getStartRowno());
		assertEquals(5, orderPage.getPagesize());

		orderPage.setPage(1);
		orderPage.setPagesize(10);
		assertEquals(1, orderPage.getStartRowno());
		assertEquals(10, orderPage.getPagesize());

		orderPage.setPage(2);
		assertEquals(11, orderPage.getStartRowno());
		assertEquals(10, orderPage.getPagesize());
	}

	@Test
	public void applyPage() throws Exception {
		int page = 1;
		int pagesize = 20;

		orderPage.setPage(page);
		orderPage.setPagesize(pagesize);

		Criteria mockCriteria = mock(Criteria.class);

		stub(mockCriteria.setFirstResult((page - 1) * pagesize)).toReturn(mockCriteria);
		stub(mockCriteria.setMaxResults(pagesize)).toReturn(mockCriteria);
		orderPage.applyPage(mockCriteria);
	}

	@Test(expected = IllegalStateException.class)
	public void applyPageErrorByPage() throws Exception {
		int page = 0;
		orderPage.setPage(page);

		Criteria mockCriteria = mock(Criteria.class);
		orderPage.applyPage(mockCriteria);
	}

	@Test(expected = IllegalStateException.class)
	public void applyPageErrorByPagesize() throws Exception {
		int pagesize = 0;
		orderPage.setPagesize(pagesize);

		Criteria mockCriteria = mock(Criteria.class);
		orderPage.applyPage(mockCriteria);
	}

	@Test
	public void applyOrder() {
		String order = "id DESC";
		orderPage.setOrder(order);
		
		Criteria mockCriteria = mock(Criteria.class);
		stub(mockCriteria.addOrder(Order.desc("id"))).toReturn(mockCriteria);
		orderPage.applyOrder(mockCriteria);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void applyOrderError() {
		String order = "id XYZ";
		orderPage.setOrder(order);
		Criteria mockCriteria = mock(Criteria.class);
		orderPage.applyOrder(mockCriteria);
	}

}
