package algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author: mayuan
 * @desc: 递增子序列
 * @date: 2019/03/15
 */
public class Solution491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<>(), nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> answer, LinkedList<Integer> oneAnswer, int[] nums, int start) {
        if (oneAnswer.size() > 1) {
            answer.add(new LinkedList<>(oneAnswer));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                continue;
            }

            if (0 == oneAnswer.size() || nums[i] >= oneAnswer.peekLast()) {
                set.add(nums[i]);
                oneAnswer.add(nums[i]);
                dfs(answer, oneAnswer, nums, i + 1);
                oneAnswer.remove(oneAnswer.size() - 1);
            }
        }
    }
}
