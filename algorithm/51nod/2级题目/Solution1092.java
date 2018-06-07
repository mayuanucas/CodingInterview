import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        /**
         * dp[i][j]数组代表：对应长度为 i 的 x 字符串, 长度为 j 的 y 字符串。
         * 它们的最长公共子序列的长度为 dp[i][j]
         */
        int[][] dp = new int[1005][1005];

        String x = bufferedReader.readLine();
        String y = new StringBuffer(x).reverse().toString();

        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < y.length(); j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        bufferedWriter.write(x.length() - dp[x.length()][y.length()] + "\n");
        bufferedWriter.flush();

    }
}