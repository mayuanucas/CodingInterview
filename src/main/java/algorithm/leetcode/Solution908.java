package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 最小差值 I
 * @date: 2019/02/10
 */
public class Solution908 {
    public int smallestRangeI(int[] A, int K) {
        if (null == A || 1 >= A.length) {
            return 0;
        }

        int mx = A[0], mn = A[0];
        for (int i = 1; i < A.length; ++i) {
            mx = Math.max(mx, A[i]);
            mn = Math.min(mn, A[i]);
        }
        return Math.max(mx - mn - 2 * K, 0);
    }
}
