package com.icefox.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Root")  
public class Students {
	private List<Student> students;

	@XmlElement(name="Student")  
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Students()
	{
		
	}
}

