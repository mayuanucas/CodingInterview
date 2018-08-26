import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mayuan
 * @desc
 * @date 2017/12/25
 */
public class Solution1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strTemp = bufferedReader.readLine().split("\\s+");
        int m = Integer.parseInt(strTemp[0]), n = Integer.parseInt(strTemp[1]);
        int a = Integer.parseInt(strTemp[2]), b = Integer.parseInt(strTemp[3]);

        Set<Double> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(Math.pow(a + i, b + j));
            }
        }
        bufferedWriter.write(set.size() + "\n");
        bufferedWriter.flush();
    }
}
