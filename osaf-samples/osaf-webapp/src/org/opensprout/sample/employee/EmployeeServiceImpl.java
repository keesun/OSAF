package org.opensprout.sample.employee;

import org.opensprout.osaf.service.impl.GenericServiceImpl;
import org.opensprout.sample.employee.support.EmployeeParams;
import org.opensprout.sample.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, EmployeeDao, EmployeeParams> implements EmployeeService {

	public EmployeeServiceImpl() {
		super(EmployeeDao.class);
	}

}
