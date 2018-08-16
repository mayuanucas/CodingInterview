package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc: 电话号码的字母组合
 * @date: 2018/07/11
 */
public class Solution017 {

    public static void main(String[] args) throws Exception {
        List<String> result = new Solution017().letterCombinations("23");
        for (String item : result) {
            System.out.println(item);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new LinkedList<>();
        if (null == digits || digits.length() <= 0) {
            return answer;
        }

        Map<Integer, String> map = new HashMap<>(8);
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

//        dfs(digits, map, answer, 0);
        dfs2(answer, new StringBuilder(), digits, map);
        return answer;
    }

    private void dfs2(List<String> answer, StringBuilder oneAnswer, final String digits, Map<Integer, String> map) {
        if (oneAnswer.length() == digits.length()) {
            answer.add(oneAnswer.toString());
            return;
        }

        // 当前位置的数字
        int currentDigit = digits.charAt(oneAnswer.length()) - '0';
        // 当前位置的数字按键上的字符串
        String letter = map.get(currentDigit);
        for (char c : letter.toCharArray()) {
            // 添加该字符
            oneAnswer.append(c);
            dfs2(answer, oneAnswer, digits, map);
            // 删除该字符
            oneAnswer.deleteCharAt(oneAnswer.length() - 1);
        }
    }

    public void dfs(final String digits, Map<Integer, String> map, List<String> answer, int index) {
        // 获取当前序号上的数字
        int key = digits.charAt(index) - '0';
        // 获取当前数字按键上的所有字符
        String characters = map.get(key);

        // 当前序号为输入字符串的最后一个位置时
        if (index == digits.length() - 1) {
            for (int i = 0; i < characters.length(); i++) {
                answer.add(String.valueOf(characters.charAt(i)));
            }
            return;
        }

        dfs(digits, map, answer, index + 1);

        while (index + 1 + answer.get(0).length() == digits.length()) {
            String oneAnswer = answer.remove(0);
            for (int i = 0; i < characters.length(); i++) {
                answer.add(characters.charAt(i) + oneAnswer);
            }
        }
    }
}
