import java.io.*;
import java.math.BigDecimal;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1082 {

    public static int MAX = 1000001;
    public static boolean[] mark = new boolean[MAX];
    public static long[] num = new long[MAX];

    public static void init() {
        int i, j, cnt=1;
        for (i=7; i<MAX; i+=7){
            mark[i] = true;
        }
        for (i=7; i<MAX; i*=10){
            for (j=0; j<cnt; j++){
                int tmp = i+j;
                while (tmp<MAX){
                    mark[tmp] = true;
                    tmp += cnt*10;
                }
            }
            cnt*=10;
        }
    }

    public static void printTable(){
        long ans = 0;
        for (long i=1; i<MAX; i++){
            if (!mark[(int)i]){
                ans += i*i;
            }
            num[(int)i] = ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        init();
        printTable();

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            int n = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(num[n] + "\n");
            bufferedWriter.flush();
        }
    }


}
