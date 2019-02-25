package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 最大整除子集
 * @date: 2019/02/25
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if (null == nums || 0 >= nums.length) {
            return ans;
        }

        int n = nums.length;
        // count[i]表示第i个位置的元素能被多少个数整除(最大值)
        int[] count = new int[n];
        // 记录的是整除的关系链
        int[] pre = new int[n];

        Arrays.sort(nums);
        int max = 0;
        int index = -1;

        for (int i = 0; i < n; ++i) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (0 == nums[i] % nums[j]) {
                    if (1 + count[j] > count[i]) {
                        count[i] = 1 + count[j];
                        pre[i] = j;
                    }
                }
            }

            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        while (-1 != index) {
            ans.add(nums[index]);
            index = pre[index];
        }
        return ans;
    }
}
