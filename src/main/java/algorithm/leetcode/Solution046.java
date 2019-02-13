package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 全排列
 * @date: 2018/08/01
 */
public class Solution046 {

    public static void main(String[] args) {
        Solution046 sol = new Solution046();
        System.out.println(sol.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        if (null == nums || 0 >= nums.length) {
            return answer;
        }

        dfs(answer, new LinkedList(), nums);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, final int[] nums) {
        if (oneAnswer.size() == nums.length) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (oneAnswer.contains(nums[i])) {
                continue;
            }
            // 添加当前元素
            oneAnswer.add(nums[i]);
            dfs(answer, oneAnswer, nums);
            // 移除当前元素
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }
}
