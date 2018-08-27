import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/12/09
 */
public class Solution1062 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        long[] numbers = new long[100100];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 0; 2 * i + 1 < 100100; i++) {
            numbers[2 * i] = numbers[i];
            numbers[2 * i + 1] = numbers[i] + numbers[i + 1];
        }

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            int n = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(findMax(numbers, n) + "\n");
            bufferedWriter.flush();
        }
    }

    public static long findMax(long[] num, int len) {
        long max = 0L;

        for (int i=1; i<=len; i++){
            if (max < num[i]){
                max = num[i];
            }
        }
        return max;
    }
}
