package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 移掉K位数字
 * @date: 2019/01/20
 */
public class Solution402 {

    public static void main(String[] args) {
        String num = "1432219";
        final int k = 3;

        System.out.println(new Solution402().removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (0 < top && 0 < k && c < stack[top - 1]) {
                --top;
                --k;
            }
            stack[top++] = c;
        }

        int idx = 0;
        while (idx < digits && '0' == stack[idx]) {
            ++idx;
        }

        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }

}
