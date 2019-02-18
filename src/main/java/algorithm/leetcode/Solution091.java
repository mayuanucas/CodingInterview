package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 解码方法
 * @date: 2018/08/22
 */
public class Solution091 {
    public static void main(String[] args) {
        Solution091 test = new Solution091();

        System.out.println(test.numDecodings("226"));
    }

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        // 字符串长度为 n 时,解码方式的种类数目.
        int[] dp = new int[s.length() + 1];
        // 字符串长度为 0时,解码方式只有1种.
        dp[0] = 1;
        // 字符串长度为 1时,如果该字符为'0'则没有解码方式,为其它字符时解码方式只有1种.
        dp[1] = ('0' == s.charAt(0)) ? 0 : 1;
        for (int i = 2; i <= s.length(); ++i) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            // 字符长度为 i 时,且该字符不为'0'并且该字符和其前面一位的字符也可以组成合法数字,则解码方式为 dp[i] = dp[i-1]+dp[i-2]
            if (1 <= oneDigit && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (10 <= twoDigit && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
