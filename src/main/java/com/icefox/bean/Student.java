package com.icefox.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")  
public class Student implements Serializable {
	
	private static final long serialVersionUID = 5831056732087399074L;
	
	private String name;
	private Short age;
	private Short sex;

	@XmlElement(name="Name")  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="Age")  
	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@XmlAttribute(name="Sex")  
	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}
	
	public Student()
	{
		
	}
}

