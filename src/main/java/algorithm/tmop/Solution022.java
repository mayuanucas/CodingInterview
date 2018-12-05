package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 字符串编辑距离
 * 时间复杂度: O(n*m)
 * 空间复杂度: O(n*m)
 * @date:
 */
public class Solution022 {

    public static void main(String[] args) {
        final String str1 = "horse";
        final String str2 = "ros";
        final int answer = 3;

        System.out.println(answer == minDistance(str1, str2));
    }

    public static int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j]表示: word1[1:i] 和 word2[1:j]的编辑距离, i 与 j 代表字符串的长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; ++i) {
            // 删除字符
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; ++j) {
            // 添加字符
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                // 当前位置字符相同,编辑距离等于上一位置的编辑距离
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前位置字符不相同,有三种编辑方式
                    // 1. 从 i-1,j-1 位置变换过来,替换word1该位置字符
                    // 2. 从 i-1,j 位置变换过来,为word1添加一个字符
                    // 3. 从 i,j-1 位置变换过来,删除word1一个字符
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
