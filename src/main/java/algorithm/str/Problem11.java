package algorithm.str;

/**
 * @author: mayuan
 * @desc: 正则表达式匹配
 * @date: 2018/09/08
 */
public class Problem11 {

    /**
     * 动态规划：
     * 这里我们采用dp[i+1][j+1]代表s[0..i]匹配p[0..j]的结果，结果自然是采用布尔值True/False来表示。
     * 首先，对边界进行赋值，显然dp[0][0] = true，两个空字符串的匹配结果自然为True;
     * 接着，我们对dp[0][j+1]进行赋值，因为 i=0 是空串，如果一个空串和一个匹配串想要匹配成功，
     * 那么只有可能是p.charAt(j) == '*' && dp[0][j-1]
     * 之后，就可以愉快地使用动态规划递推方程了。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
