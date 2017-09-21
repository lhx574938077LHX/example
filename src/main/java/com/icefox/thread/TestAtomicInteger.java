package com.icefox.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

	public static AtomicInteger ai = new AtomicInteger(0);

	public void increase() {
		ai.getAndIncrement();
	}

	public static void main(String[] args) throws InterruptedException {
		final TestAtomicInteger test = new TestAtomicInteger();
		System.out.println("开始");
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++) {
						test.increase();
					}
				}
			}.start();
		}
		while(Thread.activeCount()>1){
			System.out.println(Thread.activeCount());
//			Thread.yield();
		}
		System.out.println(ai.get());
	}

}
