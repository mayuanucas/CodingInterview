package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: mayuan
 * @desc: Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
 * @date: 2018/09/14
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        // 可同时被访问的资源总数
        final int resourceCount = 3;
        // 总共请求总数
        final int totalRequests = 10;

        Semaphore semaphore = new Semaphore(resourceCount);

        // 模拟了对某个服务的并发请求，每次只能有 3 个请求同时访问，请求总数为 10。
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequests; ++i) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("hello Semaphore.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
