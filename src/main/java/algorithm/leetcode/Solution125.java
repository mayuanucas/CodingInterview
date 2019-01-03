package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 验证回文串
 * @date: 2019/01/03
 */
public class Solution125 {

    public static void main(String[] args) {
        String str = "OP";
        String str2 = "A man, a plan, a canal: Panama";

        System.out.println(str.toLowerCase());
        System.out.println(new Solution125().isPalindrome(str));
        System.out.println(new Solution125().isPalindrome(str2));
    }

    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (0 == s.length()) {
            return true;
        }

        String text = s.toLowerCase();
        int i = 0, j = text.length() - 1;
        while (i <= j) {
            if ('a' > text.charAt(i) || 'z' < text.charAt(i)) {
                ++i;
            } else if ('a' > text.charAt(j) || 'z' < text.charAt(j)) {
                --j;
            } else {
                if (text.charAt(i) == text.charAt(j)) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
