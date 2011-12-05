package org.opensprout.sample.employee.support;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Whiteship
 */
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "required", "입력하세요.");
	}

}
