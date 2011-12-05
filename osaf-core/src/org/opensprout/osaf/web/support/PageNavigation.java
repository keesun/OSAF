/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web.support;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensprout.osaf.data.support.OrderPage;
import org.springframework.util.StringUtils;

/**
 * OSAF grid.tag uses this class to show navigation bar. 
 * @author Toby
 */
public class PageNavigation {
	final Log logger = LogFactory.getLog(getClass());
	
	private static final String PAGE_NAME = "grid.do";

	private static final Object PAGE_PARAM_NAME = "page";
	private static final Object PAGESIZE_PARAM_NAME = "pagesize";
	private static final Object ORDER_PARAM_NAME = "order";
	
	int rowCount;
	int pageSize;
	int page;
	String ord;
	String ordValue;
	String searchParams;
	String uriprefix;
	String order;
	
	public PageNavigation(OrderPage orderPage, HttpServletRequest req, String uriprefix) {
		this.rowCount = orderPage.getRowcount();
		this.pageSize = orderPage.getPagesize();
		this.page = orderPage.getPage();
		this.order = orderPage.getOrder();
		this.ord = "order=" + this.order;
//		this.ord = orders.generateOrdersParamString();
//		this.ordValue = orders.generateOrdersParamValue();
		this.searchParams = extractSearchParamsExceptPageParams(req);
		this.uriprefix = !StringUtils.hasText(uriprefix) ? "" : uriprefix;
	}

	@SuppressWarnings("unchecked")
	private String extractSearchParamsExceptPageParams(HttpServletRequest req) {
		StringBuilder param = new StringBuilder();
		
		try {
			Enumeration<String> e = req.getParameterNames(); 
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				
				if (key.equals(PAGE_PARAM_NAME) 
				 || key.equals(PAGESIZE_PARAM_NAME)  
				 ||	key.equals(ORDER_PARAM_NAME)) continue;
				
				String value = req.getParameter(key);
				param.append("&");
				param.append(key);
				param.append("=");
				param.append(URLEncoder.encode(value, "EUC-KR"));
			}

			return param.toString();
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException(e1);
		}
	}

	public String getNavigationBar() {
		StringBuffer str = new StringBuffer("");
	    int pCount = 0;
	    int pStart = 0;
	    
	    pCount = (rowCount - 1) / pageSize + 1;
	    pStart = ((page - 1) / 10) * 10 + 1;
	    if(page > 10)
	    {
	        str.append("<a href=\"");
	        str.append(getPageUri(1));
	        str.append("\">[처음]</a>\n");
	        str.append("<a href=\"");
	        str.append(getPageUri(pStart-10));
	        str.append("\">[이전]</a>\n");
	    }

	    for(int i = pStart; i <= pCount && i - pStart < 10; i++)
	        if(i == page)
	        {
	            str.append("| <strong>");
	            str.append(i);
	            str.append("</strong>&nbsp;");
	        } else
	        {
	            str.append("| <a href=\"");
	            str.append(getPageUri(i));
	            str.append("\">");
	            str.append(i);
	            str.append("</a>&nbsp;");
	        }
	    
	    str.append("|");
	
	    if(pCount - pStart >= 10)
	    {
	        str.append(" <a href=\"");
	        str.append(getPageUri(pStart+10));
	        str.append("\">[다음]</a>");
	        str.append(" <a href=\"");
	        str.append(getPageUri(((pCount - 1) / 10) * 10 + 1));
	        str.append("\">[마지막]</a>");
	    }
	    return str.toString();
	}
	
	public String getUriWithoutPageSize() {
		return getUriWithOrd() + "&" + PAGE_PARAM_NAME + "=1";
	}
	
	public String getUriWithoutPageSizeWithoutOrd() {
		return getBaseUri() + "&" + PAGE_PARAM_NAME + "=1";
	}
	
	public String getUriWithOrd() {
		return getBaseUri() + "&" + ord;
	}
	
	public String getBaseUri() {
		return this.uriprefix + PAGE_NAME + "?" + this.searchParams;
	}
	
	private String getPageUri(int page) {
		return getUriWithOrd() + getPageParams(page); 
	}
	
	private String getPageParams(int page) {
		return "&" + PAGE_PARAM_NAME + "=" + page + 
			   "&" + PAGESIZE_PARAM_NAME + "=" + this.pageSize;
	}
	
	public String getUriWithoutOrd() {
		return getBaseUri() + getPageParams(1);	
	}
	
	public String getPageUriWithoutOrd(int page) {
		return getBaseUri() + getPageParams(page);
	}
	
//	public boolean isAsc() {
//		return this.orders.getOrders().get(0).getOrderType() == OrderType.ASC;
//	}
	
	public boolean hasSameSortFields(String sort) {
//		AbstractWebOrders ords = new AbstractWebOrders();
//		ords.parseOrderString(sort);
//		
//		if (ords.getOrders().size() == this.orders.getOrders().size()) {
//			List<Order> sortOrders = ords.getOrders();
//			List<Order> thisOrders = this.orders.getOrders();
//			
//			for (int i = 0; i<sortOrders.size(); i++) {
//				if (!sortOrders.get(i).getField().equalsIgnoreCase(thisOrders.get(i).getField())) return false;
//			}
//			
//			return true;
//		}
		return false;
	}
	
//	public String reverseOrderType(String sort) {
//		AbstractWebOrders ords = new AbstractWebOrders();
//		ords.parseOrderString(sort);
//		
//		for(Order order : ords.getOrders()) {
//			if (order.getOrderType() == OrderType.ASC) order.setOrderType(OrderType.DESC);
//			else order.setOrderType(OrderType.ASC);
//		}
//		
//		return ords.generateOrdersParamValue();
//	}

	public String getOrd() {
		return ord;
	}

	public void setOrd(String ord) {
		this.ord = ord;
	}

	public String getOrdValue() {
		return ordValue;
	}	
}

