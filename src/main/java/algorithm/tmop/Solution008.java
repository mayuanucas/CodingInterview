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
}
