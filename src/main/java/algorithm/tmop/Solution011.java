package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 最大连续子数组和
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution011 {

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};

        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] array) {
        if (null == array || 0 >= array.length) {
            return 0;
        }

        // 以前一位置元素结尾的最大连续子数组的和
        int preSum = 0;
        // 最大连续子数组的和
        int maxSum = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (0 <= preSum) {
                preSum += array[i];
            } else {
                preSum = array[i];
            }

            if (preSum > maxSum) {
                maxSum = preSum;
            }
        }

        return maxSum;
    }
}
