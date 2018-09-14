package concurrent;

import java.util.concurrent.*;

/**
 * @author: mayuan
 * @desc: 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
 * 通过维护计数器来实现的。线程执行 await() 方法之后计数器会减 1，并进行等待，
 * 直到计数器为 0，所有调用 awati() 方法而在等待的线程才能继续执行。
 * <p>
 * CyclicBarrier 和 CountdownLatch 的一个区别是，CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，所以它才叫做循环屏障。
 * @date: 2018/09/14
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int totalThread = 3;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; ++i) {
            executorService.execute(() -> {
                System.out.println("before...");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("after...");
            });
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("********************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < totalThread; ++i) {
            executorService.execute(() -> {
                System.out.println("before...");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("after...");
            });
        }
        executorService.shutdown();
    }
}
