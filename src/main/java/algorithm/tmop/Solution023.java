package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 交替字符串
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution023 {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        final boolean answer = true;

        System.out.println(answer == isInterLeave(s1, s2, s3));
    }

    public static boolean isInterLeave(String s1, String s2, String s3) {
        if (null == s1 || null == s2 || null == s3) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();
        int s = s3.length();
        if (n + m != s) {
            return false;
        }

        // dp[i][j]=true 表示:S3的前 i+j 个字符串可以由 S1的前i个字符串和 S2的前j个字符串组成
        boolean[][] dp = new boolean[n + 1][m + 1];
        // 初始化边界,可以认为空串可以由空串组成
        dp[0][0] = true;

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                // 1.S1的当前字符等与S3的当前字符,且dp[i-1][j]为true, 那么可以取S1的当前字符而忽略S2的情况,dp[i][j]返回true
                // 2.S2的当前字符等与S3的当前字符,且dp[i][j-1]为true, 那么可以取S2的当前字符而忽略S1的情况,dp[i][j]返回true
                // 3.其他情况,dp[i][j]返回false
                if (dp[i][j]
                        || (0 <= i - 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                        || (0 <= j - 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

}
