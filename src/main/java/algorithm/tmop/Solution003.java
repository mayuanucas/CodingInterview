package algorithm.tmop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/11/19
 */
public class Solution003 {

    public static void main(String[] args) {
        final String a = "ABCD";
        final String b = "BCE";
        final String c = "AAC";

        System.out.println(stringContain(a, b));
        System.out.println(stringContain2(a, b));
        System.out.println(stringContain2(a, c));
    }

    /**
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(n)
     *
     * @param a
     * @param b
     * @return
     */
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

    /**
     * 采用位运算的方式,计算一个签名
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean stringContain2(String a, String b) {
        if (null == a || null == b) {
            return false;
        }
        if (0 != a.length() && 0 == b.length()) {
            return true;
        }

        int hash = 0;
        for (int i = 0; i < a.length(); ++i) {
            hash |= (1 << (a.charAt(i) - 'A'));
        }

        for (int i = 0; i < b.length(); ++i) {
            if (0 == (hash & (1 << (b.charAt(i) - 'A')))) {
                return false;
            }
        }

        return true;
    }

}
