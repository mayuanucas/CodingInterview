package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/24
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int lengthOfWord1 = word1.length();
        int lengthOfWord2 = word2.length();
        // dp[i][j]表示 word1的第 i 个字符前和 word2的第 j个字符前,最长公共子序列的长度
        int[][] dp = new int[lengthOfWord1 + 1][lengthOfWord2 + 1];

        for (int i = 1; i <= lengthOfWord1; ++i) {
            for (int j = 1; j <= lengthOfWord2; ++j) {
                // word1 的第 i 个字符和 word2 的第 j个字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // word1 的第 i 个字符和 word2 的第 j个字符不相等
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return lengthOfWord1 + lengthOfWord2 - 2 * dp[lengthOfWord1][lengthOfWord2];
    }
}
