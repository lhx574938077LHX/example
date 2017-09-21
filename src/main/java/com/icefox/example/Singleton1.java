package com.icefox.example;

public class Singleton1 {    
    private int a;
    private char c;
    Singleton1(int b){
    	a=b;
    }

    public static void main(String[] args) {
    	Singleton1 s = new Singleton1(5);
    	s.a=6;
    	System.out.println(s.a);
	}
 
 } 