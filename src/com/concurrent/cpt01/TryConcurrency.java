package com.concurrent.cpt01;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/27
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(TryConcurrency::enjoyMusic).start();
        new Thread(TryConcurrency::browseNews).start();
    }

    private static void browseNews() {
        while (true) {
            System.out.println("游览网页中...");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        while (true) {
            System.out.println("听音乐中...");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        if (seconds < 0) {
            seconds = 0;
        }

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
