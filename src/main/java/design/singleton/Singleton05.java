package design.singleton;

/**
 * @author: mayuan
 * @desc: 静态内部类实现
 * @date: 2018/07/13
 */
public class Singleton05 {

    private Singleton05() {
    }

    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

}
