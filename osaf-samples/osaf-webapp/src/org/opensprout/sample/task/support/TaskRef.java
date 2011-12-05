package org.opensprout.sample.task.support;

import org.opensprout.sample.model.enumeration.TaskType;
import org.springframework.stereotype.Component;

/**
 * 검색 및 뷰에서 참조할 데이터 집합을 정의합니다.
 * @author Whiteship
 */
@Component
public class TaskRef {

	public TaskType getTaskType(){
		return TaskType.getInstance();
	}
	
}
