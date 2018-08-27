import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1381 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        /**
         * 半径为r的硬币相交的直线的的条数有2*r和2*r+1,其中2r+1的情形只有一种，硬币和直线相切，这种情况只有一种，
         * 而硬币落在桌子上的情形有无数种，故概率为0，所以另一种情形的概率是1，所以答案就是2*r
         */
        while (0 < testNumber--) {
            long r = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(2 * r + "\n");
        }
        bufferedWriter.flush();
    }
}