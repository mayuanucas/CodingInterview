import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1007 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        /**
         * 用01背包装物品。容量为和的一半。物品的价值为 数字的值，背包内最大的价值就是相差最少的方案。
         */
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] shuzu = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            shuzu[i] = Integer.parseInt(bufferedReader.readLine());
            sum += shuzu[i];
        }
        int halfOfSum = sum / 2;
        int[] dp = new int[halfOfSum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = halfOfSum; j >= shuzu[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - shuzu[i]] + shuzu[i]);
            }
        }
        bufferedWriter.write((sum - dp[halfOfSum] - dp[halfOfSum]) + "\n");
        bufferedWriter.flush();
    }
}