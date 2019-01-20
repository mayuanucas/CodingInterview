package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 根据身高重建队列
 * @date: 2018/08/19
 */
public class Solution406 {
    public static void main(String[] args) {
        int[][] nums = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        Solution406 test = new Solution406();
        int[][] ans = test.reconstructQueue(nums);

        for (int i = 0; i < ans.length; ++i) {
            for (int j = 0; j < ans[i].length; ++j) {
                System.out.print(ans[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (null == people || 0 >= people.length || 0 >= people[0].length) {
            return new int[0][0];
        }

        // 按照第一个位置元素逆自然序排列,按照第二个位置元素自然序排列
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> answer = new ArrayList<>(people.length);
        for (int[] p : people) {
            // 指定 插入位置,插入的元素
            answer.add(p[1], p);
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
