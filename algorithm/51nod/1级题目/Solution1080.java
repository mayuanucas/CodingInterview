import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        boolean hasResult = false;
        int middleNumber = (int)Math.sqrt(n);
        for (int i=0; i<=middleNumber; i++){
            int remain = (int)Math.sqrt(n - i*i);
            if (remain * remain + i * i == n && i <= remain){
                hasResult = true;
                bufferedWriter.write(i + " " + remain + "\n");
                bufferedWriter.flush();
            }
        }

        if (!hasResult){
            bufferedWriter.write("No Solution\n");
            bufferedWriter.flush();
        }

    }
}
