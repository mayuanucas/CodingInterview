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
        List<Integer> oneAnswer = new ArrayList<>(nums.length);

        Arrays.sort(nums);
        dfs(nums, answer, oneAnswer, 0, new boolean[nums.length]);
        return answer;
    }

    public void dfs(int[] nums, List<List<Integer>> answer, List<Integer> oneAnswer, int index, boolean[] taked) {
        if (index == nums.length) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!taked[i]) {
                oneAnswer.add(nums[i]);
                taked[i] = true;
                dfs(nums, answer, oneAnswer, index + 1, taked);
                taked[i] = false;
                oneAnswer.remove(index);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}
