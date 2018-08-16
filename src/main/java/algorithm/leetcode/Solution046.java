package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/01
 */
public class Solution046 {
    public static void main(String[] args) {
        Solution046 sol = new Solution046();
//        System.out.println(sol.permute(new int[]{1, 2, 3}));
//        System.out.println(sol.permute2(new int[]{1, 2, 3}));
        System.out.println(sol.permute3(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        if (null == nums || 0 >= nums.length) {
            return answer;
        }

        dfs2(answer, new LinkedList(), new boolean[nums.length], nums);
        return answer;
    }

    private void dfs2(List<List<Integer>> answer, List<Integer> oneAnswer, boolean[] hasVisited, final int[] nums) {
        if (oneAnswer.size() == nums.length) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < hasVisited.length; ++i) {
            if (hasVisited[i]) {
                continue;
            }

            // 添加当前元素并进行标记
            oneAnswer.add(nums[i]);
            hasVisited[i] = true;

            dfs2(answer, oneAnswer, hasVisited, nums);

            // 移除当前元素并移除标记
            oneAnswer.remove(oneAnswer.size() - 1);
            hasVisited[i] = false;
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new ArrayList<>(nums.length);
        for (int item : nums) {
            oneAnswer.add(item);
        }

        dfs(answer, oneAnswer, 0);
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int index) {
        if (index == oneAnswer.size()) {
            answer.add(oneAnswer);
        }

        // 核心算法
        for (int i = index; i < oneAnswer.size(); i++) {
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

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> answer = new LinkedList<>();

        if (null == nums || 0 >= nums.length) {
            return answer;
        }

        // 首先要把数组第一个数字添加进去
        answer.add(new LinkedList<>(Arrays.asList(nums[0])));
        List<Integer> temp;
        for (int i = 1; i < nums.length; i++) {
            // 当列表当中还存在着当前长度的列表时,进行处理
            do {
                temp = answer.removeFirst();
                for (int j = 0; j <= temp.size(); j++) {
                    temp.add(j, nums[i]);
                    answer.add(new LinkedList<>(temp));
                    temp.remove(j);
                }
            } while (answer.getFirst().size() == i);
        }
        return answer;
    }
}
