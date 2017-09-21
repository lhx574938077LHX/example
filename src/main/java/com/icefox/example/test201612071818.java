package com.icefox.example;

public class test201612071818 {
	
	//lambda
//	public static void main(String[] args) {
//		
//		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
//			       "Stanislas Wawrinka",  
//			       "David Ferrer","Roger Federer",  
//			       "Andy Murray","Tomas Berdych",  
//			       "Juan Martin Del Potro"};  
// 
//		// 1.1 使用匿名内部类根据 name 排序 players  
//		Arrays.sort(atp, new Comparator<String>() {  
//		    @Override  
//		    public int compare(String s1,String s2) {  
//		        return (s1.compareTo(s2));  
//		    }  
//		}); 
//		
//		
//		// 1.2 使用 lambda expression 排序 players  
//		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));  
//		Arrays.sort(atp, sortByName);
//		
//		 
//		// 1.3 也可以采用如下形式:  
//		Arrays.sort(atp, (String s1, String s2) -> (s1.compareTo(s2)));  
//		
//		Arrays.sort(atp,(s1,s2)->(s1.compareTo(s2)));
//		
//		
//		List<String> players =  Arrays.asList(atp);  
//		
//		// 以前的循环方式  
//		for (String player : players) {  
//		     System.out.print(player + "; ");  
//		} 
//
//		players.forEach((player) -> System.out.print(player + "; ")); 
//
//	}
	
}
