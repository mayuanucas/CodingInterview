import java.io.*;
import java.util.Arrays;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1090 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(arr);

        boolean flag = false;
        int i=0;
        while (0 > arr[i]){
            int j=i+1, k=n-1;
            while (j < k){
                if (0 == arr[i] + arr[j] + arr[k]){
                    flag = true;
                    bufferedWriter.write(arr[i] + " " + arr[j] + " " + arr[k] + " \n");
                    bufferedWriter.flush();

                    j++;
                    k--;
                }else if (0 > arr[i] + arr[j] + arr[k]){
                    j++;
                }else {
                    k--;
                }
            }
            i++;
        }

        if (!flag) {
            bufferedWriter.write("No Solution\n");
            bufferedWriter.flush();
        }
    }
}