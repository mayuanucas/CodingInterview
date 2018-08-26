import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/23
 */
public class Solution1629 {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        double s = Double.parseDouble(bufferedReader.readLine());

        double rr = s / (4.0 * Math.PI);
        double v = Math.sqrt(s * s * rr - 2 * s * Math.PI * rr * rr) / 3.0;

        bufferedWriter.write(v + "\n");
        bufferedWriter.flush();


    }
}
