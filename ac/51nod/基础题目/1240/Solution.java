import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1<<16);

        int num = Integer.parseInt(bufferedReader.readLine());
        bufferedWriter.write(Solution.miu(num) + "\n");
        bufferedWriter.flush();
    }

    public static int miu(int n){
        int ant = 0;
        for (int i=2; i<= Math.sqrt(n); i++){
            if(0 == n % i){
                n /= i;
                ant++;
                if (0 == n % i){
                    return 0;
                }
            }
        }
        if (1 < n){
            ant++;
        }
        // 求 & 后，奇数结果为 1 ，偶数结果为 0
        if (1 == (ant & 1)){
            return -1;
        } else {
            return 1;
        }
    }
}
