import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int[] x = new int[4];
        int[] y = new int[4];
        int[] z = new int[4];

        int n = Integer.parseInt(bufferedReader.readLine());
        while (0 < n--) {
            for (int i = 0; i < 4; i++) {
                String[] temp = bufferedReader.readLine().split("\\s+");
                x[i] = Integer.parseInt(temp[0]);
                y[i] = Integer.parseInt(temp[1]);
                z[i] = Integer.parseInt(temp[2]);
            }
            if (Solution.gongMian(x, y, z)){
                bufferedWriter.write("Yes\n");
            } else {
                bufferedWriter.write("No\n");
            }
            bufferedWriter.flush();
        }
    }

    public static boolean gongMian(int[] x, int[] y, int[] z) {
        int r1, r2, r3, r4, r5, r6, r7, r8, r9;
        r1 = x[0] - x[1]; r2 = y[0] - y[1]; r3 = z[0] - z[1];

        r4 = x[0] - x[2]; r5 = y[0] - y[2]; r6 = z[0] - z[2];

        r7 = x[0] - x[3]; r8 = y[0] - y[3]; r9 = z[0] - z[3];
        if (r1 * r5 * r9 + r2 * r6 * r7 + r3 * r4 * r8 - r3 * r5 * r7 - r2 * r4 * r9 - r1 * r6 * r8 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
