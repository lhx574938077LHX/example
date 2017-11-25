package com.icefox.mianshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bussiness {
    private ReentrantLock lock = new ReentrantLock();
    private Condition redCon = lock.newCondition();
    private Condition greenCon = lock.newCondition();
    volatile boolean bShouldSub = true;// 这里相当于定义了控制该谁执行的一个信号灯

    static int lockInt = 1;

    public static void main(String args[]) {
        final Bussiness business = new Bussiness();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                business.SubThread();
            }
        });
        Thread b = new Thread((new Runnable() {
            @Override
            public void run() {
                business.MainThread();
            }
        }));
        a.start();
        b.start();
    }

    public void MainThread() {
        for (int i = 0; i < 50; i++) {
            try {
                lock.lockInterruptibly();
                if (!bShouldSub) {
                    redCon.await();
                }
                bShouldSub = false;
                System.out.println(Thread.currentThread().getName() + "+MainThread:i=" + i);
                greenCon.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public void SubThread() {
        for (int i = 0; i < 50; i++) {
            try {
                lock.lockInterruptibly();
                if (bShouldSub) {
                    greenCon.await();
                }
                bShouldSub = true;
                System.out.println(Thread.currentThread().getName() + "+SubThread:j=" + i);
                redCon.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}
