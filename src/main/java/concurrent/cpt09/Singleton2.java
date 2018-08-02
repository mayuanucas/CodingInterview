package concurrent.cpt09;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/07
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private static int x = 0;

    private static int y;

    private Singleton2() {
        x++;
        y++;
    }

    public static Singleton2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton2 singleton = Singleton2.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
