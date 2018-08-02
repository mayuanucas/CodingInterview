package design.singleton;

/**
 * @author: mayuan
 * @desc: 懒汉式 - 线程不安全
 * @date: 2018/07/13
 */
public class Singleton01 {

    private static Singleton01 uniqueInstance;

    private Singleton01() {
    }

    public static Singleton01 getUniqueInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new Singleton01();
        }
        return uniqueInstance;
    }
}
