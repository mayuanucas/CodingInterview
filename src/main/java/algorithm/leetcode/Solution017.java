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

        dfs(answer, new StringBuilder(), digits, map);
        return answer;
    }

    private void dfs(List<String> answer, StringBuilder oneAnswer, final String digits, Map<Integer, String> map) {
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
            dfs(answer, oneAnswer, digits, map);
            // 删除该字符
            oneAnswer.deleteCharAt(oneAnswer.length() - 1);
        }
    }

}
