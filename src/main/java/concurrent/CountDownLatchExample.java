package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: mayuan
 * @desc: 用来控制一个线程等待多个线程。(某个线程等待多个线程到达)
 * 维护了一个计数器 cnt，每次调用 countDown() 方法会让计数器的值减 1，减到 0 的时候，那个因为调用 await() 方法而在等待的线程就会被唤醒。
 * @date: 2018/09/14
 */
public class CountDownLatchExample {

    public static void main(String[] args) {
        final int totalThread = 10;

        CountDownLatch countDownLatch = new CountDownLatch(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; ++i) {
            executorService.execute(() -> {
                System.out.println("hello CountDownLatch.");
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all come.");
        executorService.shutdown();
    }
}
