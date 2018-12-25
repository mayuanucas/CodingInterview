package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/12/25
 */
public class Solution859 {

    public boolean buddyStrings(String A, String B) {
        if (null == A || null == B || A.length() != B.length() || 0 == A.length()) {
            return false;
        }

        int indexA = -1, indexB = -1, diff = 0;
        int[] map = new int[26];
        boolean duplicate = false;

        for (int i = 0; i < A.length(); ++i) {
            if (++map[A.charAt(i) - 'a'] >= 2) {
                duplicate = true;
            }
            if (A.charAt(i) != B.charAt(i)) {
                ++diff;
                if (-1 == indexA) {
                    indexA = i;
                } else if (-1 == indexB) {
                    indexB = i;
                }
            }
        }
        return (0 == diff && duplicate) ||
                (2 == diff && A.charAt(indexA) == B.charAt(indexB) && A.charAt(indexB) == B.charAt(indexA));
    }
}
