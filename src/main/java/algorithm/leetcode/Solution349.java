package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @desc 两个数组的交集
 * @create 2019/01/08
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        Set<Integer> intersect = new HashSet<>(nums2.length);

        for (int i = 0; i < nums1.length; ++i) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; ++i) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }

        int[] ans = new int[intersect.size()];
        int i = 0;
        for (Integer n : intersect) {
            ans[i++] = n;
        }
        return ans;
    }

}
