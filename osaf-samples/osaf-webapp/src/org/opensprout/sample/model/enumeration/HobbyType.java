package org.opensprout.sample.model.enumeration;

import java.util.Arrays;

import org.opensprout.osaf.enumeration.AbstractType;
import org.opensprout.osaf.enumeration.Pair;

public class HobbyType extends AbstractType {

	public static final int CODING = 10;
	public static final int MUSIC = 20;
	public static final int MOVIE = 30;

	public HobbyType() {
		super(Arrays.asList(
				new Pair(CODING, "�ڵ�"), 
				new Pair(MUSIC, "����"),
				new Pair(MOVIE, "��ȭ"))
		);
	}

	private static HobbyType hobbyType = new HobbyType();

	public static HobbyType getInstance() {
		return hobbyType;
	}

}
