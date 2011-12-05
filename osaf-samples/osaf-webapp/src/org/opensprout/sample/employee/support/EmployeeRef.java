package org.opensprout.sample.employee.support;

import java.util.Arrays;
import java.util.List;

import org.opensprout.sample.model.enumeration.HobbyType;
import org.opensprout.sample.model.enumeration.SexType;
import org.springframework.stereotype.Component;

/**
 * @author Whiteship
 */
@Component
public class EmployeeRef {

	public SexType getSexType(){
		return SexType.getInstance();
	}

	public HobbyType getHobbyType(){
		return HobbyType.getInstance();
	}
	
	public List<String> getLocations(){
		return Arrays.asList(new String[]{"Korea", "America", "China", "Australia"});
	}
}
