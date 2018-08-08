package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 本解法采用回溯算法实现，回溯算法的基本形式是“递归+循环”，正因为循环中嵌套着递归，递归中包含循环，
 * 这才使得回溯比一般的递归和单纯的循环更难理解，其实我们熟悉了它的基本形式，就会觉得这样的算法难度也不是很大。
 * 原数组中的每个元素有两种状态：存在和不存在。
 * <p>
 * ① 外层循环逐一往中间集合 temp 中加入元素 nums[i]，使这个元素处于存在状态
 * <p>
 * ② 开始递归，递归中携带加入新元素的 temp，并且下一次循环的起始是 i 元素的下一个，因而递归中更新 i 值为 i + 1
 * <p>
 * ③ 将这个从中间集合 temp 中移除，使该元素处于不存在状态
 * @date: 2018/08/08
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

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int[] nums, int index) {
        answer.add(new LinkedList<>(oneAnswer));

        for (int i = index; i < nums.length; i++) {
            oneAnswer.add(nums[i]);
            dfs(answer, oneAnswer, nums, i + 1);
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }

}
