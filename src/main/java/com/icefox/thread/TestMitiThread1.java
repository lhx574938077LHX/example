package com.icefox.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMitiThread1  implements Runnable{
	  /*
	   *  加synchronized之后，Thread0运行之后Thread1再运行	
	   *  加Lock锁之后， 也是先Thread0运行之后Thread1再运行	
	   */
	  private Lock lock = new ReentrantLock();
	 
	  public static void main(String[] args) {
	        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
	        TestMitiThread1 test = new TestMitiThread1();
	        Thread thread1 = new Thread(test);
	        Thread thread2 = new Thread(test);
	        thread1.start();
	        thread2.start();
	        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	    }
	 
//	    public synchronized void run() {
	    public void run() {
	    	lock.lock();
	        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
	        for (int i = 0; i < 10; i++) {
	            System.out.println(i + " " + Thread.currentThread().getName());
	            try {
	                Thread.sleep((int) Math.random() * 10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	       System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	       lock.unlock();
	    }
}
