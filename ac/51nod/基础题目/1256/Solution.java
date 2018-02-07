import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        // n <= m
        int[] g = gcd(n, m);
        int ans = (g[2] % n + n) % n;

        bufferedWriter.write(ans + "");
        bufferedWriter.flush();
    }

    /*
    假定 a >= b
     */
    public static int[] gcd(int a, int b) {
        if (0 == b) {
            return new int[]{a, 1, 0};
        } else {
            int[] next = gcd(b, a % b);
            int g = next[0];
            int x = next[2];
            int y = next[1] - next[2] * (a / b);
            return new int[]{g, x, y};
        }
    }
}
