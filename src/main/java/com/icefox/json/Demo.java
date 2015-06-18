package com.icefox.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.icefox.bean.Student;

public class Demo {

	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.setName("张三");
		stu1.setAge((short)23);
		stu1.setSex((short)1);
		
		Student stu2 = new Student();
		stu2.setName("李四");
		stu2.setAge((short)22);
		stu2.setSex((short)1);
		
		List<Student> stus = new ArrayList<Student>();
		stus.add(stu1);
		stus.add(stu2);
		
		String jsonStr = JsonSerializer.serializer(stus);
		System.out.println(jsonStr);
		
		@SuppressWarnings("unchecked")
		List<Student> stuList =(List<Student>)JsonSerializer.deserializer(jsonStr,new TypeReference<List<Student>>(){});
		for(Student u : stuList){
			System.out.println(u.getName());
		}
	}

}

