package com.concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/01
 */
public class FlagThreadExit {

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("System will be shutdown.");
        t.close();
    }

    static class MyTask extends Thread {
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work.");
            while (!closed && !isInterrupted()) {

            }
            System.out.println("I will  be exiting.");
        }

        public void close() {
            this.closed = true;
            this.interrupt();
        }
    }
}
