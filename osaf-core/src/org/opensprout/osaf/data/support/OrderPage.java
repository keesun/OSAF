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

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

/**
 * Order sand Apply paging to searching result.
 * @author Toby
 */
public class OrderPage {
	private static final int DEFAULT_PAGESIZE = 30;
	
	// params
	String order;
	int page = 1;
	int pagesize = DEFAULT_PAGESIZE;
	
	// result
	int rowcount;
	
	public PageSize getPageSizes() {
		return PageSize.getInstance();
	}
	
	/**
	 * return start row number.
	 * ex) When pagesize is 30, 2 page's start row number is 31.
	 * ex) When pagesize is 20, 3 page's start row number is 41.
	 * @return start row number
	 */
	public int getStartRowno() {
		if (rowcount == 0) 
			return 0;
		else
			return (page - 1) * pagesize + 1;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	/**
	 * Apply paging to Criteria by FirstResult and MaxResults.
	 * @param c Criteria
	 * @see org.hibernate.Criteria#setFirstResult(int)
	 * @see org.hibernate.Criteria#setMaxResults(int)
	 */
	public void applyPage(Criteria c) {
		if (page < 1 || pagesize < 1) {
			throw new IllegalStateException("Invalid curpage " + page + " or pagesize " + pagesize);
		}
		
		c.setFirstResult((page-1) * pagesize);
		c.setMaxResults(pagesize);
	}
	
	/**
	 * Apply order to Criteria by order property
	 * ex) order = "name asc age desc";
	 * 'name' and 'age' is entity's property name not table column's name.
	 * @param c Criteria
	 */
	public void applyOrder(Criteria c) {
		if(order == null) return;
		String[] orderTokens = order.split(" ");
		for(int i=0; i<orderTokens.length; i+=2) {
			String field = orderTokens[i];
			String ascdesc = orderTokens[i+1].toUpperCase();
			if ("ASC".equals(ascdesc)) c.addOrder(Order.asc(field));
			else if ("DESC".equals(ascdesc)) c.addOrder(Order.desc(field));
			else 
				throw new IllegalArgumentException("Invalid Asc/Desc Parameter : " + ascdesc);
		}
	}
}
