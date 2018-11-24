package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 最长回文子串
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @date:
 */
public class Solution008 {

    public static void main(String[] args) {
        final String text1 = "aba12";

        System.out.println(longestPalindromeSubstring(text1));
        System.out.println(longestPalindrome(text1));
    }

    public static int longestPalindromeSubstring(String text) {
        if (null == text || 0 >= text.length()) {
            return 0;
        }

        String newText = preProcess(text);
        // 对称轴索引位置
        int pivot = 1;
        // 当前已知最右侧的对称边界位置
        int mx = 0;
        // 辅助数组:表示对称半径
        int[] p = new int[newText.length()];
        // 逐个尝试对称轴的位置
        for (int i = 1; i < newText.length() - 1; ++i) {
            p[i] = mx > i ? Math.min(p[pivot * 2 - i], mx - i) : 1;

            while (newText.charAt(i - p[i]) == newText.charAt(i + p[i])) {
                ++p[i];
            }

            if (i + p[i] > mx) {
                mx = pivot + p[i];
                pivot = i;
            }
        }

        int ans = -1;
        for (int i = 0; i < p.length; ++i) {
            ans = Math.max(ans, p[i]);
        }

        return ans - 1;
    }

    /**
     * 对字符串进行处理,目的是为了统一处理回文字符串长度为奇数或是偶数,将其都转化为奇数长度回文
     * 字符串头添加$ 字符串尾添加^  这样做可以省去判断越界问题 i->(1, n-1)
     * ABC  ->   $#A#B#C#^
     *
     * @param text
     * @return
     */
    public static String preProcess(String text) {
        StringBuilder stringBuilder = new StringBuilder("$#");
        for (int i = 0; i < text.length(); ++i) {
            stringBuilder.append(text.charAt(i));
            stringBuilder.append("#");
        }
        stringBuilder.append("^");
        return stringBuilder.toString();
    }

    /**
     * 动态规划求解最长回文子串
     * dp(i, j) 表示 s(i ... j) 是一个回文子串, dp(i, j) 为 true 当 s(i) 等于 s(j) ,并且 s(i+1 ... j-1) 也是一个回文子串.
     * 当发现一个回文子串时, 检查它的长度是否为最长.
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n^2)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (null == s || 0 >= s.length()) {
            return null;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = null;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);

                if (dp[i][j] && (null == ans || ans.length() < j - i + 1)) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
