/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/25
 */
public class Solution005 {

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
