package com.concurrent.cpt07;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/05
 */
public class ThreadHook {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 1 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("The hook thread 1 will exit.");
            }
        });


        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 2 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("The hook thread 2 will exit.");
            }
        });

        System.out.println("The program will stopping.");
    }
}
