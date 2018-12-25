package algorithm.note;

/**
 * @author: mayuan
 * @desc: kmp 算法实现 https://www.cnblogs.com/yjiyjige/p/3263858.html
 * @date: 2018/12/25
 */
public class KMP {

    public static void main(String[] args) {
        final String ts = "abcdabde";
        final String ps = "abd";

        System.out.println(kmp(ts, ps));
        System.out.println(ts.indexOf(ps));
    }

    public static int kmp(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        int[] next = KMP.getNext(ps);

        while (i < t.length && j < p.length) {
            // 当j为-1时，要移动的是i，当然j也要归0
            if (-1 == j || t[i] == p[j]) {
                ++i;
                ++j;
            } else {
                // i不需要回溯,j回到指定位置.
                j = next[j];
            }
        }

        // 返回匹配的起始索引位置
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 获取 next 数组
     *
     * @param pattern 模式串
     * @return
     */
    public static int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;

        int k = -1, j = 0;
        while (j < p.length - 1) {
            if (-1 == k || p[k] == p[j]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
