package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mayuan
 * @desc: 网易-字典序取字符串
 * @date: 2018/08/11
 */
public class Main081103 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Character>> answer = new ArrayList<>();
        List<Character> oneAnswer = getCharArray(n, m);
        dfs(answer, oneAnswer, 0);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : answer.get(k - 1)) {
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
    }

    private static List<Character> getCharArray(int n, int m) {
        List<Character> ans = new ArrayList<>(n + m);
        for (int i = 0; i < n; i++) {
            ans.add('a');
        }
        for (int i = 0; i < m; i++) {
            ans.add('z');
        }
        return ans;
    }

    public static void dfs(List<List<Character>> answer, List<Character> oneAnswer, int index) {
        if (index == oneAnswer.size()) {
            answer.add(oneAnswer);
            return;
        }

        for (int i = index; i < oneAnswer.size(); i++) {
            if (i != index && oneAnswer.get(index).equals(oneAnswer.get(i))) {
                continue;
            }
            swap(oneAnswer, index, i);
            dfs(answer, new ArrayList<>(oneAnswer), index + 1);
        }
    }

    public static void swap(List<Character> list, int i, int j) {
        char temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
