import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1126 {

    /**
     * 存在循环节，只需要找到循环节即可。判断是否为循环节的方法是当连着两项为1时，即找到了循环节。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int n = Integer.parseInt(temp[2]);

        int[] f = new int[300];
        f[1] = 1;
        f[2] = 1;

        if (1 == n || 2 == n) {
            bufferedWriter.write("1\n");
            bufferedWriter.flush();
        } else {
            int i;
            for (i = 3; i < 300; i++) {
                f[i] = ((a * f[i - 1] + b * f[i - 2]) % 7 + 7) % 7;
                if (f[i - 1] == 1 && f[i] == 1) {
                    break;
                }
            }

            /**
             * 刚好为循环节的倍数时
             */
            f[0] = f[i - 2];
            bufferedWriter.write(f[n % (i - 2)] + "\n");
            bufferedWriter.flush();
        }
    }
}
