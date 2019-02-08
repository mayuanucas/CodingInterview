package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: mayuan
 * @desc: 优势洗牌
 * @date: 2019/02/08
 */
public class Solution870 {

    public int[] advantageCount(int[] A, int[] B) {
        if (0 == A.length && 0 == B.length) {
            return A;
        }

        Arrays.sort(A);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; ++i) {
            queue.add(new int[]{i, B[i]});
        }

        int[] ans = new int[A.length];
        int low = 0, high = A.length - 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0], val = cur[1];
            if (A[high] > val) {
                ans[idx] = A[high--];
            } else {
                ans[idx] = A[low++];
            }
        }
        return ans;
    }

}
