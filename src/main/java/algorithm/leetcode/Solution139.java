package algorithm.leetcode;

import java.util.List;

/**
 * @author: mayuan
 * @desc: 单词拆分
 * @date: 2018/08/23
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示以第i个字符结尾的字符串是否可以拆分为一个或多个在字典中出现的单词
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
