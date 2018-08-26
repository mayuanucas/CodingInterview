import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1344 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        long sum = 0L, theMin=0L;
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(bufferedReader.readLine());
            if (sum < theMin){
                theMin = sum;
            }
        }

        bufferedWriter.write((-1)*theMin + "\n");
        bufferedWriter.flush();
    }
}