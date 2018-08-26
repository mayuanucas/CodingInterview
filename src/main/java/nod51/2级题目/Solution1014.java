import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1014 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int p = Integer.parseInt(temp[0]);
        int a = Integer.parseInt(temp[1]);
        boolean flag = false;
        long x = 0L;
        while (x <= p){
            if (x * x % p == a) {
                flag = true;
                bufferedWriter.write(x + " ");
            }
            ++x;
        }

        if (!flag) {
            bufferedWriter.write("No Solution\n");
        }
        bufferedWriter.flush();
    }
}