import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1283 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int s = Integer.parseInt(bufferedReader.readLine());

        int weight = (int)Math.sqrt(s);

        while (0 != s % weight){
            weight--;
        }
        bufferedWriter.write(2*(weight + s/weight) + "\n");
        bufferedWriter.flush();
    }


}
