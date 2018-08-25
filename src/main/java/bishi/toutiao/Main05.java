package bishi.toutiao;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/25
 */
public class Main05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] temp = scanner.nextLine().split("\\s");

        int n = Integer.valueOf(temp[0]);
        int t = Integer.valueOf(temp[1]);
        int[] numbers = new int[n * t];

        temp = scanner.nextLine().split("\\s");
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; ++j) {
                numbers[i * n + j] = Integer.valueOf(temp[j]);
            }
        }

        long ans = lengthOfLIS(numbers);
        System.out.println(ans);
    }

    private static long lengthOfLIS(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }

        long[] dp = new long[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            long max = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        long max = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

}
