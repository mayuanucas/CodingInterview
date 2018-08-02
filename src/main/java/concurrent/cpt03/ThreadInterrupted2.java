package concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadInterrupted2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted ? %s\n", isInterrupted());
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread be interrupted ? %s\n", thread.isInterrupted());
        Thread.interrupted();
        System.out.printf("Thread be interrupted ? %s\n", thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread be interrupted ? %s\n", thread.isInterrupted());

    }
}
