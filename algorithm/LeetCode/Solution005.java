/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/25
 */
public class Solution005 {

    public static void main(String[] args){
        Solution005 sol = new Solution005();

        System.out.println(sol.longestPalindrome2("abba"));
    }

    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expansion(s, i, i);
            int l2 = expansion(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                // 当回文子串长度为偶数时，需先减一
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expansion(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public String longestPalindrome(String s) {
        int maxLength = 0, start = 0;
        // 第一种情况： aba 以 i 为中心向两边扩展
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        // 第二种情况： abba 以 i, i+1 为中心向两边扩展
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        if (maxLength > 0) {
            return s.substring(start, start + maxLength);
        } else if (0 == maxLength) {
            return s.substring(start, start + 1);
        }
        return null;
    }

}
