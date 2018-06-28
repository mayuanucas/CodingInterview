package com.concurrent.cpt02;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/28
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 守护线程具备自动结束生命周期的特性
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
