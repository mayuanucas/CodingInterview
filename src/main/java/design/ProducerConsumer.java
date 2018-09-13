package design;

/**
 * @author: mayuan
 * @desc: 最简单的生产者消费者模式
 * @date: 2018/09/12
 */
public class ProducerConsumer {
    private static int count = 0;
    private static final int FULL = 10;
    private static Object LOCK = new Object();

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();

        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();

        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();

        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (FULL == count) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    ++count;
                    System.out.println(Thread.currentThread().getName() + "生产者生产,目前有:" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (0 == count) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    --count;
                    System.out.println(Thread.currentThread().getName() + "消费者消费,目前有:" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
