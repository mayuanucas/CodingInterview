package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 最大数
 * @date: 2019/01/14
 */
public class Solution179 {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution179().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return "0";
        }

        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 特殊情况处理: [0, 0, 0] -> 0
        if ('0' == strNums[0].charAt(0)) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String e : strNums) {
            stringBuilder.append(e);
        }

        return stringBuilder.toString();
    }

}
