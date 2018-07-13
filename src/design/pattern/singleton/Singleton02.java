package design.pattern.singleton;

/**
 * @author: mayuan
 * @desc: 懒汉式 - 线程安全
 * @date: 2018/07/13
 */
public class Singleton02 {
    private static Singleton02 uniqueInstance;

    private Singleton02() {
    }

    public static synchronized Singleton02 getUniqueInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new Singleton02();
        }
        return uniqueInstance;
    }
}
