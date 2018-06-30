package com.concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 线程优先级最小为 1, 最大为 10, 默认为 5. 且不能大于线程所在 group 的优先级.
        t1.setPriority(3);

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setPriority(10);

        t1.start();
        t2.start();
    }

}
