package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/15
 */
public class Solution547 {
    public static void main(String[] args) {
        Solution547 test = new Solution547();

        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(test.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        if (null == M || 0 >= M.length) {
            return 0;
        }

        int circleNumber = 0;
        boolean[] hasVisited = new boolean[M.length];
        for (int i = 0; i < M.length; ++i) {
            if (!hasVisited[i]) {
                dfs(M, hasVisited, i);
                ++circleNumber;
            }
        }
        return circleNumber;
    }

    private void dfs(int[][] M, boolean[] hasVisited, int i) {
        hasVisited[i] = true;
        for (int j = 0; j < M.length; ++j) {
            if (1 == M[i][j] && !hasVisited[j]) {
                dfs(M, hasVisited, j);
            }
        }
    }
}
