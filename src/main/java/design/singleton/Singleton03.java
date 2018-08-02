package design.singleton;

/**
 * @author: mayuan
 * @desc: 饿汉式 - 线程安全
 * @date: 2018/07/13
 */
public class Singleton03 {
    private static Singleton03 uniqueInstance = new Singleton03();

    private Singleton03() {
    }

    public static Singleton03 getUniqueInstance() {
        return uniqueInstance;
    }
}
