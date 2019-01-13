package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 和相同的二元子数组
 * @date: 2019/01/13
 */
public class Solution930 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0};
        final int S = 2;

        System.out.println(new Solution930().numSubarraysWithSum(nums, S));
    }

    /**
     * 统计前缀和出现的次数
     *
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum(int[] A, int S) {
        if (null == A || 0 >= A.length) {
            return 0;
        }

        int preSum = 0, cnt = 0;
        int[] count = new int[A.length + 1];
        // preSum与S相等时,仅有1种情况
        count[0] = 1;
        for (int e : A) {
            preSum += e;
            if (preSum >= S) {
                cnt += count[preSum - S];
            }
            ++count[preSum];
        }
        return cnt;
    }

}
