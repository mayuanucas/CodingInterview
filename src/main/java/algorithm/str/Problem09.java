package algorithm.str;

/**
 * @author: mayuan
 * @desc: 旋转字符串
 * @date: 2018/09/08
 */
public class Problem09 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
