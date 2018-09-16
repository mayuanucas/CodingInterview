package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc: 死锁的简单例子
 * @date: 2018/09/16
 */
public class DeathLockExample {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("now in threadA lock a");
                        TimeUnit.SECONDS.sleep(2);

                        synchronized (b) {
                            System.out.println("now in threadA lock b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("now in threadB lock b");
                        TimeUnit.SECONDS.sleep(2);

                        synchronized (a) {
                            System.out.println("now in threadB lock a");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
