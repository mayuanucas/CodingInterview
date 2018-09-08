package algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 字符串全排列
 * @date: 2018/09/08
 */
public class Problem06 {
    public static void main(String[] args) {
        Problem06 test = new Problem06();

        List<List<Character>> ans = test.permutation("abc");

        ans.forEach(
                item -> {
                    for (char c : item) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                }
        );
    }

    public List<List<Character>> permutation(String str) {
        List<List<Character>> answer = new ArrayList<>();

        if (null == str || str.length() < 1) {
            return answer;
        }

        List<List<Character>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), str, new boolean[str.length()], 0);
        return ans;
    }

    public void dfs(List<List<Character>> answer, List<Character> oneAnswer, String str, boolean[] isSelected, int start) {
        if (oneAnswer.size() == str.length()) {
            answer.add(new ArrayList<>(oneAnswer));
            return;
        }

        for (int i = 0; i < str.length(); ++i) {
            if (isSelected[i]) {
                continue;
            }

            isSelected[i] = true;
            oneAnswer.add(str.charAt(i));

            dfs(answer, oneAnswer, str, isSelected, i + 1);

            oneAnswer.remove(oneAnswer.size() - 1);
            isSelected[i] = false;
        }
    }
}
