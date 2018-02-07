import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());

        /**
         * dp[x]表示从1~(10^x)-1中1的数字的个数
         * 例如i=3，就是1~999中含有1的数字的个数
         * 对dp数组的解释：
         * 10 * dp[i-1] => 数字最高位可取值范围 0~9 共10种，组合除最高位数字后 所有位，可得到的所有情况。
         * 10 ^ (i - 1) => 数字最高位为 1 时， 最高位数字后 可取的所有情况，组合最高位的 1 后，可得的所有情况。
         * 例如： dp[2] 表示，1~99中出现所有1的个数（注意： 11 这个数包含 2 个 1）
         * 10 * dp[1] = 10 => 最高位有 10 种取值，组合除最高位数字后 所有位，可得到的所有情况：
         * 01，11，21，31，41，51，61，71，81，91
         *
         * 10 ^(2-1)  = 10 => 最高位是 1 时，最高位数字后 可取的所有情况，组合最高的 1 后， 可得的所有情况。
         * 10，11，12，13，14，15，16，17，18，19
         * 即：最高位数字后的，所有位 从 0 变化到 最大值
         * i=2时， 从 0 ~ 9， 共 10^1 = 10 种情况
         * i=3时， 从 00 ~ 99， 共 10^2 = 100 种情况
         * i=4时， 从 000 ~ 999， 共 10^3 = 1000 种情况
         * i=5时， 从 0000 ~ 9999，共 10^4 = 10000 种情况
         */
        double[] dp = new double[12];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 10 * dp[i - 1] + Math.pow(10, i - 1);
        }

        double ans = 0.0D;
        int bitID = 1, tail = 0;
        while (0 < n) {
            int yushu = n % 10;
            if (1 == yushu) {
                ans += dp[bitID - 1];
                ans += (tail + 1);
            } else if (0 != yushu) {
                ans += (yushu * dp[bitID - 1] + Math.pow(10, bitID - 1));
            }
            tail += yushu * Math.pow(10, bitID - 1);
            n /= 10;
            bitID++;
        }

        bufferedWriter.write((int) ans + "\n");
        bufferedWriter.flush();
    }
}
