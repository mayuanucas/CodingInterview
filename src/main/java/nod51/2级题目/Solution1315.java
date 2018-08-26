import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1315 {

    private static int[] digit = new int[33];
    private static int[] digitX = new int[33];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int N = Integer.parseInt(temp[0]);
        int X = Integer.parseInt(temp[1]);

        int XX = X;
        int key = 0;
        while (0 < XX){
            digitX[key++] = XX % 2;
            XX /= 2;
        }

        int Y;
        int ans = 233;
        for (int i=0; i<N; ++i){
            Y = Integer.parseInt(bufferedReader.readLine());
            if ((Y | X) != X){
                continue;
            }

            int m = 0;
            while (0 < Y){
                digit[m++] += (Y % 2);
                Y /= 2;
            }
        }

        for (int i=0; i<32; ++i){
            if ((0 < digitX[i]) && (0 == digit[i])){
                ans = 0;
                break;
            }

            if (0 < digit[i]){
                ans = ans > digit[i] ? digit[i] : ans;
            }
        }

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }
}
