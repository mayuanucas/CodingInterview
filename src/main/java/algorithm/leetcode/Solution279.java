package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: mayuan
 * @desc: 完全平方数
 * @date: 2018/08/21
 */
public class Solution279 {

    /**
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     * ...
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     *
     * @param n
     * @return
     */

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; ++i) {
            int mn = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; ++j) {
                mn = Math.min(mn, dp[i - j * j] + 1);
            }
            dp[i] = mn;
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];

        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (0 > next) {
                        break;
                    }
                    if (0 == next) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(cur - s);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        while (square <= n) {
            squares.add(square * square);
            ++square;
        }
        return squares;
    }
}
