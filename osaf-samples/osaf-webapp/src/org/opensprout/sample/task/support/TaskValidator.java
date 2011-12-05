package org.opensprout.sample.task.support;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Whiteship
 */
@Component
public class TaskValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
