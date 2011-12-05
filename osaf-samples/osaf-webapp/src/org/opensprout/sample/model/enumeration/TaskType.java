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
				new Pair(CREATED, "����"),
				new Pair(STARTED, "����"),
				new Pair(STOPED, "����"),
				new Pair(ENDED, "�Ϸ�"),
				new Pair(CANCELED, "���")));
	}
	
	public static TaskType getInstance(){
		return taskType;
	}
	
}
