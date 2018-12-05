package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 最大连续乘积子数组
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution021 {

    public static void main(String[] args) {
        double[] array = {-2.5, 4, 0, 3, 0.5, 8, -1};

        System.out.println(maxSubArray(array));
    }

    public static double maxSubArray(double[] array) {
        if (null == array || 0 >= array.length) {
            return 0.0D;
        }

        double ans = array[0];
        double maxEnd = array[0];
        double minEnd = array[0];
        for (int i = 1; i < array.length; ++i) {
            // 当前数字为正数时,以其结尾的最大乘积子数组来自于之前的最大
            // 当前数字为负数时,以其结尾的最大乘积子数组来自于之前的最小
            double end1 = maxEnd * array[i];
            double end2 = minEnd * array[i];
            maxEnd = Math.max(array[i], Math.max(end1, end2));
            minEnd = Math.min(array[i], Math.min(end1, end2));

            ans = Math.max(ans, maxEnd);
        }
        return ans;
    }
}
