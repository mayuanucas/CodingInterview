import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 组合总和
 * @date: 2018/07/31
 */
public class Solution039 {
    public static void main(String[] args) {

        Solution039 test = new Solution039();
        List<List<Integer>> ans = test.combinationSum(new int[]{2, 3, 6, 7}, 7);
        ans.forEach(System.out::println);

        ans = test.combinationSum(new int[]{2, 3, 5}, 8);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        }
        if (0 == target) {
            answer.add(new LinkedList<>(oneAnswer));
        }
        for (int i = start; i < candidates.length; i++) {
            oneAnswer.add(candidates[i]);
            dfs(candidates, target - candidates[i], answer, oneAnswer, i);
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }
}
