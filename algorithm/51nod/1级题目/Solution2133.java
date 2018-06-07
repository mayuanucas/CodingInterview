import java.io.*;
import java.util.Arrays;

/**
 * @author mayuan
 * @desc
 * @date 2018/05/14
 */
public class Solution2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (n - i) * a[i];
        }
        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }
}
