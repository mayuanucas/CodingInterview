package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 安排工作以达到最大收益
 * @date: 2019/01/11
 */
public class Solution826 {

    public static void main(String[] args) {
        int[] difficulty = {10, 2, 4, 6, 8};
        int[] profit = {50, 10, 20, 30, 40};
        int[] worker = {4, 5, 6, 7};

        int ans = new Solution826().maxProfitAssignment(difficulty, profit, worker);
        System.out.println(ans);
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (null == difficulty || null == profit || null == worker) {
            return 0;
        }

        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; ++i) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int ans = 0;
        int i = 0, maxProfit = 0;
        for (int w : worker) {
            // 取最大的收益(难度大,收益不一定高.所以取之前收益较高的)
            while (i < jobs.length && w >= jobs[i][0]) {
                maxProfit = maxProfit > jobs[i][1] ? maxProfit : jobs[i][1];
                ++i;
            }
            ans += maxProfit;
        }

        return ans;
    }

}
