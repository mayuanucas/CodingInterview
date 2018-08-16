package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
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

//        for (int item : nums) {
//            oneAnswer.add(item);
//        }
//
//        dfs(answer, oneAnswer, 0);

        dfs(answer, oneAnswer, new boolean[nums.length], nums);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, boolean[] hasVisited, final int[] nums) {
        if (oneAnswer.size() == nums.length) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // 避免重复-> 当前位置数字与前一位数字相同,并且前一位置数字并没有被使用过
            if (0 != i && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }

            if (hasVisited[i]) {
                continue;
            }

            oneAnswer.add(nums[i]);
            hasVisited[i] = true;

            dfs(answer, oneAnswer, hasVisited, nums);

            oneAnswer.remove(oneAnswer.size() - 1);
            hasVisited[i] = false;
        }
    }

    public void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int index) {
        if (index == oneAnswer.size()) {
            answer.add(oneAnswer);
        }

        // 核心算法
        for (int i = index; i < oneAnswer.size(); i++) {
            // 与前一题的唯一区别就是避免与重复值进行交换
            if (i != index && oneAnswer.get(index).equals(oneAnswer.get(i))) {
                continue;
            }
            swap(oneAnswer, index, i);
            // 注意oneAnswer递归之后会发生变化，故这里产生相应副本进行操作
            dfs(answer, new ArrayList<>(oneAnswer), index + 1);
        }
    }


    /**
     * 把 list 中 a位置和 b 位置元素互换
     *
     * @param list
     * @param a
     * @param b
     */
    public void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
