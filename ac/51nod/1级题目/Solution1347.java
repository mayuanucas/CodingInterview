import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1347 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        char[] shuzu = bufferedReader.readLine().toCharArray();
        int halfLength = shuzu.length / 2;
        /**
         * flag 代表默认是 对串
         */
        boolean flag = true;
        if (1 == (shuzu.length & 1)) {
            bufferedWriter.write("NO\n");
            bufferedWriter.flush();
            return;
        } else {
            for (int i = 0; i < halfLength; ++i) {
                if (shuzu[i] != shuzu[i + halfLength]) {
                    flag = false;

                    bufferedWriter.write("NO\n");
                    bufferedWriter.flush();

                    break;
                }
            }
            if (flag) {
                bufferedWriter.write("YES\n");
                bufferedWriter.flush();
            }
        }
    }
}