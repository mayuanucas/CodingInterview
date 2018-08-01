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
        System.out.println(sol.permute(new int[]{1, 2, 3}));
    }

    /**
     * 全排列
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
