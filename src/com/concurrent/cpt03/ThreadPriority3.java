package com.concurrent.cpt03;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadPriority3 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println("t1 priority " + t1.getPriority());

        Thread t2 = new Thread(() -> {
            Thread t3 = new Thread();
            System.out.println("t3 priority " + t3.getPriority());
        });

        t2.setPriority(6);
        t2.start();
        System.out.println("t2 priority " + t2.getPriority());
    }
}
