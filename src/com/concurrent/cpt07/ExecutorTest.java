package com.concurrent.cpt07;

import java.util.concurrent.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/06
 */
public class ExecutorTest {

    public static void main(String[] args) {

        ExecutorService service1 = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            service1.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {

                }
            });

            System.out.println("线程池中线程数目:" + ((ThreadPoolExecutor) service1).getPoolSize() + ", 队列中等待执行的任务数目:" +
                    ((ThreadPoolExecutor) service1).getQueue().size() + ",已经执行完的任务数目:" +
                    ((ThreadPoolExecutor) service1).getCompletedTaskCount());
        }
        service1.shutdown();

    }
}
