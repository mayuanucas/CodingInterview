import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1413 {

    /**
     * 解题思路：
     * 这个题目，其实这个题目就是求所有位数中最大的那个数，这个也是很难想到的。举个例子：
     * 9998可以由8个1111和1个1110得到：
     * 5656可以由5个1111和1个101得到
     * 5678可以由5个1111和1个111和1个11和1个1得到
     * 所以就是求一个每一位对10取余的最大值。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int ans = 0;
        while (0 < n) {
            int m = n % 10;
            if (ans < m) {
                ans = m;
            }
            n /= 10;
        }
        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }
}
