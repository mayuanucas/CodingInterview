package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/20
 */
public class MyObject {

    public MyObject() {
    }

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(Object.class);
        System.out.println("abc".getClass());

        System.out.println(object.toString());
    }
}
