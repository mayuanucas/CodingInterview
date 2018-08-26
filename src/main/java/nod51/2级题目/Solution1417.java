import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int t = Integer.parseInt(bufferedReader.readLine());
        while (0 < t--) {
            long a, b;
            String[] temp = bufferedReader.readLine().split("\\s+");
            a = Long.parseLong(temp[0]);
            b = Long.parseLong(temp[1]);

            long c = gcd(a + 3 * b, 4 * (a + b));
            bufferedWriter.write((a + 3 * b) / c + "/" + 4 * (a + b) / c + "\n");
            bufferedWriter.flush();
        }

    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
