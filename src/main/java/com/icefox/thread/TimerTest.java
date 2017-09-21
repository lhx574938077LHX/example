package com.icefox.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) throws InterruptedException {
        TimerTest timerTest = new TimerTest();
        timerTest.TimerTest();
    }

    public void TimerTest() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1L);
        Thread.sleep(100);
        timer.schedule(new ThrowTask(), 1L);
        Thread.sleep(100);
    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("1");
        }

    }

}
