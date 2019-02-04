package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 翻转矩阵后的得分
 * @date: 2019/02/01
 */
public class Solution861 {

    public int matrixScore(int[][] A) {
        if (null == A || 0 >= A.length) {
            return 0;
        }

        int M = A.length, N = A[0].length;
        int ans = (1 << (N - 1)) * M;

        for (int j = 1; j < N; ++j) {
            int cur = 0;
            for (int i = 0; i < M; ++i) {
                cur += A[i][j] == A[i][0] ? 1 : 0;
            }
            ans += Math.max(cur, M - cur) * (1 << (N - 1 - j));
        }
        return ans;
    }
}
