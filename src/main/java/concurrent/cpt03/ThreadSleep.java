package concurrent.cpt03;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/29
 */
public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2_000L);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Current Thread Total spend %d ms", (endTime - startTime)));
        }).start();

        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main Thread total spend %d ms", (endTime - startTime)));

    }

    private static void sleep(long ms) {
        try {
            if (ms < 0) {
                ms = 0;
            }
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}
