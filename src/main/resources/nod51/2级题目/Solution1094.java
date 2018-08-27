import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1094 {

    private static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        int[] a = new int[n + 1];
        int[] sum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
            sum[i] = sum[i - 1] + a[i];
            if (null == map.get(sum[i]) || 0 == map.get(sum[i])) {
                map.put(sum[i], i);
            }
        }

        int left = INF, right = INF;
        for (int i = 1; i <= n; i++) {
            if (k == sum[i]) {
                bufferedWriter.write( "1 " + i + "\n");
                bufferedWriter.flush();
                return;
            }

            int index = map.getOrDefault(sum[i] - k, 0);
            if (0 != index) {
                if (index < left && index < i) {
                    left = index;
                    right = i;
                }
            }
        }

        if (INF == left) {
            bufferedWriter.write("No Solution\n");
            bufferedWriter.flush();
        } else {
            bufferedWriter.write(left + 1 + " " + right + "\n");
            bufferedWriter.flush();
        }
    }
}