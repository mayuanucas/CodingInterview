import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1596 {

    private static int N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int[] num = new int[N + 1];
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] temp = bufferedReader.readLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            num[Integer.parseInt(temp[i])]++;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            num[i + 1] += num[i] >> 1;
            if (1 == (num[i] & 1)) {
                ++ans;
            }
        }

        while (0 < num[N]) {
            if ((num[N] & 1) == 1) {
                ++ans;
            }
            num[N] = num[N] >> 1;
        }
        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }
}
