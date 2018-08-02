package concurrent.cpt03;

import java.util.concurrent.TimeUnit;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadInterrupted3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    boolean fl = Thread.interrupted();
                    if (fl){
                        System.out.print("**************");
                    }
                    System.out.println(fl);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
