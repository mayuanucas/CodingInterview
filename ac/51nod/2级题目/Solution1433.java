import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1433 {

    /**
     * 本题关键在于555555555%9=0，所以至少需要9个5、一个0组成的数能被90整除或者0被90整除。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] str = bufferedReader.readLine().split("\\s+");

        int zero = 0, five = 0;
        for (int i = 0; i < n; i++) {
            if ("0".equals(str[i])) {
                zero++;
            } else if ("5".equals(str[i])) {
                five++;
            }
        }

        if (9 <= five && 1 <= zero) {
            while (9 <= five) {
                bufferedWriter.write("555555555");
                five -= 9;
            }

            while (0 < zero) {
                bufferedWriter.write("0");
                zero--;
            }

            bufferedWriter.write("\n");
            bufferedWriter.flush();
        } else if (1 <= zero) {
            bufferedWriter.write("0\n");
            bufferedWriter.flush();
        } else {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();
        }
    }
}