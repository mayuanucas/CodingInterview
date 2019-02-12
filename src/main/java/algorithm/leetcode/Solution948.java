package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 令牌放置
 * @date: 2019/02/12
 */
public class Solution948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        int ans = 0, i = 0, j = tokens.length - 1, points = 0;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i];
                ++points;
                ++i;

                ans = Math.max(ans, points);
            } else if (0 < points) {
                --points;
                P += tokens[j];
                --j;
            } else {
                break;
            }
        }
        return ans;
    }
}
