package concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
