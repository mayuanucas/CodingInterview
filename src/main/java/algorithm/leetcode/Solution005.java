package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最长回文子串
 * @date: 2018/06/25
 */
public class Solution005 {

    public static void main(String[] args) {
        Solution005 sol = new Solution005();

        System.out.println(sol.longestPalindrome("abba"));
    }

    /**
     * 动态规划解题
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans = "";
        if (null == s || 0 >= s.length()) {
            return ans;
        }

        int n = s.length();
        // dp[i][j]代表[i,j]范围长度的字符串是否为回文字符串
        boolean[][] dp = new boolean[n][n];
        for (int end = 0; end < n; ++end) {
            for (int start = 0; start <= end; ++start) {
                dp[start][end] = s.charAt(start) == s.charAt(end) && (start + 1 >= end || dp[start + 1][end - 1]);
                if (dp[start][end] && end - start + 1 > ans.length()) {
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expansion(s, i, i);
            int l2 = expansion(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                // 当回文子串长度为偶数时，需先减一
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expansion(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
