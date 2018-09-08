package algorithm.str;

/**
 * @author: mayuan
 * @desc: 左旋转字符串
 * @date: 2018/09/08
 */
public class Problem0901 {

    public static void main(String[] args) {
        String ans = leftRotateString("abcXYZdef", 3);

        System.out.println(ans);
    }


    public static String leftRotateString(String str, int n) {
        if (null == str || str.length() < 1) {
            return "";
        }

        n %= str.length();
        String s1 = str.substring(n);
        String s2 = str.substring(0, n);
        return s1 + s2;
    }
}
