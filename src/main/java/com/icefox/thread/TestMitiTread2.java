package com.icefox.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMitiTread2 implements Runnable {
	
	private static int num = 0;
	
	private Lock lock = new ReentrantLock();
	
	@Override
	public void run(){
		 if(lock.tryLock()){
			 try {
				 System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
				 
				 System.out.println(num++);
				 
				 Thread.sleep(3*1000);
				
			     System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			} finally{
				 lock.unlock();
			}
		}
	}

}
