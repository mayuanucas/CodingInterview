package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc 两个数组的交集 II
 * @create 2019/01/08
 */
public class Solution350 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        int[] res = new Solution350().intersect(nums1, nums2);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < nums1.length; ++i) {
            map.put(nums1[i], 1 + map.getOrDefault(nums1[i], 0));
        }

        int cnt = 0;
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i]) && 0 < (cnt = map.get(nums2[i]))) {
                result.add(nums2[i]);
                map.put(nums2[i], cnt - 1);
            }
        }

        int i = 0;
        int[] ans = new int[result.size()];
        for (Integer n : result) {
            ans[i++] = n;
        }
        return ans;
    }

}
