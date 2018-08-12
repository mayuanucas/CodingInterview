package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/12
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 test = new Solution216();
        List<List<Integer>> result = test.combinationSum3(3, 9);

        result.forEach(list -> {
            for (int n : list) {
                System.out.print(n);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new ArrayList<>(k);

        dfs(answer, oneAnswer, k, n, 1);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int n, int targetSum, int startNumber) {
        if (0 > targetSum) {
            return;
        }
        if (oneAnswer.size() == n && 0 == targetSum) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        // 依次迭代每个数字 1~9
        for (int num = startNumber; num <= 9; num++) {
            oneAnswer.add(num);
            dfs(answer, oneAnswer, n, targetSum - num, num + 1);
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }
}
