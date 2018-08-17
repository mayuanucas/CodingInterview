package algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution088 {
    public static void main(String[] args) {
        Solution088 test = new Solution088();

        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        test.merge(a, 3, b, 3);

        for (int t : a) {
            System.out.print(t);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (0 <= index1 || 0 <= index2) {
            if (0 > index1) {
                nums1[mergeIndex--] = nums2[index2--];
            } else if (0 > index2) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] <= nums2[index2]) {
                nums1[mergeIndex--] = nums2[index2--];
            } else {
                nums1[mergeIndex--] = nums1[index1--];
            }
        }
    }
}
