package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 优美的排列
 * @date: 2019/02/16
 */
public class Solution526 {

    int count = 0;

    public int countArrangement(int N) {
        if (0 >= N) {
            return 0;
        }

        dfs(N, 1, new boolean[N + 1]);
        return count;
    }

    public void dfs(int N, int pos, boolean[] hasVisited) {
        if (pos > N) {
            ++count;
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (!hasVisited[i] && (0 == i % pos || 0 == pos % i)) {
                hasVisited[i] = true;
                dfs(N, pos + 1, hasVisited);
                hasVisited[i] = false;
            }
        }
    }

}
