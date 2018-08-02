package learn;

import java.util.concurrent.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/20
 */
public class MyThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 123;
    }
}
