package algorithm.leetcode;

import java.util.HashMap;

/**
 * @author: mayuan
 * @desc: 分割数组为连续子序列
 * @date: 2019/01/23
 */
public class Solution659 {

    /**
     * 这道题让我们将数组分割成多个连续递增的子序列，注意这里可能会产生歧义，实际上应该是分割成一个或多个连续递增的子序列，
     * 因为[1,2,3,4,5]也是正确的解。这道题就用贪婪解法就可以了.
     * 我们使用两个哈希表map，第一个map用来建立数字和其出现次数之间的映射freq，
     * 第二个用来建立可以加在某个连续子序列后的数字及其可以出现的次数之间的映射need。
     * 对于第二个map，举个例子来说，就是假如有个连，[1,2,3]，那么后面可以加上4，所以就建立4的映射。
     * 这样我们首先遍历一遍数组，统计每个数字出现的频率，然后我们开始遍历数组.
     * 对于每个遍历到的数字，首先看其当前出现的次数，如果为0，则继续循环；如果need中存在这个数字的非0映射，
     * 那么表示当前的数字可以加到某个连的末尾，我们将当前数字的映射值自减1，然后将下一个连续数字的映射值加1，
     * 因为当[1,2,3]连上4后变成[1,2,3,4]之后，就可以连上5了；如果不能连到其他子序列后面，我们来看其是否可以成为新的子序列的起点，
     * 可以通过看后面两个数字的映射值是否大于0，都大于0的话，说明可以组成3连儿，于是将后面两个数字的映射值都自减1，还有由于组成了3连儿，
     * 在need中将末尾的下一位数字的映射值自增1；如果上面情况都不满足，说明该数字是单牌，只能划单儿，直接返回false。
     * 最后别忘了将当前数字的freq映射值自减1。退出for循环后返回true，
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        if (null == nums || 2 >= nums.length) {
            return false;
        }

        HashMap<Integer, Integer> freq = new HashMap<>(nums.length / 2);
        HashMap<Integer, Integer> need = new HashMap<>(nums.length / 2);

        for (int e : nums) {
            freq.put(e, 1 + freq.getOrDefault(e, 0));
        }
        for (int e : nums) {
            if (0 == freq.getOrDefault(e, 0)) {
                continue;
            } else if (0 < need.getOrDefault(e, 0)) {
                need.put(e, need.getOrDefault(e, 0) - 1);
                need.put(e + 1, 1 + need.getOrDefault(e + 1, 0));
            } else if (0 < freq.getOrDefault(e + 1, 0) &&
                    0 < freq.getOrDefault(e + 2, 0)) {
                freq.put(e + 1, freq.getOrDefault(e + 1, 0) - 1);
                freq.put(e + 2, freq.getOrDefault(e + 2, 0) - 1);

                need.put(e + 3, 1 + need.getOrDefault(e + 3, 0));
            } else {
                return false;
            }
            freq.put(e, freq.getOrDefault(e, 0) - 1);
        }
        return true;
    }

}
