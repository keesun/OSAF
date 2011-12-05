package org.opensprout.sample.model.enumeration;

import java.util.Arrays;

import org.opensprout.osaf.enumeration.AbstractType;
import org.opensprout.osaf.enumeration.Pair;

public class TaskType extends AbstractType {

	public static final int CREATED = 10;
	public static final int STARTED = 20;
	public static final int STOPED = 30;
	public static final int ENDED = 40;
	public static final int CANCELED = 50;

	private static TaskType taskType = new TaskType();
	
	public TaskType() {
		super(Arrays.asList(
				new Pair(CREATED, "생성"),
				new Pair(STARTED, "시작"),
				new Pair(STOPED, "중지"),
				new Pair(ENDED, "완료"),
				new Pair(CANCELED, "취소")));
	}
	
	public static TaskType getInstance(){
		return taskType;
	}
	
}
