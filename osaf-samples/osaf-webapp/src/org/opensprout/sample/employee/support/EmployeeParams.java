package org.opensprout.sample.employee.support;

import java.util.Date;
import java.util.List;

/**
 * @author Whiteship
 */
public class EmployeeParams {

	private String name;
	private String location;
	private int sexType;
	private Date birthday;
	private List<Integer> hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSexType() {
		return sexType;
	}

	public void setSexType(int sexType) {
		this.sexType = sexType;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Integer> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Integer> hobbies) {
		this.hobbies = hobbies;
	}

}
