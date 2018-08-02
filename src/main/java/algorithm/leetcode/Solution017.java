package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
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
        if (null == digits || digits.length() < 1) {
            return new ArrayList<>();
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

        List<String> ans = letter(digits, digits.length() - 1, map);

        return ans;
    }

    public List<String> letter(String digits, int index, Map<Integer, String> map) {
        int key = digits.charAt(index) - '0';
        String current = map.get(key);

        if (0 == index) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < current.length(); i++) {
                result.add(current.charAt(i) + "");
            }
            return result;
        }

        List<String> result = new ArrayList<>();
        List<String> step = letter(digits, index - 1, map);
        for (String item : step) {
            for (int i = 0; i < current.length(); i++) {
                result.add(item + current.charAt(i));
            }
        }
        return result;
    }
}
