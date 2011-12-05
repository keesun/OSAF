package org.opensprout.osaf.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberContextGenericController;
import org.opensprout.osaf.model.MemberContextGenericService;
import org.opensprout.osaf.model.support.MemberContext;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.model.support.MemberRef;
import org.opensprout.osaf.model.support.MemberValidator;
import org.opensprout.osaf.web.ContextGenericController;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;

/**
 * Unit test for ContextGenericController class
 * @author Whiteship
 */
public class ContextGenericControllerTest {

	ContextGenericController<Member, MemberContextGenericService, MemberRef, MemberValidator, MemberParams, MemberContext> controller;
	MemberContextGenericService mockService;
	MemberValidator mockValidator;

	@Before
	public void setUp() {
		controller = new MemberContextGenericController();
		mockService = mock(MemberContextGenericService.class);
		mockValidator = mock(MemberValidator.class);
		controller.service = mockService;
		controller.validator = mockValidator;
	}

	@Test
	public void create() {
		assertNotNull(controller);
		assertNotNull(controller.service);
	}

	@Test
	public void addGet() {
		ModelMap map = new ModelMap();
		MemberContext context = new MemberContext();
		
		assertThat((Member)map.get("model"), is(nullValue()));
		assertThat((MemberContext)map.get("context"), is(nullValue()));

		controller.add(map, context);

		assertThat(map.get("model"), is(notNullValue()));
		assertThat((MemberContext)map.get("context"), is(context));
	}

	@Test
	public void addPost() {
		Member member = new Member();
		MemberContext context = new MemberContext();
		BindException result = new BindException(member, "model");
		SessionStatus status = new SimpleSessionStatus();
		
		controller.add(member, result, context, status);

		verify(mockValidator).validate(member, result);
		verify(mockService).add(member, context);
	}

	@Test
	public void updateGet() {
		int id = 10;
		Member member = new Member();
		member.setId(id);
		ModelMap model = new ModelMap();
		MemberContext context = new MemberContext();
		
		stub(mockService.get(id)).toReturn(member);

		assertThat((Member)model.get("model"), is(nullValue()));
		assertThat((MemberContext)model.get("context"), is(nullValue()));
		
		controller.update(id, model, context);
		
		assertThat((Member)model.get("model"), is(member));
		assertThat((MemberContext)model.get("context"), is(context));
	}
	
	@Test
	public void updatePost() {
		Member member = new Member();
		MemberContext context = new MemberContext();
		BindException result = new BindException(member, "model");
		SessionStatus status = new SimpleSessionStatus();
		
		controller.update(member, result, context, status);

		verify(mockService).update(member, context);
		verify(mockValidator).validate(member, result);
	}

}
