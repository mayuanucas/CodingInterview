package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 比较含退格的字符串
 * @date: 2019/01/12
 */
public class Solution844 {

    /**
     * The idea is that, read next letter from end to start.
     * If we meet #, we increase the number we need to step back, until back = 0
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        if ((null == S && null != T) || (null != S && null == T)) {
            return false;
        }

        for (int i = S.length() - 1, j = T.length() - 1; ; --i, --j) {
            for (int b = 0; i >= 0 && (b > 0 || '#' == S.charAt(i)); --i) {
                b += '#' == S.charAt(i) ? 1 : -1;
            }
            for (int b = 0; j >= 0 && (b > 0 || '#' == T.charAt(j)); --j) {
                b += '#' == T.charAt(j) ? 1 : -1;
            }

            if (0 > i || 0 > j || S.charAt(i) != T.charAt(j)) {
                return -1 == i && -1 == j;
            }
        }
    }
}
