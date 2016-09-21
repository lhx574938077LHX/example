package com.icefox.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {
		
	
	public static void main(String[] args) {
	
		//建立线程池
//		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//获取当前系统的CPU 数目
		int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("当前CPU数目："+cpuNums);
		
		ExecutorService pool = Executors.newFixedThreadPool(3);  
		
		for (int i = 0; i < 10; i++) {
			pool.execute(new Thread(new TestMitiTread2()));
		}
		
		pool.shutdown(); 
		
        while (true) {  

            if (pool.isTerminated()) {  
                break;  
            }  
        } 
	}
	
}
