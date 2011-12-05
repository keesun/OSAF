package org.opensprout.sample.model.enumeration;

import java.util.Arrays;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
import org.opensprout.osaf.enumeration.AbstractType;
import org.opensprout.osaf.enumeration.Pair;

public class SexType extends AbstractType implements DisplaytagColumnDecorator {

	public static final int MALE = 10;
	public static final int FEMALE = 20;
	
	public SexType() {
		super(Arrays.asList(
			new Pair(MALE, "남성"),
			new Pair(FEMALE, "여성")));
	}
	
	private static SexType sexType = new SexType();
	
	public static SexType getInstance(){
		return sexType;
	}

	@Override
	public Object decorate(Object object, PageContext context, MediaTypeEnum typeEnum)
			throws DecoratorException {
		return this.decode((Integer)object);
	}
	
}
