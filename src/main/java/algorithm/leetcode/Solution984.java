package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 不含 AAA 或 BBB 的字符串
 * @date: 2019/02/12
 */
public class Solution984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) {
            a = 'b';
            b = 'a';
            i = B;
            j = A;
        }
        while (i-- > 0) {
            ans.append(a);
            if (i > j) {
                ans.append(a);
                --i;
            }
            if (j > 0) {
                ans.append(b);
                --j;
            }
        }
        return ans.toString();
    }
}
