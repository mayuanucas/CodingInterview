import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1087 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int t = Integer.parseInt(bufferedReader.readLine());
        while (0 < t--){
            int n = Integer.parseInt(bufferedReader.readLine());
            int flag = 2*n -2;
            int k = (int)Math.sqrt(flag);
            if (k*(k-1)==flag || k*(k+1)==flag){
                bufferedWriter.write("1\n");
            }else {
                bufferedWriter.write("0\n");
            }
            bufferedWriter.flush();
        }
    }


}
