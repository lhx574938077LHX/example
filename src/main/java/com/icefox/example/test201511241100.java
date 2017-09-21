package com.icefox.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.collections.map.ListOrderedMap;

import com.aspose.email.internal.a.s;



class test201511241100 {
	
	public static void main(String[] args) {
//		 HashSet<String> a = new HashSet<String>();
//		 Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
//		 System.out.println(new Random().nextInt());
//		 System.out.println(Integer.toHexString(new Random().nextInt()));
//		 Object o =new Object();
//		 HashSet<String> b = (HashSet<String>) a.clone();
//		 System.out.println();
//		 ConcurrentHashMap map = new ConcurrentHashMap();
//		 CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		 HashMap<String,Double> hashMap  = new HashMap<String,Double>();
		 hashMap.put("A",99.5);  
		 hashMap.put("B",67.4);  
		 hashMap.put("C",67.4);  
		 hashMap.put("D",69.3);
		 ListOrderedMap tryMap = new ListOrderedMap();
		 tryMap.putAll(hashMap);
		 System.out.println("results: "+hashMap);
		 System.out.println("results: "+tryMap); 
		 Set<String> set = hashMap.keySet();
		 Set<Entry<String, Double>> sets = hashMap.entrySet();
		 
		 
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 map.put("d", 2);
		 map.put("c", 1);
		 map.put("b", 1);
		 map.put("a", 3);
		 List<Map.Entry<String, Integer>> infoIds =
				    new ArrayList<Map.Entry<String, Integer>>(map.entrySet());	
	}

		
	
}
