package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/11
 */
public class Solution052 {
    public static void main(String[] args) {
        int result = new Solution052().totalNQueens(4);

        System.out.println(result);
    }

    public int totalNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        String[] oneAnswer = new String[n];

        dfs(answer, oneAnswer, new int[n], n, 0);
        return answer.size();
    }

    private void dfs(List<List<String>> answer, String[] oneAnswer, int[] pos, int numberOfQueen, int index) {
        if (numberOfQueen == index) {
            answer.add(Arrays.asList(oneAnswer.clone()));
            return;
        }

        // 从左侧第一列开始
        for (int j = 0; j < numberOfQueen; j++) {
            // 将第index行的皇后放在第j列
            pos[index] = j;
            // 冲突标志位
            boolean conflict = false;
            // 遍历当前已放置好的皇后，看是否有冲突
            for (int i = 0; i < index; i++) {
                if (pos[i] == pos[index] || Math.abs(i - index) == Math.abs(pos[i] - pos[index])) {
                    conflict = true;
                    break;
                }
            }
            // 找到没有冲突的位置坐标,并进行下一步迭代
            if (!conflict) {
                char[] line = new char[numberOfQueen];
                Arrays.fill(line, '.');
                line[j] = 'Q';
                oneAnswer[index] = new String(line);
                // 没有冲突，当前解法可行，增加一位皇后
                dfs(answer, oneAnswer, pos, numberOfQueen, index + 1);
            }
        }
    }
}
