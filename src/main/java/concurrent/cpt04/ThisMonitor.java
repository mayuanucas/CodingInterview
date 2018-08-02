package concurrent.cpt04;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/02
 */
public class ThisMonitor {

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1, "T1").start();
        new Thread(thisMonitor::method2, "T2").start();
    }

    public synchronized void method1() {
        System.out.println(currentThread().getName() + " enter to method1.");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(currentThread().getName() + " enter to method2.");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
