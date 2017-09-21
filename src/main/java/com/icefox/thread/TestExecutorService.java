package com.icefox.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.aspose.email.internal.ds.ex;

public class TestExecutorService {

    public static void main(String[] args) {
        // 获取当前系统的CPU 数目
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("当前CPU数目：" + cpuNums);
        
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            pool.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行！");
                }
            }));
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                break;
            }
        }
    }

}
