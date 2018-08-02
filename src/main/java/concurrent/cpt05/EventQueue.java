package concurrent.cpt05;

import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/03
 */
public class EventQueue {

    static class Event {
    }

    private int max;

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    print(" the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            print(" the new event is submitted.");
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    print(" the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            print(" the event " + event + " is handled.");
            return event;
        }
    }

    public void print(String message) {
        System.out.printf("%s:%s\n", Thread.currentThread().getName(), message);
    }

}
