package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 回文判断
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution006 {

    public static void main(String[] args) {
        final String text1 = "abcd";
        final String text2 = "abcdcba";
        final String text3 = "123454321";

        System.out.println(isPalindrome(text1));
        System.out.println(isPalindrome(text2));
        System.out.println(isPalindrome(text3));
    }

    public static boolean isPalindrome(String str) {
        if (null == str) {
            return false;
        }

        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }

}
