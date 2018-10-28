package algorithm.alg4;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/10/28
 */
public class Solution004 {

    public static void main(String[] args) {
        System.out.println("abcd 是回文字符串吗? " + isPalindrome("abcd"));
        System.out.println("abcdcba 是回文字符串吗? " + isPalindrome("abcdcba"));
        System.out.println("aaaa 是回文字符串吗? " + isPalindrome("aaaa"));
    }

    /**
     * 判断字符串是否为回文字符串
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        if (null == str || 0 == str.length()) {
            return false;
        }

        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
