package algorithm.str;

/**
 * @author: mayuan
 * @desc: 最长回文子串 leetcode 005
 * @date: 2018/09/07
 */
public class Problem07 {
    private int index;
    private int len;

    public static void main(String[] args) {
        Problem07 solution = new Problem07();

        System.out.println(solution.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        if (null == s || 2 > s.length()) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; ++i) {
            palindromeHelper(s, i, i);
            palindromeHelper(s, i, i + 1);
        }

        return s.substring(index, index + len);
    }

    public void palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }

        // 发现更长的回文子序列,则进行更新
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }
}
