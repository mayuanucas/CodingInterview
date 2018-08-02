package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/10
 */
public class Solution015 {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{0, 0, 0, 0};

        System.out.println(new Solution015().threeSum(nums));
        System.out.println(new Solution015().threeSum(nums2));
        System.out.println(new Solution015().threeSum(nums3));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return answer;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            int begin = i + 1;
            int end = nums.length - 1;
            // nums[i]和nums[i-1]相等，避免重复
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            while (begin < end) {
                // nums[begin]和nums[begin-1]相等，避免重复
                if (begin > i + 1 && nums[begin] == nums[begin - 1]) {
                    begin++;
                    continue;
                }
                // nums[end]和nums[end+1]相等，避免重复
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }

                int sum = nums[i] + nums[begin] + nums[end];
                if (0 == sum) {
                    answer.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                } else if (0 > sum) {
                    begin++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }
}
