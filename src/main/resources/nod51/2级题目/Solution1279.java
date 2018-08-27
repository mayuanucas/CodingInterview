import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/01
 */
public class Solution1279 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = bufferedReader.readLine().split("\\s+");
        int depthOfWell = Integer.parseInt(temp[0]);
        int numberOfPlates = Integer.parseInt(temp[1]);

        int[] widthOfWell = new int[depthOfWell + 1];
        widthOfWell[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= depthOfWell; i++) {
            widthOfWell[i] = Integer.parseInt(bufferedReader.readLine());
            widthOfWell[i] = Math.min(widthOfWell[i - 1], widthOfWell[i]);
        }

        int ans = 0;

        for (int i = 0; i < numberOfPlates; i++) {
            int widthOfPlate = Integer.parseInt(bufferedReader.readLine());

            while (widthOfPlate > widthOfWell[depthOfWell]) {
                depthOfWell--;
            }

            if (depthOfWell > 0) {
                ans++;
                depthOfWell--;
            }

        }

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();

    }
}
