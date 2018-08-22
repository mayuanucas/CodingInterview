package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/22
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        if (null == pairs || 0 >= pairs.length) {
            return 0;
        }

        // 按照第一个元素从小到大排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        // 以该位置数对作为链表的尾端,串的最大长度
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < pairs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
