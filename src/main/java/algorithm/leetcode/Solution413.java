package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/22
 */
public class Solution413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        Solution413 test = new Solution413();
        System.out.println(test.numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (null == A || 0 >= A.length) {
            return 0;
        }

        int added = 0;
        int sum = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                added += 1;
                sum += added;
            } else {
                added = 0;
            }
        }

        return sum;
    }
}
