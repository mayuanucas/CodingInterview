package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 数组中的最长山脉
 * @date: 2019/01/12
 */
public class Solution845 {

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new Solution845().longestMountain1(A));
    }

    /**
     * In this problem, we take one forward pass to count up hill length (to every point).
     * We take another backward pass to count down hill length (from every point).
     * Finally a pass to find max(up[i] + down[i] + 1) where up[i] and down[i] should be positives.
     *
     * @param A
     * @return
     */
    public int longestMountain1(int[] A) {
        if (null == A || 3 > A.length) {
            return 0;
        }

        int ans = 0;
        int[] up = new int[A.length];
        int[] down = new int[A.length];
        for (int i = A.length - 2; i >= 0; --i) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
        }

        for (int i = 0; i < A.length; ++i) {
            if (0 < i && A[i - 1] < A[i]) {
                up[i] = up[i - 1] + 1;
            }
            if (0 < up[i] && 0 < down[i]) {
                int len = up[i] + down[i] + 1;
                ans = ans > len ? ans : len;
            }
        }
        return ans;
    }

    public int longestMountain(int[] A) {
        if (null == A || 3 > A.length) {
            return 0;
        }

        int ans = 0;
        for (int peak = 1; peak < A.length - 1; ++peak) {
            int i = peak;
            while (0 < i) {
                if (A[i - 1] < A[i]) {
                    --i;
                } else {
                    break;
                }
            }
            if (peak - i < 1) {
                continue;
            }

            int j = peak;
            while (A.length - 1 > j) {
                if (A[j] > A[j + 1]) {
                    ++j;
                } else {
                    break;
                }
            }
            if (j - peak < 1) {
                continue;
            }

            int len = j - i + 1;
            ans = ans > len ? ans : len;
        }
        return ans;
    }

}
