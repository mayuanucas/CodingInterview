import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1489 {

    private static int a;
    private static int b;

    /**
     * dp[12][20][20][20]; // dp[a][b][c][d]第a个弓箭手面临第a-1、a、a+1个弓箭手的生命值分别为b、c、d的状态
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        a = Integer.parseInt(temp[1]);
        b = Integer.parseInt(temp[2]);

        String[] tmp = bufferedReader.readLine().split("\\s+");

        int[] h = new int[n + 3];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(tmp[i]);
            h[i]++;
        }
        int ans = solve(h, n);

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }

    public static int solve(int[] h, int n) {
        if (n == 3) return Math.max(Math.max((h[0] - 1) / b + 1, (h[2] - 1) / b + 1), (h[1] - 1) / a + 1);
        int x = (h[0] - 1) / b + 1;
        int y = (h[n - 1] - 1) / b + 1;
        h[1] -= a * x;
        h[2] -= b * x;
        h[n - 2] -= a * y;
        h[n - 3] -= b * y;
        return x + y + dfs(h, 1, n - 2);
    }

    public static int dfs(int[] h, int s, int e) {
        if (s == e) return h[s] > 0 ? (h[s] - 1) / a + 1 : 0;
        if (h[s] <= 0) return dfs(h, s + 1, e);
        int ans = 0x3f3f3f3f;
        int[] tmp = h.clone();
        int k = (h[s] - 1) / a + 1;
        for (int i = 0; i <= k; i++) {
            h = tmp.clone();
            int tot = i;
            h[s] -= i * a;
            h[s + 1] -= i * b;
            if (h[s] > 0) {
                int t = (h[s] - 1) / b + 1;
                tot += t;
                h[s + 1] -= a * t;
                h[s + 2] -= b * t;
            }
            tot += dfs(h, s + 1, e);
            ans = Math.min(ans, tot);
        }
        return ans;
    }
}
