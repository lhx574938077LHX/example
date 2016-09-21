package com.icefox.reflect;

public class Person1 implements China{

	public Person1() {
		         
	}
	public Person1(String sex){
	    this.sex=sex;
	}
	public String getSex() {
	    return sex;
	}
	public void setSex(String sex) {
	    this.sex = sex;
	}
	@Override
	public void sayChina(){
	    System.out.println("hello ,china"+this.sex);
	}
	@Override
	public void sayHello(String name, int age){
	    System.out.println("姓名："+name+"----年龄："+age);
	}
	private String sex;

}
