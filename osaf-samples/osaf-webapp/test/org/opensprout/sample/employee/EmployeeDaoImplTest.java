package org.opensprout.sample.employee;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.test.ApplicationContextTestBase;
import org.opensprout.sample.model.Employee;
import org.opensprout.sample.model.enumeration.HobbyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDaoImplTest extends ApplicationContextTestBase {

	@Autowired
	EmployeeDaoImpl employeeDao;
	
	@Test
	public void di() {
		assertNotNull(employeeDao);
	}
	
	@Test
	public void delete(){
		Employee employee = new Employee();
		employeeDao.add(employee);
		employee.addHobby(HobbyType.MOVIE);
		employee.addHobby(HobbyType.CODING);
		
		employeeDao.flushAndClear();
		
		Employee emp = employeeDao.get(employee.getId());
		System.out.println(emp.getHobbies());
		
		employeeDao.delete(employeeDao.get(emp.getId()));
		employeeDao.flushAndClear();
	}
}
