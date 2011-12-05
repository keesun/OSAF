package org.opensprout.sample.employee;

import org.opensprout.osaf.data.hibernate.HibernateDao;
import org.opensprout.sample.employee.support.EmployeeParams;
import org.opensprout.sample.model.Employee;

public interface EmployeeDao extends HibernateDao<Employee, EmployeeParams>{

}
