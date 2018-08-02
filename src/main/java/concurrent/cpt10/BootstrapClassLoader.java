package concurrent.cpt10;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/09
 */
public class BootstrapClassLoader {
    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
