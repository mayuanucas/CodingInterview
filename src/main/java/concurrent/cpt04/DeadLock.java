package concurrent.cpt04;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/03
 */
public class DeadLock {

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread() + " get WRITE lock");
            }
            System.out.println(Thread.currentThread() + " release WRITE lock");
        }
        System.out.println(Thread.currentThread() + " release READ lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread() + " get READ lock");
            }
            System.out.println(Thread.currentThread() + " release READ lock");
        }
        System.out.println(Thread.currentThread() + " release WRITE lock");
    }

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "READ-THREAD").start();

        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }, "WRITE-THREAD").start();
    }
}
