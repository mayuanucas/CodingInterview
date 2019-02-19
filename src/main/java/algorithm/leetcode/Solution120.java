package algorithm.leetcode;

import java.util.List;

/**
 * @author: mayuan
 * @desc: 三角形最小路径和
 * @date: 2019/02/19
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle) {
            return 0;
        }

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (null == triangle) {
            return 0;
        }

        int[] dp = new int[triangle.size()];
        for (List<Integer> line : triangle) {
            int size = line.size();

            if (1 == size) {
                dp[0] = line.get(0);
                continue;
            }

            // 每行最后一个元素只能从上一行最后一个元素转移过来
            dp[size - 1] = dp[size - 2] + line.get(size - 1);

            for (int j = size - 2; j > 0; --j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + line.get(j);
            }

            // 每行第一个元素只能从上一行第一个元素转移过来
            dp[0] += line.get(0);
        }

        int ans = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (ans > dp[i]) {
                ans = dp[i];
            }
        }
        return ans;
    }

}
