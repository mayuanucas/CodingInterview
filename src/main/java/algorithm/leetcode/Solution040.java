package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 组合总和 II
 * @date: 2018/08/02
 */
public class Solution040 {
    public static void main(String[] args) {

        Solution040 test = new Solution040();
        List<List<Integer>> ans = test.combinationSum2(new int[]{1, 1, 1, 2}, 3);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();

        if (null == candidates || 0 >= candidates.length || 0 >= target) {
            return answer;
        }

        Arrays.sort(candidates);
        dfs(candidates, target, answer, oneAnswer, 0);
        return answer;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> answer, List<Integer> oneAnswer, int start) {
        if (0 > target) {
            return;
        } else if (0 == target) {
            answer.add(new LinkedList<>(oneAnswer));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                oneAnswer.add(candidates[i]);
                dfs(candidates, target - candidates[i], answer, oneAnswer, i + 1);
                oneAnswer.remove(oneAnswer.size() - 1);
            }
        }
    }
}
