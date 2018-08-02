package concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadInterrupted4 {
    public static void main(String[] args) {
        System.out.println("Main thread is interrupted? " + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("I will be interrupted still.");
        }
    }
}
