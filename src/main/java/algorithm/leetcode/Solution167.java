package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 两数之和 II - 输入有序数组
 * @date: 2018/08/17
 */
public class Solution167 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution167 test = new Solution167();
        for (int t : test.twoSum(nums, target)) {
            System.out.println(t);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        if (null == numbers || 2 > numbers.length) {
            return answer;
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (target == temp) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            } else if (target > temp) {
                ++left;
            } else {
                --right;
            }
        }
        return answer;
    }
}
