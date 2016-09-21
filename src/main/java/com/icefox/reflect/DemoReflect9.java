package com.icefox.reflect;

public class DemoReflect9 {
	
	public static void main(String[] args) {
		MyInvocationHandler demo = new MyInvocationHandler();
		Subject sub = (Subject) demo.bind(new RealSubject());
		String info = sub.say("Rollen", 20);
		System.out.println(info);
	}
	
}
