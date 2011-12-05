package org.opensprout.sample.task;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.opensprout.osaf.data.hibernate.CriteriaUtils;
import org.opensprout.osaf.data.hibernate.HibernateGenericDao;
import org.opensprout.sample.model.Task;
import org.opensprout.sample.task.support.TaskParams;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends HibernateGenericDao<Task, TaskParams> implements TaskDao {

	@Override
	protected Criteria addRestrictions(Criteria c, TaskParams params) {
		CriteriaUtils.ilike(c, "name", params.getName(), MatchMode.ANYWHERE);
		return c;
	}
	
}
