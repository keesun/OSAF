package org.opensprout.sample.task;

import org.opensprout.osaf.web.GenericController;
import org.opensprout.sample.model.Task;
import org.opensprout.sample.task.support.TaskParams;
import org.opensprout.sample.task.support.TaskRef;
import org.opensprout.sample.task.support.TaskValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task/*.do")
public class TaskController extends GenericController<Task, TaskService, TaskRef, TaskValidator, TaskParams>{

	protected TaskController() {
		super(Task.class, TaskService.class, TaskRef.class, TaskValidator.class);
		this.order = "name asc";
	}
}
