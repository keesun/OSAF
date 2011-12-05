package org.opensprout.sample.employee;

import org.opensprout.osaf.web.GenericController;
import org.opensprout.sample.employee.support.EmployeeParams;
import org.opensprout.sample.employee.support.EmployeeRef;
import org.opensprout.sample.employee.support.EmployeeValidator;
import org.opensprout.sample.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/*.do")
public class EmployeeController extends GenericController<Employee, EmployeeService, EmployeeRef, EmployeeValidator, EmployeeParams>{

	protected EmployeeController() {
		super(Employee.class, EmployeeService.class, EmployeeRef.class, EmployeeValidator.class);
		this.order = "name asc";
	}
	
}