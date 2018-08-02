package concurrent.cpt09;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/08
 */
public class StaticInitTest {

    static int count = 2;

    static {
        System.out.println("StaticInitTest");
        name = "Java 编程";
    }

    static String name = "疯狂Java讲义";

    public static void main(String[] args) {
        System.out.println("count: " + count);
        System.out.println("name: " + name);
    }
}
