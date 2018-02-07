import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1284 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        long ans = 0;
        long n = Long.parseLong(bufferedReader.readLine());
        /**
         * 解题思路：
         * 1：求出是 2 3 5 7倍数的所有数的个数。（利用 容斥原理 求是这些数倍数的总个数）
         * 2：再求第1步的反例。
         */
        ans=n;
        ans-=(n/2+n/3+n/5+n/7);
        ans+=(n/6+n/10+n/14+n/15+n/21+n/35);
        ans-=(n/30+n/42+n/70+n/105);
        ans+=(n/210);

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }


}
