package org.opensprout.osaf.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.data.GenericDao;
import org.opensprout.osaf.data.hibernate.HibernateGenericDao;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberBaseController;
import org.opensprout.osaf.model.MemberGenericService;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.model.support.MemberRef;
import org.opensprout.osaf.model.support.MemberValidator;
import org.opensprout.osaf.service.BaseService;
import org.opensprout.osaf.service.impl.BaseServiceImpl;
import org.opensprout.osaf.web.BaseController;
import org.opensprout.osaf.web.support.GridColumn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Unit test BaseGenericController
 * @author Whiteship
 * @author Toby
 */
public class BaseControllerTest {

	BaseController<Member, MemberGenericService, MemberRef, MemberValidator, MemberParams> controller;
	MemberGenericService mockService;
	MemberRef mockRef;

	@Before
	public void setUp(){
		controller = new MemberBaseController();
		mockService = mock(MemberGenericService.class);
		mockRef = mock(MemberRef.class);
			
		controller.service = mockService;
		controller.ref = mockRef;
	}
	
	@Test
	public void create() {
		assertNotNull(controller);
		assertNotNull(controller.service);
		assertNotNull(controller.ref);
	}
	
	@Test
	public void ref() {
		assertEquals(mockRef, controller.ref());
	}
	
	@Test
	public void retrieveUrlBase() {
		assertEquals("osaf/member", controller.urlbase);
	}
	
	@Test
	public void delete() {
		int id = 10;
		controller.delete(id);
		Member member = mockService.get(id);
		verify(mockService).delete(member);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void grid() throws Exception {
		ModelMap model = new ModelMap();
		MemberParams params = new MemberParams();
		OrderPage orderPage = new OrderPage();
		List<Member> members = Arrays.asList(new Member(), new Member());
		
		stub(mockService.search(params, orderPage)).toReturn(members);
		
		HttpServletRequest req = new MockHttpServletRequest();
		HttpServletResponse res = new MockHttpServletResponse();
		
		controller.grid(req, res, model, params, orderPage, "");

		assertEquals(members, (List<Member>) model.get("list"));
		assertEquals(orderPage, (OrderPage) model.get("orderPage"));
	}
	
//	@SuppressWarnings("unchecked")
//	@Test 
//	public void buildGridColumns() throws IOException, DocumentException {
//		BaseController bc = 
//			new BaseController<Entity, Service, Ref, Val, Params>(Entity.class) {
//			protected String retrieveUrlBase() { return ""; }
//		};
//		
//		File file = new ClassPathResource("grid.jsp", getClass()).getFile();
//		List<GridColumn> columns = bc.buildGridColumns(file);
//		assertThat(columns.size(), is(4));
//	}
}

/**		grid.jsp
 * 		<o:col header="a" path="a" hidden="true" />
		<o:col header="b" path="b" width="100" />
		<o:col header="c" path="c.name" width="50"/>
		<o:col header="d" path="d" width="50" />
 */
class Entity {
	String a;
	int b;
	Date d;

	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
}

class C {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Params {
}

class Ref {
}

class Val implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class arg0) {
		return false;
	}

	public void validate(Object arg0, Errors arg1) {
	}
}

class Dao extends HibernateGenericDao<Entity, Params> implements GenericDao<Entity, Params>  {
}

class Service extends BaseServiceImpl<Entity, Dao, Params> implements BaseService<Entity, Dao, Params> {
	protected Service(Class<Dao> daoClass) {
		super(daoClass);
	}
}