package org.opensprout.osaf.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberGenericController;
import org.opensprout.osaf.model.MemberGenericService;
import org.opensprout.osaf.model.support.MemberParams;
import org.opensprout.osaf.model.support.MemberRef;
import org.opensprout.osaf.model.support.MemberValidator;
import org.opensprout.osaf.web.GenericController;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;

/**
 * Unit test GenericController class
 * @author Whiteship
 */
public class GenericControllerTest {

	GenericController<Member, MemberGenericService, MemberRef, MemberValidator, MemberParams> controller;
	MemberGenericService mockService;
	MemberValidator mockValidator;

	@Before
	public void setup() {
		controller = new MemberGenericController();
		mockService = mock(MemberGenericService.class);
		mockValidator = mock(MemberValidator.class);
		controller.service = mockService;
		controller.validator = mockValidator;
	}

	@Test
	public void create() {
		assertNotNull(controller);
		assertNotNull(controller.service);
		assertNotNull(controller.validator);
	}

	@Test
	public void addGet() {
		ModelMap model = new ModelMap();
		assertThat(model.get("model"), is(nullValue()));
		controller.add(model);
		assertThat(model.get("model"), is(notNullValue()));
	}

	@Test
	public void addPost() {
		Member member = new Member();
		SessionStatus status = new SimpleSessionStatus();
		BindException result = new BindException(member, "model");
		controller.add(member, result, status);
		verify(mockValidator).validate(member, result);
		verify(mockService).add(member);
	}

	@Test
	public void updateGet() {
		ModelMap model = new ModelMap();
		int id = 10;
		Member member = new Member();
		member.setId(id);
		
		stub(mockService.get(id)).toReturn(member);
		assertThat(model.get("model"), is(nullValue()));
		controller.update(id, model);
		assertThat(model.get("model"), is(notNullValue()));
	}

	@Test
	public void updatePost() {
		Member member = new Member();
		SessionStatus status = new SimpleSessionStatus();
		BindException result = new BindException(member, "model");
		controller.update(member, result, status);
		verify(mockValidator).validate(member, result);
		verify(mockService).update(member);
	}

}
