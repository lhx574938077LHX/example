package com.icefox.xml;

import java.util.ArrayList;
import java.util.List;

import com.icefox.bean.Student;
import com.icefox.bean.Students;

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
			
			Students students = new Students();
			students.setStudents(stus);
			/*
			XStream xStream = new XStream();  
			//XStream xStream = new XStream(new JettisonMappedXmlDriver());  
	        xStream.setMode( XStream.NO_REFERENCES ); 
	        
	        xStream.alias("学生", Student.class);  
	        xStream.aliasField("姓名", Student.class, "name");
	        xStream.aliasField("年龄", Student.class, "age");
	        xStream.aliasField("性别", Student.class, "sex");
	        
	        String xml = xStream.toXML(stus);
	        
			System.out.println(xml);
			*/
			/*
			JAXBContext context;  
			try {  
				context = JAXBContext.newInstance(students.getClass());  
				Marshaller mar = context.createMarshaller();  
				mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
				mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  
				  
				StringWriter writer = new StringWriter();  
				  
				mar.marshal(students, writer);  
				Unmarshaller unmar = context.createUnmarshaller();
				String xml = writer.toString();
				StringReader sr = new StringReader(xml);
				Students destus = (Students)unmar.unmarshal(sr);
				sr.close();
				
				for(Student u : destus.getStudents())
				{
					System.out.println(u.getName());  
				}
			} catch (JAXBException e) {  
			    e.printStackTrace();  
			}  
			*/
			String xmlString = XmlSerializer.serializer(students, students.getClass());
			System.out.println(xmlString);
			
			Students stds = (Students)XmlSerializer.deserializer(xmlString, students.getClass());
			for(Student u : stds.getStudents())
			{
				System.out.println(u.getName());  
			}
		}
}

