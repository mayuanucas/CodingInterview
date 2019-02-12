package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 删列造序 II
 * @date: 2019/02/12
 */
public class Solution955 {
    public int minDeletionSize(String[] A) {
        int ans = 0, n = A.length, m = A[0].length(), i, j;
        boolean[] sorted = new boolean[n - 1];

        for (j = 0; j < m; ++j) {
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    ++ans;
                    break;
                }
            }

            if (i < n - 1) {
                continue;
            }
            for (i = 0; i < n - 1; ++i) {
                if (A[i].charAt(j) < A[i + 1].charAt(j)) {
                    sorted[i] = true;
                }
            }
        }
        return ans;
    }
}
