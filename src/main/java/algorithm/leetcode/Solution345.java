package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution345 {
    public static void main(String[] args) {
        Solution345 test = new Solution345();

        System.out.println(test.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (null == s || 0 >= s.length()) {
            return s;
        }

        Set<Character> letters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] array = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;

        // 除交换元音字符外,每次仅处理一个字符.可能出现:最后两个字符都不是元音字符,但都需要赋值给新的数组(需两次处理),所以此处循环在等于时结束
        while (left <= right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!letters.contains(cLeft)) {
                array[left++] = cLeft;
            } else if (!letters.contains(cRight)) {
                array[right--] = cRight;
            } else {
                array[left++] = cRight;
                array[right--] = cLeft;
            }
        }
        return new String(array);
    }
}
