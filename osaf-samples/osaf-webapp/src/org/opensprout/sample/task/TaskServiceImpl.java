package org.opensprout.sample.task;

import org.opensprout.osaf.service.impl.GenericServiceImpl;
import org.opensprout.sample.model.Task;
import org.opensprout.sample.task.support.TaskParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl extends GenericServiceImpl<Task, TaskDao, TaskParams> implements TaskService {

	public TaskServiceImpl() {
		super(TaskDao.class);
	}

}
