package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 三数之和的多种可能
 * @date: 2019/01/13
 */
public class Solution923 {

    /**
     * 通过模拟的方式: i j k 代表数字
     *
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti2(int[] A, int target) {
        if (null == A || 3 > A.length) {
            return 0;
        }

        long ans = 0;
        int mod = 1000000007;
        int[] c = new int[301];
        for (int e : A) {
            ++c[e];
        }

        for (int i = 0; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                int k = target - i - j;
                if (i < j && j < k) {
                    ans += (long) c[i] * c[j] * c[k];
                } else if (i == j && j < k) {
                    ans += (long) c[i] * (c[j] - 1) / 2 * c[k];
                } else if (i < j && j == k) {
                    ans += (long) c[i] * c[j] * (c[k] - 1) / 2;
                } else if (i == j && j == k) {
                    ans += (long) c[i] * (c[j] - 1) * (c[k] - 2) / 6;
                }
            }
        }
        return (int) (ans % mod);
    }

    public int threeSumMulti(int[] A, int target) {
        if (null == A || 3 > A.length) {
            return 0;
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(A.length);
        for (int i = 0; i < A.length; ++i) {
            ans = (ans + map.getOrDefault(target - A[i], 0)) % (int) (1e9 + 7);
            for (int j = 0; j < i; ++j) {
                int tmp = A[j] + A[i];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        return ans;
    }

}
