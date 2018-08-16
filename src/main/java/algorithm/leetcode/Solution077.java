package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 组合问题
 * @date: 2018/08/08
 */
public class Solution077 {

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution077().combine(4, 2);
        result.forEach(item -> {
            for (int t : item) {
                System.out.print(t);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();
        dfs(answer, oneAnswer, n, k, 1);
        return answer;
    }

    /**
     * 回溯算法
     *
     * @param answer
     * @param oneAnswer
     * @param n
     * @param k
     * @param index
     */
    public void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int n, int k, int index) {
        // 临时列表的长度和 k 相等时,即找到一组答案,添加到列表中.
        if (k == oneAnswer.size()) {
            answer.add(new LinkedList<>(oneAnswer));
            return;
        }

        for (int i = index; i <= n; i++) {
            oneAnswer.add(i);

            dfs(answer, oneAnswer, n, k, i + 1);

            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }

}
