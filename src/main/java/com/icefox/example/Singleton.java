package com.icefox.example;

import java.util.Vector;

public class  Singleton { 
    private volatile static Singleton singleton; 
    private Singleton (){} 
    public static Singleton getSingleton() {
	    if (singleton == null) { 
	        synchronized (Singleton.class) { 
		        if (singleton == null) { 
		            singleton = new Singleton(); 
		        } 
	        } 
	    } 
	    return singleton; 
    } 
    
    public static void main(String[] args) {
    	Vector v=new Vector();
	}
 } 