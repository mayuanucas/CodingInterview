package algorithm.tmop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mayuan
 * @desc: 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date: 2018/11/19
 */
public class Solution003 {

    public static void main(String[] args) {
        final String a = "ABCD";
        final String b = "BCE";

        System.out.println(stringContain(a, b));
    }

    public static boolean stringContain(String a, String b) {
        if (null == a || null == b) {
            return false;
        }
        if (0 != a.length() && 0 == b.length()) {
            return true;
        }

        Set<Character> set = new HashSet<>(a.length());
        for (int i = 0; i < a.length(); ++i) {
            set.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); ++i) {
            if (!set.contains(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
