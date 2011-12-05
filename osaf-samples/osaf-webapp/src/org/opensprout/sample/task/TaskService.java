package org.opensprout.sample.task;

import org.opensprout.osaf.service.GenericService;
import org.opensprout.sample.model.Task;
import org.opensprout.sample.task.support.TaskParams;

public interface TaskService extends GenericService<Task, TaskDao, TaskParams>{

}
