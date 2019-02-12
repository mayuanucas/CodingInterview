package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 最小差值 II
 * https://leetcode.com/problems/smallest-range-ii/discuss/173505/Java-Solution-with-the-Picture-to-explain-it
 * @date: 2019/02/12
 */
public class Solution910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);

        int n = A.length;
        int ans = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; ++i) {
            int mx = Math.max(A[i] + K, A[n - 1] - K);
            int mn = Math.min(A[i + 1] - K, A[0] + K);
            ans = Math.min(ans, mx - mn);
        }
        return ans;
    }
}
