package concurrent.cpt05;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/03
 */
public class EventClient {

    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            while (true) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(() -> {
            while (true) {
                eventQueue.take();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}
