package design.singleton;

/**
 * @author: mayuan
 * @desc: 双重校验锁 - 线程安全
 * @date: 2018/07/13
 */
public class Singleton04 {
    private volatile static Singleton04 uniqueInstance;

    private Singleton04() {
    }

    public static Singleton04 getUniqueInstance() {
        if (null == uniqueInstance) {
            synchronized (Singleton04.class) {
                if (null == uniqueInstance) {
                    uniqueInstance = new Singleton04();
                }
            }
        }
        return uniqueInstance;
    }
}
