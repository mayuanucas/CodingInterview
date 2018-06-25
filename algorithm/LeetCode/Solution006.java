/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/07
 */
public class Solution006 {

    public static void main(String[] args) {
        Solution006 sol = new Solution006();

        System.out.println(sol.convert("PAYPALISHIRING", 3));
        System.out.println(sol.convert("AB", 1));
    }

    /**
     * 每当 i 从增 1 变为减 1 时， j 才增加 1
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1 || numRows > s.length()) {
            return s;
        }

        int sLength = s.length();
        char[][] ans = new char[numRows][sLength];

        int i = 0, j = 0;
        // 改变增量控制变换
        int inc = 1;
        for (int k = 0; k < sLength; k++) {
            ans[i][j] = s.charAt(k);

            if (i >= numRows - 1) {
                inc = -1;
            } else if (0 == i) {
                inc = 1;
            }
            i += inc;
            if (-1 == inc) {
                j++;
            }
        }
        // 按行拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int m = 0; m < numRows; m++) {
            for (int n = 0; n < sLength; n++) {
                if (0 != ans[m][n]) {
                    stringBuilder.append(ans[m][n]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
