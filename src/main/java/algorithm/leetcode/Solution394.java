package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc: 字符串解码
 * @date: 2019/03/15
 */
public class Solution394 {

    public String decodeString(String s) {
        if (null == s || 0 >= s.length()) {
            return "";
        }

        String ans = "";
        LinkedList<String> resStack = new LinkedList<>();
        LinkedList<Integer> numberStack = new LinkedList<>();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    ++idx;
                }
                numberStack.push(num);
            } else if ('[' == c) {
                resStack.push(ans);
                ans = "";
                ++idx;
            } else if (']' == c) {
                StringBuilder stringBuilder = new StringBuilder(resStack.pop());
                int repeat = numberStack.pop();
                while (0 < repeat--) {
                    stringBuilder.append(ans);
                }
                ans = stringBuilder.toString();
                ++idx;
            } else {
                ans += c;
                ++idx;
            }
        }

        return ans;
    }
}
