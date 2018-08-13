package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/13
 */
public class Solution131 {
    public static void main(String[] args) {
        String str = "aabad";

        Solution131 test = new Solution131();
        List<List<String>> result = test.partition(str);

        result.forEach(list -> {
            for (String item : list) {
                System.out.print(item);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answer = new LinkedList<>();

        dfs(answer, new LinkedList<>(), s);

        return answer;
    }

    private void dfs(List<List<String>> answer, List<String> oneAnswer, String s) {
        if (0 == s.length()) {
            answer.add(new LinkedList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isValid(s, 0, i)) {
                oneAnswer.add(s.substring(0, i + 1));
                dfs(answer, oneAnswer, s.substring(i + 1));
                oneAnswer.remove(oneAnswer.size() - 1);
            }
        }
    }

    private boolean isValid(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
