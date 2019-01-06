package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 反转字符串
 * @date: 2019/01/06
 */
public class Solution344 {

    public String reverseString(String s) {
        if (null == s || 1 >= s.length()) {
            return s;
        }

        char[] words = s.toCharArray();
        int i = 0, j = words.length - 1;
        while (i < j) {
            swap(words, i, j);
            ++i;
            --j;
        }
        return new String(words);
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
