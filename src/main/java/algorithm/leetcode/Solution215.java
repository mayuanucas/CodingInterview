package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/18
 */
public class Solution215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};

        Solution215 test = new Solution215();
//        System.out.println(test.findKthLargest(nums, 2));
//        System.out.println(test.findKthLargest2(nums, 2));
//        System.out.println(test.findKthLargest3(nums, 2));
        System.out.println(test.findKthLargest4(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            // 确保 优先队列的容量为 k,这样就选出了数组中较大的 k 个数字
            if (k < queue.size()) {
                queue.poll();
            }
        }
        // 返回容量为k的优先队列中最小的数字,该数字即为原始数组中第 k 个大的数字(从右向左)
        return queue.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public int findKthLargest4(int[] nums, int k) {
        // 从左往右,第k 个大的数字的下标
        k = nums.length - k;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int index = partition(nums, l, r);
            if (index == k) {
                break;
            } else if (index < k) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return nums[k];
    }

    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if (null == array || 0 > left) {
            return;
        }

        int index = 0;
        if (left < right) {
            index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int privot = array[left];

        while (left < right) {
            while (left < right && array[right] >= privot) {
                --right;
            }
            array[left] = array[right];

            while (left < right && array[left] <= privot) {
                ++left;
            }
            array[right] = array[left];
        }
        array[left] = privot;
        return left;
    }
}
