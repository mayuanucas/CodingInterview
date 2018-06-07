import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {

    public static int M = 2;
    public static long MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        long n = Long.parseLong(bufferedReader.readLine());

        bufferedWriter.write(Solution.fibonacci(n - 1) + "\n");
        bufferedWriter.flush();

    }

    public static long fibonacci(long n) {
        // 单位矩阵
        long[][] E = {{1, 0}, {0, 1}};
        // 结果矩阵
        long[][] result = E;
        // 底数矩阵
        long[][] feb = {{1, 1}, {1, 0}};
        while (0 < n) {
            // n 是奇数
            if (1 == (n & 1)) {
                result = matrixMul(result, feb);
            }
            n /= 2;
            feb = matrixMul(feb, feb);
        }
        return result[0][0];
    }

    public static long[][] matrixMul(long[][] a, long[][] b) {
        long[][] c = new long[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    c[i][j] = (c[i][j] + (a[i][k] * b[k][j]) % MOD) % MOD;
                }
            }
        }
        return c;
    }

}
