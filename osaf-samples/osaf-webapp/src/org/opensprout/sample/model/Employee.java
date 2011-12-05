package org.opensprout.sample.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CollectionOfElements;
import org.opensprout.sample.model.enumeration.SexType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name; // Text field
	private String loginId;
	private String password; // Password
	private int sex; // Radio button
	@CollectionOfElements
	@Cascade(CascadeType.DELETE)
	private List<Integer> hobbies; // check boxes
	private String location; // Select
	private String memo; // Textarea
	@Temporal(TemporalType.DATE)
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Integer> getHobbies() {
		if (this.hobbies == null)
			hobbies = new ArrayList<Integer>();
		return hobbies;
	}

	public void setHobbies(List<Integer> hobbies) {
		this.hobbies = hobbies;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void addHobby(int hobbyType) {
		this.getHobbies().add(hobbyType);
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getSexDecode(){
		return SexType.getInstance().decode(this.sex);
	}

}