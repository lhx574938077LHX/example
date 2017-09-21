package com.icefox.Serializable;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813951338292185483L;
	
	private int age;
	
	private String name;
	
	private String sex;
	
	private Date birthday;
	
	public Person() {
	}
	
	public Person(int age,String name,String sex,Date birthday) {
		this.age=age;
		this.name=name;
		this.sex=sex;
		this.birthday=birthday;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
