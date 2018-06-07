import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution2020 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            String[] tmp = bufferedReader.readLine().split("\\s+");

            bufferedWriter.write(fabi(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])) + "\n");
            bufferedWriter.flush();

        }
    }

    public static int fabi(int number, int k) {
        if (0 == k) {
            return number;
        }
        int[] tempArray = handleNumber(number);
        int max = tempArray[0];
        int min = tempArray[1];
        k--;

        return fabi(max - min, k);
    }

    public static int[] handleNumber(int number) {
        int[] tempNumbers = new int[4];
        for (int i = 0; i < tempNumbers.length; i++) {
            tempNumbers[i] = number % 10;
            number /= 10;
        }
        Arrays.sort(tempNumbers);

        int minNumber = 0;
        int maxNumber = 0;
        for (int i = 0; i < tempNumbers.length; i++) {
            minNumber = minNumber * 10 + tempNumbers[i];
            maxNumber = maxNumber * 10 + tempNumbers[tempNumbers.length - 1 - i];
        }
        return new int[]{maxNumber, minNumber};
    }
}