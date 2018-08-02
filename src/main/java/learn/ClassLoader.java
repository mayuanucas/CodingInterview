package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/01
 */
public class ClassLoader {
    public static void main(String[] args) {
        ClassLoader.bootstrapClassLoader();
        System.out.println("********************");
        ClassLoader.extClassLoader();
        System.out.println("********************");
        ClassLoader.applicationClassLoader();
        System.out.println("********************");
    }

    public static void bootstrapClassLoader() {
        System.out.println("BootstrapClassLoader:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    public static void extClassLoader() {
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    public static void applicationClassLoader() {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoader.class.getClassLoader());
    }
}
