import java.io.*;
import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1<<16);

        int n = Integer.parseInt(bufferedReader.readLine());
        long[][] ma = new long[n][n];
        long[][] mb = new long[n][n];

        for (int i=0; i<n; i++){
            String[] oneLine = bufferedReader.readLine().split(" ");
            for (int j=0; j<n; j++){
                ma[i][j] = Integer.parseInt(oneLine[j]);
            }
        }

        for (int i=0; i<n; i++){
            String[] oneLine = bufferedReader.readLine().split(" ");
            for (int j=0; j<n; j++){
                mb[i][j] = Integer.parseInt(oneLine[j]);
            }
        }

        long[][] c = Solution.matrixMul(ma, mb);

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                bufferedWriter.write(c[i][j] + " ");
            }
            bufferedWriter.write("\r\n");
        }
        bufferedWriter.flush();
    }

    public static long[][] matrixMul(long[][] a, long[][] b){
        int row = a.length;
        long[][] c = new long[row][row];

        for (int i=0; i<row; i++){
            for (int j=0; j<row; j++){
                for (int k=0; k<row; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
