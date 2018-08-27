import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        // 数组中保存的是前n项的和
        long[] arrayNumber = new long[n+1];

        for (int i=1; i<=n; i++){
            arrayNumber[i] = arrayNumber[i-1] + Integer.parseInt(reader.readLine());
        }

        int q = Integer.parseInt(reader.readLine());
        while (0 < q--){
            String[] str = reader.readLine().split(" ");
            int begin = Integer.parseInt(str[0]);
            int len = Integer.parseInt(str[1]);
            System.out.println(arrayNumber[begin+len-1] - arrayNumber[begin-1]);
        }

    }
}
