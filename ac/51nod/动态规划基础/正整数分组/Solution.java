import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totalNumber = sc.nextInt();
        int[] arrayNumber = new int[totalNumber + 1];
        // 所有数据的总和
        int sum = 0;

        for (int i=1; i<=totalNumber; i++){
            arrayNumber[i] = sc.nextInt();
            sum += arrayNumber[i];
        }

        // 表示从前i个数中选出的数，总和不超过j的时候能得到的最大的和
        int[] dp = new int[1 + sum / 2];
        for (int i=1; i<=totalNumber; i++){
            for (int j=sum/2; j>=arrayNumber[i]; j--){
                dp[j] = Math.max(dp[j], dp[j- arrayNumber[i]] + arrayNumber[i]);
            }
        }

        System.out.println(Math.abs((sum - dp[sum / 2]) - dp[sum / 2]));

    }
}
