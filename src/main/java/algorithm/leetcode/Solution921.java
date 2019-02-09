package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2019/02/09
 */
public class Solution921 {

    public static void main(String[] args) {
        String str1 = "()))((";

        Solution921 solution921 = new Solution921();
        System.out.println(solution921.minAddToMakeValid(str1));
    }

    public int minAddToMakeValid(String S) {
        if (null == S || 1 > S.length()) {
            return 0;
        }

        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if ('(' == c) {
                ++left;
            } else {
                if (0 < left) {
                    --left;
                } else {
                    ++right;
                }
            }
        }

        return left + right;
    }
}
