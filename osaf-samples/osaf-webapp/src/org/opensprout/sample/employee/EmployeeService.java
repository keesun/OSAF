package org.opensprout.sample.employee;

import org.opensprout.osaf.service.GenericService;
import org.opensprout.sample.employee.support.EmployeeParams;
import org.opensprout.sample.model.Employee;

public interface EmployeeService extends GenericService<Employee, EmployeeDao, EmployeeParams>{

}
