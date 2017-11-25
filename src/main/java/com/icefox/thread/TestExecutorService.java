package com.icefox.thread;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.jsoup.nodes.Node;

import com.aspose.email.internal.ds.ex;
import com.aspose.email.system.collections.Hashtable;

public class TestExecutorService {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {
        // 获取当前系统的CPU 数目
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("当前CPU数目：" + cpuNums);
        AtomicInteger ai = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        Vector list = new Vector<Integer>();
        
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            } 
        });
        
        list.add(1);
        HashMap<String,String> table = new HashMap<String,String>();
        LinkedList list1;
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10000);
        ExecutorService pools = Executors.newCachedThreadPool();
        
        TreeMap<String,String> tree = new TreeMap<String,String>();
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>();
        
        HashSet<String> set = new HashSet<String>();
        
        final ReentrantLock lock = new ReentrantLock();
        lock.lockInterruptibly();
        lock.lock();
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
