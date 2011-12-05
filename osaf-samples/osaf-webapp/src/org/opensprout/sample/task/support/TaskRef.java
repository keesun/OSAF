package org.opensprout.sample.task.support;

import org.opensprout.sample.model.enumeration.TaskType;
import org.springframework.stereotype.Component;

/**
 * �˻� �� �信�� ������ ������ ������ �����մϴ�.
 * @author Whiteship
 */
@Component
public class TaskRef {

	public TaskType getTaskType(){
		return TaskType.getInstance();
	}
	
}
