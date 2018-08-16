package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/16
 */
public class MyClone {
    public static void main(String[] args) {
        String[] array = {"aa", "bb", "cc"};
        String[] array2 = array.clone();

        System.out.println("array->" + array);
        System.out.println("array2->" + array2);
        System.out.println(array == array2);
    }
}
