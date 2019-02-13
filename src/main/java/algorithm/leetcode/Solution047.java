package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc: 全排列 II
 * @date: 2018/07/15
 */
public class Solution047 {

    public static void main(String[] args) {
        System.out.println(new Solution047().permuteUnique(new int[]{1, 2, 1}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();

        // 有相同值时注意先排序将相同值放在一起
        Arrays.sort(nums);
        dfs(answer, oneAnswer, new boolean[nums.length], nums);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, boolean[] hasVisited, final int[] nums) {
        if (oneAnswer.size() == nums.length) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // 避免重复:
            // 1.当前位置数字已经被使用
            // 2.当前位置数字与前一位数字相同,并且前一位置数字并没有被使用过(这说明,该组合以及被计算过,无需重复)
            if (hasVisited[i] || (0 != i && nums[i] == nums[i - 1] && !hasVisited[i - 1])) {
                continue;
            }

            oneAnswer.add(nums[i]);
            hasVisited[i] = true;

            dfs(answer, oneAnswer, hasVisited, nums);

            oneAnswer.remove(oneAnswer.size() - 1);
            hasVisited[i] = false;
        }
    }
}
