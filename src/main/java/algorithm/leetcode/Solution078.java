package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 子集
 * @date: 2019/02/13
 */
public class Solution078 {

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution078().subsets(new int[]{1, 2, 3});
        result.forEach(item -> {
            for (int t : item) {
                System.out.print(t);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();

        dfs(answer, oneAnswer, nums, 0);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int[] nums, int start) {
        answer.add(new LinkedList<>(oneAnswer));

        for (int i = start; i < nums.length; ++i) {
            oneAnswer.add(nums[i]);
            dfs(answer, oneAnswer, nums, i + 1);
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }

}
