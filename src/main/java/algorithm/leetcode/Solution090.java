package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/11
 */
public class Solution090 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution090().subsetsWithDup(new int[]{1, 2, 2});

        ans.forEach(list -> {
            for (int num : list) {
                System.out.print(num);
            }
            System.out.println();
        });

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();

        if (null == nums || 0 >= nums.length) {
            return answer;
        }

        // 必须先对数组进行排序
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; ++size) {
            dfs(answer, oneAnswer, new boolean[nums.length], nums, size, 0);
        }
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, boolean[] hasVisited, int[] nums, int size, int start) {
        if (size == oneAnswer.size()) {
            answer.add(new LinkedList<>(oneAnswer));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 去除重复的解
            if (0 != i && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }

            oneAnswer.add(nums[i]);
            hasVisited[i] = true;

            dfs(answer, oneAnswer, hasVisited, nums, size, i + 1);

            oneAnswer.remove(oneAnswer.size() - 1);
            hasVisited[i] = false;
        }
    }
}
