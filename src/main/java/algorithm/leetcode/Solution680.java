package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution680 {
    public static void main(String[] args) {
        Solution680 test = new Solution680();

        System.out.println(test.validPalindrome("aba"));
        System.out.println(test.validPalindrome("abcda"));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            ++left;
            --right;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
