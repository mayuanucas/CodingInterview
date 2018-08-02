package concurrent.cpt10;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/09
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
