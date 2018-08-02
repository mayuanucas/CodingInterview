package concurrent.cpt03;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class CurrentThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("当前线程名:" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread() == this);
            }
        };
        thread.start();

        String name = Thread.currentThread().getName();
        System.out.println("当前线程名:" + name);
        System.out.println("main".equals(name));
    }
}
