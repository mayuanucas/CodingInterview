import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1266 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int l = Integer.parseInt(temp[1]);

        int maxTime = 0;
        int minTime = 0;

        for (int i=0; i<n; i++){
            /**
             * 向右走到端点的时间
             */
            int rightTime = Integer.parseInt(bufferedReader.readLine());

            /**
             * 向左走到端点的时间
             */
            int leftTime = l - rightTime;

            maxTime = Math.max(maxTime, Math.max(rightTime, leftTime));
            minTime = Math.max(minTime, Math.min(rightTime, leftTime));
        }

        bufferedWriter.write(minTime + " " + maxTime + "\n");
        bufferedWriter.flush();
    }
}