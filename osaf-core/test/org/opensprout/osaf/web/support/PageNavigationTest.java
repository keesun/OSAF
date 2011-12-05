package org.opensprout.osaf.web.support;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.web.support.PageNavigation;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Unit test PageNavigation class
 * @author Whiteship
 */
public class PageNavigationTest {

	PageNavigation pageNavigation;

	OrderPage orderPage;
	MockHttpServletRequest req;
	String uriprefix;

	@Before
	public void setup() {
		orderPage = getStubOrderPage();
		req = getStubMockHttpServletRequest();
		uriprefix = "";
		pageNavigation = new PageNavigation(orderPage, req, uriprefix);
	}
	
	@Test
	public void properties() {
		assertNotNull(pageNavigation);
		assertThat(pageNavigation.rowCount, is(orderPage.getRowcount()));
		assertThat(pageNavigation.pageSize, is(orderPage.getPagesize()));
		assertThat(pageNavigation.page, is(orderPage.getPage()));
		assertThat(pageNavigation.order, is(orderPage.getOrder()));
		assertThat(pageNavigation.ord, is("order=" + pageNavigation.order));
		assertThat(pageNavigation.searchParams, is("&name=keesun"));
		assertThat(pageNavigation.uriprefix, is(uriprefix));
	}

	private MockHttpServletRequest getStubMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		// thease will be removed.
		request.setParameter("page", "1");
		request.setParameter("pagesize", "20");
		request.setParameter("order", "id desc");
		// thease will be remain
		request.setParameter("name", "keesun");
		return request;
	}

	private OrderPage getStubOrderPage() {
		OrderPage orderPage = new OrderPage();
		orderPage.setOrder("name asc");
		orderPage.setPage(2);
		orderPage.setPagesize(30);
		orderPage.setRowcount(1000);
		return orderPage;
	}
	
	@Test
	public void getBaseUri() {
		assertThat(pageNavigation.getBaseUri(), 
				is("grid.do?&name=keesun"));
	}
	
	@Test
	public void getUriWithOrd() {
		assertThat(pageNavigation.getUriWithOrd(), 
				is("grid.do?&name=keesun&order=name asc"));
	}
	
	@Test
	public void getUriWithoutOrd() {
		assertThat(pageNavigation.getUriWithoutOrd(), 
				is("grid.do?&name=keesun&page=1&pagesize=30") );
	}
	
	@Test
	public void getPageUriWithoutOrd() {
		assertThat(pageNavigation.getPageUriWithoutOrd(1), 
				is("grid.do?&name=keesun&page=1&pagesize=30") );
		assertThat(pageNavigation.getPageUriWithoutOrd(2), 
				is("grid.do?&name=keesun&page=2&pagesize=30") );
	}
	
	@Test
	public void getUriWithoutPageSizeWithoutOrd() {
		assertThat(pageNavigation.getUriWithoutPageSizeWithoutOrd(), 
				is("grid.do?&name=keesun&page=1") );
	}
	
	@Test
	public void getUriWithoutPageSize() {
		assertThat(pageNavigation.getUriWithoutPageSize(), 
				is("grid.do?&name=keesun&order=name asc&page=1") );
	}
	
	@Test
	public void getNavigationBar() {
		//TODO test
	}

}
