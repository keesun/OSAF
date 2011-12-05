package org.opensprout.sample.employee;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.opensprout.osaf.data.hibernate.CriteriaUtils;
import org.opensprout.osaf.data.hibernate.HibernateGenericDao;
import org.opensprout.sample.employee.support.EmployeeParams;
import org.opensprout.sample.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends HibernateGenericDao<Employee, EmployeeParams> implements EmployeeDao {

	@Override
	protected Criteria addRestrictions(Criteria c, EmployeeParams params) {
		CriteriaUtils.ilike(c, "name", params.getName(), MatchMode.ANYWHERE);
		return c;
	}
	
}
