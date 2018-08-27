import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfItem = sc.nextInt();
        int weightOfBag = sc.nextInt();

        int[] weightOfItem = new int[numberOfItem + 1];
        int[] valueOfItem = new int[numberOfItem + 1];

        for (int i = 1; i <= numberOfItem; i++) {
            weightOfItem[i] = sc.nextInt();
            valueOfItem[i] = sc.nextInt();
        }

        // 前i件物品面对总容量为j的背包时，所取得的最大价值
        int[] dp = new int[weightOfBag + 1];

        for (int i = 1; i <= numberOfItem; i++) {
            for (int j = weightOfBag; j >= weightOfItem[i]; j--) {
                // 此时的dp[j] 和 dp[j - weightOfItem[i]]保存的是上一轮的值
                dp[j] = Math.max(dp[j], dp[j - weightOfItem[i]] + valueOfItem[i]);
            }
        }
        System.out.println(dp[weightOfBag]);
    }
}
